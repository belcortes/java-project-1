package com.company.main;

public class Game {
    private Player firstPlayer;
    private String firstMove;
    private String secondPlayer;
    private String secondMove;

    public void getWinner() {
        if (firstMove.equals(secondMove)) {
            System.out.println("IT'S A TIE!");
            showScore();
        } else if ( ("rock".equals(firstMove) && "scissors".equals(secondMove)) ||
                ("scissors".equals(firstMove) && "paper".equals(secondMove)) ||
                ("paper".equals(firstMove) && "rock".equals(secondMove)) ) {
            System.out.println("\n" + secondPlayer+" played: " + secondMove);
            System.out.println(firstPlayer.getName()+" wins!");
            firstPlayer.addScore();
            showScore();
        } else {
            assert (("rock".equals(secondMove) && "scissors".equals(firstMove)) ||
                    ("scissors".equals(secondMove) && "paper".equals(firstMove)) ||
                    ("paper".equals(secondMove) && "rock".equals(firstMove)));
            System.out.println("\n" + secondPlayer+" played: " + secondMove);
            System.out.println(secondPlayer+" wins!");
            showScore();
        }
    }

    private void showScore() {
        System.out.println("\nScore so far:" +
                "\n"+firstPlayer.getName()+": "+firstPlayer.getScore());
    }

    public void setFirstMove(String firstMove) {
        this.firstMove = firstMove;
    }

    public void setSecondMove(String secondMove) {
        this.secondMove = secondMove;
    }


    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(String secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
}
