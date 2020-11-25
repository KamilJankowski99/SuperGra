package com.example.zgadywanie_liczb;

public class Counter{
        private int highScore;
        private int currentScore;

    public Counter() {
        highScore = 0;
        currentScore = 0;
    }

    public int getHighScore() {
            return this.highScore;
        }

public void  setHighScore(int newScore){
        this.highScore = newScore;

}
    public int addAndReturnCurrentScore(){
        this.currentScore++;
        return this.currentScore;
    }

    public void resetCurrentScore(){
        this.currentScore = 0;
    }

    public double calculateHighScore(int score, int range){
        double result;
        result = (score / range) * 10000;
        return result;
    }

    public int getCurrentScore(){
        return this.currentScore;
    }

    }
