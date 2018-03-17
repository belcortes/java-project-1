package com.company.main;

import java.util.LinkedList;
import java.util.Random;

public class Computer {
    private static int score = 0;
    private String choice;

    public int getScore() {
        return score;
    }

    public void addScore() {
        this.score++;
    }

    public String getChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        choice = choices[random.nextInt(choices.length)];
        return choice;
    }

}
