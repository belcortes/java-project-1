package com.company.beans;

import java.util.Random;

public class Computer extends Player {
    private String choice;

    public String getChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        // Found this string 'randomizer' online - Stack Overflow
        Random random = new Random();
        choice = choices[random.nextInt(choices.length)];
        return choice;
    }

}
