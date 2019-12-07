package com.example.treinoboxe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class Training extends AppCompatActivity {

    private int op;
    private MediaPlayer mp;
    private MyCountDownTimer timer;
    Chronometer chronometer;
    private int tempoDoRestEmSegundos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Intent thisIntent=getIntent();
        op = Integer.parseInt(thisIntent.getStringExtra("selecionado"));
        mp = MediaPlayer.create(this, R.raw.gongo);

        TextView tvNumeros = (TextView) findViewById(R.id.tvJabs);
        TextView tvTime =  (TextView) findViewById(R.id.etCronometro);

        if (op==0){
            tvNumeros.setText(String.valueOf(100));
            tvTime.setText("05:00");
            tempoDoRestEmSegundos = 5*60;
        }if (op==1){
            tvNumeros.setText(String.valueOf(200));
            tvTime.setText("03:00");
            tempoDoRestEmSegundos = 3*60;
        }if (op==2){
            tvNumeros.setText(String.valueOf(300));
            tvTime.setText("02:00");
            tempoDoRestEmSegundos = 2*60;
        }

    }

    public void irParaTrainingSetup(View view){
        Intent intent = new Intent(Training.this, TrainingSetup.class );
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        this.finish();
    }

    private void modoDeTreino (int opcao){

    }

    public void start(View view) {
        tocar(this);
        vibrar(this);

        TextView tv = (TextView) findViewById(R.id.etCronometro);

                timer = new MyCountDownTimer(this, tv, tempoDoRestEmSegundos*1000, 1000);
                timer.start();


    }

    public void vibrar(Activity view) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(500);
    }

    public void tocar(Activity view) {
        mp.start();
    }




}
