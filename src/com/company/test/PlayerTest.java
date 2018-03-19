package com.company.test;

import com.company.beans.Player;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    private Player testPlayer;

    @Before
    public void setUp() {
        testPlayer = new Player();
    }

    @Test
    public void getChoice_successfullyGetsChoice() {
        testPlayer.setChoice("rock");

        assertEquals(testPlayer.getChoice(), "rock");
    }

    @Test
    public void getName_successfullyGetsName() {
        testPlayer.setName("test player 1");

        assertEquals(testPlayer.getName(), "test player 1");
    }

    @Test
    public void addScore_successfullyAddsScore() {
        assertEquals(testPlayer.getScore(), 0);

        testPlayer.addScore();
        assertEquals(testPlayer.getScore(), 1);
    }
}
