package com.tictac;

import java.util.Arrays;

public class Board {
    private static int[][] WIN_COMBINATIONS = {
            // Horizontal Wins
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 9},

            // Vertical Wins
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 9},

            // Diagonal Wins
            {0, 4, 9},
            {2, 4, 6}
    };
    private static char[] EMPTY_BOARD = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    public char[] state;

    public Board() {
        state = EMPTY_BOARD;
    };

    public Board(char[] board) throws Exception {
        try {
            if (board.length != 9)
                throw new Exception("Board must have 9 spaces. " +
                        "Initializing with an empty board.");
            state = board;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            state = EMPTY_BOARD;
        }
    }

    public void display() {
        System.out.println(String.format(" %c | %c | %c",
                this.state[0], this.state[1], this.state[2]));
        System.out.println("-----------");
        System.out.println(String.format(" %c | %c | %c",
                this.state[3], this.state[4], this.state[5]));
        System.out.println("-----------");
        System.out.println(String.format(" %c | %c | %c",
                this.state[6], this.state[7], this.state[8]));
    }

    public boolean isPositionTaken(int index) {
        return !(state[index] == ' ');
    }

    public boolean isValidMove(int index) {
        return (index >= 0 && index <= 8)
                && (!isPositionTaken(index));
    }

    public void placeToken(int index, char token) {
        state[index] = token;
    }



}
