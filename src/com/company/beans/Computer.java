package com.company.beans;

import java.util.Random;

public class Computer extends Player {
    private String choice;

    public String getChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        choice = choices[random.nextInt(choices.length)];
        return choice;
    }

    public void addScore() {
        super.addScore();
//        score++;
    }

}
