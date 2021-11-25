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
            System.out.println("Congratulations " + winner() + "!");
        else if (board.gameIsADraw())
            System.out.println("Cat's Game");
    }

    private void turn() {
        int index = getMoveFromPlayer();
        if (board.isValidMove(index)) {
            char token = currentPlayer();
            board.placeToken(index, token);
            turnCount += 1;
            board.display();
        } else {
            // TODO: find better flow for improper inputs in turn()
            System.out.print("Sorry, that space is already taken. ");
            turn();
        }
    }

    // TODO: Write a function that somehow combines currentPlayer and LastPlayer
    private char currentPlayer() {
        char token;
        if (turnCount % 2 == 0)
            token = 'X';
        else
            token = 'O';
        return token;
    }

    /* TODO: refine method so it isn't so much of a hack (we have to decrement turnCount
    so that currentPlayer will return the token of the last player) */
    private char winner() {
        turnCount -= 1;
        return currentPlayer();
    }

    private int getMoveFromPlayer() {
        int input = getInput();
        return inputToIndex(input);
    }

    private int getInput() {
       int input;
        do {
            promptPlayer();
            while (!playerInput.hasNextInt()) {
                String invalidInput = playerInput.next();
                System.out.printf("\"%s\" is not a number. ", invalidInput);
                promptPlayer();
            }
            input = playerInput.nextInt();
            if (input < 1 || input > 9)
                System.out.printf("\"%d\" is out of range. ", input);
        } while (input < 1 || input > 9);
       return input;
    }

    private void promptPlayer() {
        System.out.print("Please enter a number 1 - 9: ");
    }

    private int inputToIndex(int input) {
        return input - 1;
    }
}
