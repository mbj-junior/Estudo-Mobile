package com.example.treinoboxe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ProgressBar;
import java.util.List;

public class Time extends AppCompatActivity {

    Chronometer chronometer;
    ImageView btnStart, btnPause;
    long time = 0;
    boolean isPause = false;


    private Handler handler;
    private ProgressBar progress;
    private MediaPlayer mp;
    private int numeroDeRounds;
    private MyCountDownTimer timer;
    int tempoDoRestEmSegundos;
    int tempoDoRoundEmSsegundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Intent thisIntent = getIntent();

        btnStart = (ImageView) findViewById(R.id.btnStart);



        //som
        mp = MediaPlayer.create(this, R.raw.gongo);

        TextView tvRoundsTotal = (TextView) findViewById(R.id.tvRoundsTotal);

        //Numero de rounds
        numeroDeRounds = Integer.parseInt(thisIntent.getStringExtra("packNRounds"));
        tvRoundsTotal.setText(Integer.toString(numeroDeRounds));

        //Pegando o tempo e convertendo em segundos
        int minRound = Integer.parseInt(thisIntent.getStringExtra("packMinRound"));
        int segRound = Integer.parseInt(thisIntent.getStringExtra("packSegRound"));
        int minRest = Integer.parseInt(thisIntent.getStringExtra("packMinRest"));
        int segRest = Integer.parseInt(thisIntent.getStringExtra("packSegRest"));
        tempoDoRoundEmSsegundos = (minRound*60) + segRound;
        tempoDoRestEmSegundos = (minRest * 60) + segRest;

    }

    public void start(View view) {
        tocar(this);
        vibrar(this);

        TextView tv = (TextView) findViewById(R.id.txtCronometro);


        for (int i = 0; i < numeroDeRounds; i++) {
            timer = new MyCountDownTimer(this, tv, tempoDoRoundEmSsegundos*1000, 1000);
            timer.start();

            if (tv.getText().equals("00:00")) {
                timer = new MyCountDownTimer(this, tv, tempoDoRestEmSegundos*1000, 1000);
                timer.start();
            }
        }
    }

    public void pause(View view) {
        time = chronometer.getBase() - SystemClock.elapsedRealtime();
        chronometer.stop();
        btnPause.setEnabled(false);
        isPause = true;
    }

    public void irParaRoundSetup(View view) {
        Intent intent = new Intent(Time.this, RoundSetup.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        this.finish();
    }

    public void vibrar(Activity view) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(500);
    }

    public void tocar(Activity view) {
        mp.start();
    }





    @Override
    public void onDestroy(){
        super.onDestroy();

        if(timer != null){
            timer.cancel();
        }
    }

}
