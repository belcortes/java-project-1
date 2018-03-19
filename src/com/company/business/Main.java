package com.company.business;

import com.company.beans.Computer;

import static com.company.business.Game.userInput;

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

        String userInput = userInput();

        if (userInput != null) {
            switch (userInput) {
                case "human":
                    game.player2Turn();
                    playAgain(game);
                    break;
                case "computer":
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
        } else {
            throw new AssertionError();
        }
    }

    private static void playAgain(Game game) {
        System.out.println("\n\nDo you want to play again?"+
                "\n'yes' to replay against "+game.secondPlayer.getName()+
                "\n'no' to return to main menu");

        String userInput = userInput();

        if (userInput != null) {
            switch (userInput) {
                case "yes":
                    if (game.secondPlayer instanceof Computer) {
                        game.computerTurn();
                    } else {
                        game.player2Turn();
                    }
                    break;
                case "no":
                    client(game);
                    break;
                default:
                    System.out.println("\n\nI didn't quite get that..");
                    playAgain(game);
                    break;
            }
        } else {
            throw new AssertionError();
        }
    }


}
