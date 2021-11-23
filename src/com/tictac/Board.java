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
    public char[] layout;

    public Board() {
        char[] board = new char[9];
        Arrays.fill(board,' ');
        this.layout = board;
    };


}
