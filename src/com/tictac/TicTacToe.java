package com.tictac;

import java.util.Scanner;

public class TicTacToe {
    Board board;
    Scanner playerInput = new Scanner(System.in);
    int turnCount = 0;

    public TicTacToe() {
        board = new Board();
    }

    public void turn() {
        promptPlayer();
        String input = getInput();
    }



    public char currentPlayer() {
        char token;
        if (turnCount % 2 == 0)
            token = 'X';
        else
            token = 'O';
        return token;
    }

    // TODO: better function name
    public void handlePlayerInput() {
        promptPlayer();
        String input = getInput();
        int index = inputToIndex(input);
    }

    public void promptPlayer() {
        System.out.println("Please enter 1 - 9:");
    }

    public String getInput() {
       String input = playerInput.nextLine();
       return input;
    }

    public int inputToIndex(String input) {
        return Integer.parseInt(input) - 1;
    }
}
