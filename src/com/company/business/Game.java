package com.company.business;

import com.company.beans.Computer;
import com.company.beans.Player;

import java.util.Scanner;

public class Game {

    private Player player1 = new Player();
    private Player player2 = new Player();
    private Computer computer = new Computer();
    private Player firstPlayer;
    private String firstMove;
    private Player secondPlayer;
    private String secondMove;


    private void setFirstMove(String firstMove) {
        this.firstMove = firstMove;
    }

    private void setSecondMove(String secondMove) {
        this.secondMove = secondMove;
    }


    private void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    private void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public static String userInput() {
        Scanner inputScanner = new Scanner(System.in);
        String userInput = inputScanner.nextLine();

        if(userInput.toLowerCase().equals("quit")){
            System.out.println("\nBye!!");
            System.exit(0);

            return null;
        } else {
            return userInput.toLowerCase();
        }
    }



    private String player1Turn() {
        String player1Input = userInput();
        this.setFirstPlayer(player1);
        player1.setName("Player1");
        String[] choices = {"rock", "paper", "scissors"};

        if(player1Input.equals("rock") || player1Input.equals("paper") || player1Input.equals("scissors") ) {
            player1.setChoice(player1Input);

            return player1Input;
        } else {
            System.out.println("\nInvalid choice, please input 'rock', 'paper', or 'scissors'");
            player1Turn();

            return player1Input;
        }
    }

    public void computerTurn() {
        String player1Input = this.player1Turn();
        player1.setChoice(player1Input);

        this.setFirstMove(player1.getChoice());
        this.setSecondMove(computer.getChoice());
        computer.setName("Computer");
        this.setSecondPlayer(computer);
        this.getWinner();
    }

    public void player2Turn() {
        String player1Input = this.player1Turn();
        player2.setName("Player2");
        this.setSecondPlayer(player2);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPlayer2: type in 'rock', 'paper', or 'scissors' to play AND DON'T SCROLL UP");

        Scanner inputScanner2 = new Scanner(System.in);
        String userInput = inputScanner2.nextLine();
        String userInput2 = userInput.toLowerCase();
        if(userInput2.equals("rock") || userInput2.equals("paper") || userInput2.equals("scissors") ) {
            player2.setChoice(userInput2);
        } else {
            System.out.println("\nInvalid choice, please input 'rock', 'paper', or 'scissors'");
            player2Turn();
        }

        this.setFirstMove(player1.getChoice());
        this.setSecondMove(player2.getChoice());
        this.getWinner();
    }

    private void getWinner() {
        if (firstMove.equals(secondMove)) {
            System.out.println("\nIT'S A TIE!");
            showScore();
        } else if ( ("rock".equals(firstMove) && "scissors".equals(secondMove)) ||
                ("scissors".equals(firstMove) && "paper".equals(secondMove)) ||
                ("paper".equals(firstMove) && "rock".equals(secondMove)) ) {
            System.out.printf("\n%s played: %s\n%s wins!%n", secondPlayer.getName(), secondMove, firstPlayer.getName());

            firstPlayer.addScore();
            showScore();
        } else {
            assert (("rock".equals(secondMove) && "scissors".equals(firstMove)) ||
                    ("scissors".equals(secondMove) && "paper".equals(firstMove)) ||
                    ("paper".equals(secondMove) && "rock".equals(firstMove)));
            System.out.println("\n" + secondPlayer.getName()+" played: " + secondMove);
            System.out.println(secondPlayer.getName()+" wins!");

            secondPlayer.addScore();
            showScore();
        }
    }

    private void showScore() {
        System.out.println("\nScore so far:" +
                "\n"+firstPlayer.getName()+": "+firstPlayer.getScore() +
                "\n"+secondPlayer.getName()+": "+secondPlayer.getScore());
    }
}
