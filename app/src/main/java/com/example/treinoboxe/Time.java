package com.example.treinoboxe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.ProgressBar;

import java.util.List;

public class Time extends AppCompatActivity {

    private Handler handler;
    private ProgressBar progress;
    private double tempoDoRoundEmMilisegundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Intent thisIntent = getIntent();

        TextView tvRoundsTotal = (TextView) findViewById(R.id.tvRoundsTotal);
        TextView etCronometro = (TextView) findViewById(R.id.etCronometro);


        tvRoundsTotal.setText(thisIntent.getStringExtra("packNRounds"));
        etCronometro.setText(thisIntent.getStringExtra("packTempoRound"));

        //Pegando o tempo e convertendo em milisegundo
        int minRound = Integer.parseInt(thisIntent.getStringExtra("packMinRound"));
        int segRound = Integer.parseInt(thisIntent.getStringExtra("packSegRound"));
        int minRest = Integer.parseInt(thisIntent.getStringExtra("packMinRest"));
        int segRest = Integer.parseInt(thisIntent.getStringExtra("packSegRest"));
        tempoDoRoundEmMilisegundos = ((minRound*60)+segRound)/0.1;

        //Barra de progresso
        progress = (ProgressBar) findViewById(R.id.progress_bar);
        handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    final int value = i;
                    try {
                        //define 1/10 segundo como o tempo para a barra
                        Thread.sleep((long)tempoDoRoundEmMilisegundos);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //define o valor para a barra
                            progress.setProgress(value);
                        }
                    });
                }
            }
        };
        new Thread(runnable).start();



    }

    public void irParaRoundSetup(View view) {
        Intent intent = new Intent(Time.this, RoundSetup.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        this.finish();
    }

}
