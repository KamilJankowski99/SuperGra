package com.example.zgadywanie_liczb;

public class Counter {
    private int highScore;
    private int currentScore;
    private int currentHighScore;

    public Counter() {
        highScore = 0;
        currentScore = 0;
        currentHighScore = 0;
    }

    public int getHighScore() {

        return this.highScore;
    }

    public void setHighScore(int newScore) {
        if (newScore > getHighScore()) {
            this.highScore = newScore;
        }

    }

    public int addAndReturnCurrentScore() {
        this.currentScore++;
        return this.currentScore;
    }

    public void resetCurrentScore() {
        this.currentScore = 0;
    }

    public double calculateHighScore(int score, int range) {
        double result;
        result = ((1 / (double) score) * (double) range) * 10000d;
        return result;
    }

    public int getCurrentScore() {
        return this.currentScore;
    }

    public int getCurrentHighScore(int range) {
        this.currentHighScore = (int) this.calculateHighScore(this.getCurrentScore(), range);
        return this.currentHighScore;
    }

}
