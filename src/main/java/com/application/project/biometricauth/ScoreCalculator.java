package com.application.project.biometricauth;
//simple class to calculate the score as a percentage
public class ScoreCalculator {

    public static float getScore(int correctAnswers,int totalQuestion){//takes in two arguments, and returns the score
        float amountOfCorrectAnswers = Float.valueOf(correctAnswers);//basically, total correct answers / total questions asked
        float totalQuestions = Float.valueOf(totalQuestion);
        float score = (amountOfCorrectAnswers/totalQuestions)*100;
        return score;

    }
}

