package com.company.beans;

public class Player {
    private int score = 0;
    private String choice;
    private String name;

    public int getScore() {
        return score;
    }

    public void addScore() {
        score++;
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
