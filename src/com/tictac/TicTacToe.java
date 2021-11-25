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
        try {
            validateInput(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getMoveFromPlayer();
        }
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

    //TODO: clean up this try block once exceptions are understood better in Java
    private void validateInput(String input) throws Exception {
        if(input.length() != 1)
            throw new Exception("Invalid Input. Must be a number between 1 - 9.");
        else if (!Character.isDigit(input.charAt(0)));
            throw new Exception("Invalid Input. Must be a number between 1 - 9.");
    }

    public int inputToIndex(String input) {
        return Integer.parseInt(input) - 1;
    }
}
