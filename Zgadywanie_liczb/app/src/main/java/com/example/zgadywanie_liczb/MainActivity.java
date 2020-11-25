package com.example.zgadywanie_liczb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //deklaracja zmiennych różnego typu
    int value1; //zmienna tymczasowa na wylosowany początek przedziału
    int value2; //zmienna tymczasowa na wylosowany koniec przedziału
    int value3; //zmienna tymczasowa na wylosowaną wartość szukaną
    int range;  //wyliczony zakres przedziału wartości szukanej
    Counter counter = new Counter(); //obiekt obsługujący liczniki gry
    TextView currentScore; //aktualny wynik w próbach
    TextView highScore; //najlepszy wynik
    TextView currentHighScore; //aktualny wynik w formacie najlepszego wyniku liczonego jako 1/liczba prób * range *10000
    TextView Answer; //pole kompatybilne z formatką
    EditText Attempt; //pole kompatybilne z formatką


    @Override
    protected void onCreate(Bundle savedInstanceState) {                        //uchwyt do zdarzenia odpalający się przy tworzeniu instancji aplikacji
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNewNumbers();                                                        //odwołanie do metody setNewNumbers zdefiniowanej niżej
        highScore = findViewById(R.id.highScore);                               //odwołanie się do kontrolki TextView po jej ID
        highScore.setText("" + 0);                                              //wartość domyślna
        currentScore = findViewById(R.id.currentScore);
        currentScore.setText("" + 0);
        currentHighScore = findViewById(R.id.currentHighScore);
        highScore.setText("" + 0);
        Answer = findViewById(R.id.Answer);
        Attempt = findViewById(R.id.Attempt);
    }

    public void onSubmitClick(View view) { //event handler po kliknięciu kontrolki przycisku Submit
        int userAnswer = 100; //inicjalizacja wartością spoza zakresu przeszukiwań
        try { //obsługa braku wartości na wejściu; walidacja wejścia
            userAnswer = Integer.parseInt(Attempt.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        currentScore.setText("" + counter.addAndReturnCurrentScore()); //wyświetlenie obecnego wyniku w ilości prób
        currentHighScore.setText("" + counter.getCurrentHighScore(range)); //wyświetlenie obecnego wyniku w formacie highScore


        if (userAnswer == value3) { //walidacja poprawności odpowiedzi gracza
            Answer.setText("Gratulacje! Odpowiedzią było: " + value3);
            highScore.setText("" + (int) counter.calculateHighScore(counter.getCurrentScore(), range));
            setNewNumbers();
            currentScore.setText("" + 0);

        } else if (userAnswer > value3) {
            Answer.setText("Liczba jest mniejsza od podanej odpowiedzi");
        } else if (userAnswer < value3) {
            Answer.setText("Liczba jest większa od podanej odpowiedzi");
        } else {
            Answer.setText("Wrong, the correct answer was: " + value3);
        }
    }

    public void onExitClick(View view) { //ręczne wyjście z aplikacji
        finish();
    }

    public void setNewNumbers() { //inicjalizacja liczników oraz wartości liczbowych wykorzystywanych w grze
        Random r = new Random();
        value1 = r.nextInt(10); //min
        value3 = value1 + r.nextInt(10); //cel
        value2 = value3 + r.nextInt(10); //max

        range = value2 - value1;
        TextView Number1 = findViewById(R.id.Number1);
        Number1.setText("" + value1);
        TextView Number2 = findViewById(R.id.Number2);
        Number2.setText("" + value2);
        TextView Number3 = findViewById(R.id.Number3);
        Number3.setText("" + value3);
        EditText Attempt = findViewById(R.id.Attempt);
        Attempt.setText("");
        counter.resetCurrentScore();

    }
}
