package com.example.zgadywanie_liczb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int value1;
    int value2;
    int value3;
    Counter counter = new Counter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNewNumbers();
        TextView highScore = findViewById(R.id.highScore);
        highScore.setText(""+ counter.getHighScore());
    }

    public void onSubmitClick (View view){
        TextView Answer = findViewById(R.id.Answer);
        EditText Attempt = findViewById(R.id.Attempt);
        int userAnswer = Integer.parseInt(Attempt.getText().toString());

        if(userAnswer == value3) {
            Answer.setText("Gratulacje! Odpowiedzią było: " +value3);
            setNewNumbers();
        } else if(userAnswer > value3) {
            Answer.setText("Liczba jest mniejsza od podanej odpowiedzi");
        }
          else if(userAnswer < value3){
              Answer.setText("Liczba jest większa od podanej odpowiedzi");
        }
        else {
            Answer.setText("Wrong, the correct answer was: " + value3);
        }
    }

    public void onExitClick(View view){
        finish();
    }

    private void setNewNumbers () {
        Random r = new Random();
        value3 = r.nextInt(10);
        value1 = r.nextInt(value3 - value1) + value1;
        value2 = value3 + r.nextInt(10);
        TextView Number1 = findViewById(R.id.Number1);
        Number1.setText(""+value1);
        TextView Number2 = findViewById(R.id.Number2);
        Number2.setText(""+value2);
        TextView Number3 = findViewById(R.id.Number3);
        //Number3.setText(""+value3);
        EditText Attempt = findViewById(R.id.Attempt);
        Attempt.setText("");

    }
}
