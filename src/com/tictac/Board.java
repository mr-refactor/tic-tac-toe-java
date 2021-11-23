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
    public char[] state;

    public Board() {
        char[] board = new char[9];
        Arrays.fill(board,' ');
        this.state = board;
    };

    public Board(char[] board) throws Exception {
        if (board.length != 9)
            throw new Exception("Board must have 9 spaces.");
        this.state = board;
    }

    public void display() {
        System.out.println(String.format(" %c | %c | %c", this.state[0], this.state[1], this.state[2]));
        System.out.println("-----------");
        System.out.println(String.format(" %c | %c | %c", this.state[3], this.state[4], this.state[5]));
        System.out.println("-----------");
        System.out.println(String.format(" %c | %c | %c", this.state[6], this.state[7], this.state[8]));
    }


}
