package com.example.treinoboxe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RoundSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_setup);
    }

    public void irParaMainActivity(View view){
        Intent intent = new Intent(RoundSetup.this, MainActivity.class );
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void irParaTime(View view){
        Intent intent = new Intent(RoundSetup.this, Time.class );
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        //Pega os valores
        EditText etMinuto = (EditText) findViewById(R.id.etCronometro);
        EditText etSegundo = (EditText) findViewById(R.id.etSegundo);
        EditText etMinuto2 = (EditText) findViewById(R.id.etMinuto2);
        EditText etSegundo2 = (EditText) findViewById(R.id.etSegundo2);
        EditText etRounds = (EditText) findViewById(R.id.etRounds);


        intent.putExtra("packMinRound",etMinuto.getText().toString());
        intent.putExtra("packSegRound",etSegundo.getText().toString());
        intent.putExtra("packMinRest",etMinuto2.getText().toString());
        intent.putExtra("packSegRest",etSegundo2.getText().toString());
        intent.putExtra("packNRounds",etRounds.getText().toString());

        startActivity(intent);
    }

}
