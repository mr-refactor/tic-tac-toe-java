package com.tictac;

import java.util.Scanner;

public class TicTacToe {
    Board board;
    Scanner playerInput = new Scanner(System.in);
    int turnCount;

    public TicTacToe() {
        board = new Board();
        turnCount = 0;
    }

    public void play() {
        while (!board.gameIsOver())
            turn();

        if (board.gameIsWon())
            System.out.println("Congratulations " + currentPlayer() + "!");
        else if (board.gameIsADraw())
            System.out.println("Cat's Game");
    }

    public void turn() {
        int index = getMoveFromPlayer();
        if (board.isValidMove(index)) {
            char token = currentPlayer();
            board.placeToken(index, token);
            turnCount += 1;
            board.display();
        } else {
            turn();
        }
    }

    // TODO: Write a function that somehow combines currentPlayer and LastPlayer
    public char currentPlayer() {
        char token;
        if (turnCount % 2 == 0)
            token = 'X';
        else
            token = 'O';
        return token;
    }

    // TODO: better function name
    public int getMoveFromPlayer() {
        promptPlayer();
        String input = getInput();
        return inputToIndex(input);
    }

    public void promptPlayer() {
        System.out.println("Please enter 1 - 9:");
    }

    // TODO: Validate input
    public String getInput() {
       String input = playerInput.nextLine();
       return input;
    }

    public int inputToIndex(String input) {
        return Integer.parseInt(input) - 1;
    }
}
