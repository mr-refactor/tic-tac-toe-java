package com.tictac;

public class Main {

    public static void main(String[] args) throws Exception {
        char[] middleGame = {' ', 'X', 'X', 'O', 'O', ' ', ' ', ' '};
        Board board = new Board(middleGame);
        board.display();
    }
}
