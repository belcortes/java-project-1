package com.company.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Computer computer = new Computer();
        Game game  = new Game();

        client(player1, player2,computer, game);
    }


    private static void client(Player player1, Player player2, Computer computer, Game game) {
        System.out.println("\nWelcome to Rock Paper Scissors!" +
                "\nMAIN MENU\n====" +
                "\n1. Type 'human' to play against another human" +
                "\n2. Type 'computer' to play against the computer" +
                "\n3. Type 'quit' at any point to stop playing");

        String userInput = userInput();

        switch (userInput) {
            case "human":
                System.out.println("\n Whoever goes first is Player1, whoever goes second is Player2"+
                                   "\nPlayer1: type in 'rock', 'paper', or 'scissors' to play and pass computer to Player2");
                humanTurn(player1, player2, game);
                playAgain(player1, player2, computer, game);
                break;
            case "computer":
                System.out.println("\nType in 'rock', 'paper', or 'scissors' to play");
                computerTurn(player1, computer, game);
                playAgain(player1, player2, computer, game);
                break;
            case "quit":
                System.out.println("\nquitting the game\nBye!!");
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid input, please type a valid option");
                client(player1, player2,computer, game);
                break;
        }
    }

    private static String userInput() {
        Scanner inputScanner = new Scanner(System.in);
        String userInput = inputScanner.nextLine();

        return userInput.toLowerCase();
    }

    private static String computerTurn(Player player, Computer computer, Game game) {
        String userInput = userInput();

        player.setName("Player1");

        if(userInput.equals("rock") || userInput.equals("paper") || userInput.equals("scissors") ) {
            player.setChoice(userInput);

            game.setFirstPlayer(player);
            game.setSecondPlayer("Computer");
            game.setFirstMove(player.getChoice());
            game.setSecondMove(computer.getChoice());
            game.getWinner();

            return userInput;
        } else {
            System.out.println("\nInvalid choice, please input 'rock', 'paper', or 'scissors'");
            computerTurn(player, computer, game);

            return userInput;
        }

    }

    private static void humanTurn(Player player1, Player player2, Game game) {
        player1.setName("Player1");
        player2.setName("Player2");
        game.setFirstPlayer(player1);
        game.setSecondPlayer(player2.getName());

        String user1Input = userInput();

        if(user1Input.equals("rock") || user1Input.equals("paper") || user1Input.equals("scissors") ) {
            player1.setChoice(user1Input);
        } else {
            System.out.println("\nInvalid choice, please input 'rock', 'paper', or 'scissors'");
            humanTurn(player1, player2, game);
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\nPlayer2: type in 'rock', 'paper', or 'scissors' to play");

        Scanner inputScanner2 = new Scanner(System.in);
        String userInput2 = inputScanner2.nextLine();
        String luserInput2 = userInput2.toLowerCase();
        if(userInput2.equals("rock") || userInput2.equals("paper") || userInput2.equals("scissors") ) {
            player2.setChoice(userInput2);
        } else {
            System.out.println("\nInvalid choice, please input 'rock', 'paper', or 'scissors'");
            humanTurn(player1, player2, game);
        }

        game.setFirstMove(player1.getChoice());
        game.setSecondMove(player2.getChoice());
        game.getWinner();
    }

    private static void playAgain(Player player1, Player player2, Computer computer, Game game) {
        System.out.println("\n\nDo you want to play again?");

        String userInput = userInput();

        if(userInput.equals("yes")) {
            client(player1, player2,computer, game);
        } else if(userInput.equals("no")) {
            System.out.println("\nBye!!");
            System.exit(0);
        } else {
            System.out.println("\nI didn't quite get that..");
            playAgain(player1, player2, computer, game);
        }
    }

}
