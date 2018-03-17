package com.company.main;

import java.util.LinkedList;

public class Player {
    private static int score = 0;
    private String choice;
    private String name;

    public int getScore() {
        return score;
    }

    public void addScore() {
        this.score++;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
