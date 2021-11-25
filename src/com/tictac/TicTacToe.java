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
            // TODO: find better flow for improper inputs in turn()
            System.out.print("Sorry, that space is already taken. ");
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
        int input = getInput();
        return inputToIndex(input);
    }

    // TODO: Validate input
    public int getInput() {
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

    public void promptPlayer() {
        System.out.print("Please enter a number 1 - 9: ");
    }

    public int inputToIndex(int input) {
        return input - 1;
    }
}
