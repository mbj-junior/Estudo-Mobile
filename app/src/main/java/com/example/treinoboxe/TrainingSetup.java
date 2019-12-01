package com.example.treinoboxe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class TrainingSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_setup);
    }

    public void irParaMainActivity(View view){
        Intent intent = new Intent(TrainingSetup.this, MainActivity.class );
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void irParaTraining(View view){
        Intent intent = new Intent(TrainingSetup.this, Training.class );
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        //pega os valores selecionado no RB
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        int a=0;
        int op = rg.getCheckedRadioButtonId();
        switch (op) {
            case R.id.rbEasy:
                //seta valor que será enviado
                a=0;
                break;
            case R.id.rbNormal:
                //seta valor que será enviado
                a=1;
                break;
            case R.id.rbHard:
                //seta valor que será enviado
                a=2;
                break;
        }

        //add no package
        intent.putExtra("selecionado",String.valueOf(a));

        startActivity(intent);
    }


}
