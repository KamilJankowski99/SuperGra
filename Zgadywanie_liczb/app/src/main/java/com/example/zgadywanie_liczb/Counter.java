package com.example.zgadywanie_liczb;

public class Counter { //klasa obsługująca liczniki gry
    private int highScore;
    private int currentScore; //aktualny wynik jako liczbę prób//najlepszy wynik w formacie najlepszego wyniku liczonego jako 1/liczba prób * range *10000
    private int currentHighScore; //aktualny wynik w formacie najlepszego wyniku liczonego jako 1/liczba prób * range *10000

    public Counter() { //konstruktor klasy Counter
        highScore = 0; //inicjalizacje zmiennych
        currentScore = 0;
        currentHighScore = 0;
    }

    public int getHighScore() { //metoda zwracająca najlepszy wynik

        return this.highScore;
    }

    public void setHighScore(int newScore) { //metoda ustawiająca najlepszy wynik
        if (newScore > getHighScore()) {
            this.highScore = newScore;
        }

    }

    public int addAndReturnCurrentScore() { //metoda zwracająca liczbę prób
        this.currentScore++;
        return this.currentScore;
    }

    public void resetCurrentScore() { //metoda resetująca licznik prób
        this.currentScore = 0;
    }

    public double calculateHighScore(int score, int range) { //najlepszy wynik w formacie najlepszego wyniku liczonego jako 1/liczba prób * range *10000
        double result;
        result = ((1 / (double) score) * (double) range) * 10000d;
        return result;
    }

    public int getCurrentScore() { //metoda zwracająca obecną ilość prób
        return this.currentScore;
    }

    public int getCurrentHighScore(int range) { //metoda zwracająca obecny wynik liczbowy
        this.currentHighScore = (int) this.calculateHighScore(this.getCurrentScore(), range);
        return this.currentHighScore;
    }

}
