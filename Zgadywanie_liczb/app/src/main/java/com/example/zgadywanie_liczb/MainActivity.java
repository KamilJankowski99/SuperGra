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
    int range;
    Counter counter = new Counter();
    TextView currentScore;
    TextView highScore;
    TextView currentHighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNewNumbers();
        highScore = findViewById(R.id.highScore);
        highScore.setText(""+ 0);
        currentScore = findViewById(R.id.currentScore);
        currentScore.setText(""+ 0);
        currentHighScore = findViewById(R.id.currentHighScore);
        highScore.setText(""+ 0);
    }

    public void onSubmitClick (View view){
        TextView Answer = findViewById(R.id.Answer);
        EditText Attempt = findViewById(R.id.Attempt);
        int userAnswer = Integer.parseInt(Attempt.getText().toString());
        currentScore.setText(""+ counter.addAndReturnCurrentScore());
        currentHighScore.setText(""+ counter.getCurrentHighScore(range));


        if(userAnswer == value3) {
            Answer.setText("Gratulacje! Odpowiedzią było: " +value3);
            highScore.setText(""+ (int)counter.calculateHighScore(counter.getCurrentScore(), range));
            setNewNumbers();
            currentScore.setText(""+ 0);

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

    public void setNewNumbers () {
        Random r = new Random();
        value1 = r.nextInt(10); //min
        value3 = value1 + r.nextInt(10); //cel
        value2 = value3 + r.nextInt(10); //max

        range = value2 - value1;
        TextView Number1 = findViewById(R.id.Number1);
        Number1.setText(""+value1);
        TextView Number2 = findViewById(R.id.Number2);
        Number2.setText(""+value2);
        TextView Number3 = findViewById(R.id.Number3);
        Number3.setText(""+value3);
        EditText Attempt = findViewById(R.id.Attempt);
        Attempt.setText("");
        counter.resetCurrentScore();

    }
}
