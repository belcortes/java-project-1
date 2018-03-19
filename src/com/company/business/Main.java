package com.company.business;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game  = new Game();

        client(game);
    }


    private static void client(Game game) {
        System.out.println("\nWelcome to Rock Paper Scissors!" +
                "\nMAIN MENU\n====" +
                "\n1. Type 'human' to play against another human" +
                "\n2. Type 'computer' to play against the computer" +
                "\n3. Type 'quit' at any point to stop playing");

        String userInput = game.userInput();

        switch (userInput) {
            case "human":
                System.out.println("\n Whoever goes first is Player1, whoever goes second is Player2"+
                                   "\nPlayer1: type in 'rock', 'paper', or 'scissors' to play and pass computer to Player2");
                game.player2Turn();
                playAgain(game);
                break;
            case "computer":
                System.out.println("\nType in 'rock', 'paper', or 'scissors' to play");
                game.computerTurn();
                playAgain(game);
                break;
            case "quit":
                System.out.println("\nquitting the game\nBye!!");
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid input, please type a valid option");
                client(game);
                break;
        }
    }


    private static void playAgain( Game game) {
        System.out.println("\n\nDo you want to play again?");

        String userInput = game.userInput();

        if(userInput.equals("yes")) {
            client(game);
        } else if(userInput.equals("no")) {
            System.out.println("\nBye!!");
            System.exit(0);
        } else {
            System.out.println("\nI didn't quite get that..");
            playAgain(game);
        }
    }



}
