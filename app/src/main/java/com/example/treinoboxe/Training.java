package com.example.treinoboxe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Training extends AppCompatActivity {

    private int op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Intent thisIntent=getIntent();
        op = Integer.parseInt(thisIntent.getStringExtra("selecionado"));

        TextView tvNumeros = (TextView) findViewById(R.id.tvJabs);
        TextView tvTime =  (TextView) findViewById(R.id.etCronometro);

        if (op==0){
            tvNumeros.setText(String.valueOf(100));
            tvTime.setText("05:00");
        }if (op==1){
            tvNumeros.setText(String.valueOf(200));
            tvTime.setText("03:00");
        }if (op==2){
            tvNumeros.setText(String.valueOf(300));
            tvTime.setText("02:00");
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


}
