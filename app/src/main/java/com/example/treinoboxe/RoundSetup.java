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
        EditText tpround = (EditText) findViewById(R.id.etTime);
        EditText tprest = (EditText) findViewById(R.id.etRest);
        EditText nrounds = (EditText) findViewById(R.id.etRounds);

        intent.putExtra("packTempoRound",String.valueOf(tpround));
        intent.putExtra("packTempoRest",String.valueOf(tprest));
        intent.putExtra("packNRounds",String.valueOf(tpround));

        startActivity(intent);
    }

}
