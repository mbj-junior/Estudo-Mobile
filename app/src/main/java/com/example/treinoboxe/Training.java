package com.example.treinoboxe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Training extends AppCompatActivity {

    int op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Intent thisIntent=getIntent();
        op = Integer.parseInt(thisIntent.getStringExtra("selecionado"));

        EditText etNumeros = (EditText) findViewById(R.id.etNumeros);
        EditText etTime2 =  (EditText) findViewById(R.id.etTime2);

        if (op==0){
            etNumeros.setText(String.valueOf(100));
            etTime2.setText("05:00");
        }if (op==1){
            etNumeros.setText(String.valueOf(200));
            etTime2.setText("03:00");
        }if (op==2){
            etNumeros.setText(String.valueOf(300));
            etTime2.setText("02:00");
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
