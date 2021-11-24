package com.tictac;

public class Board {
    private static final char[] EMPTY_BOARD = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private static final int[][] WIN_COMBINATIONS = {
            // Horizontal Wins
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},

            // Vertical Wins
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},

            // Diagonal Wins
            {0, 4, 8},
            {2, 4, 6}
    };

    private char[] state;

    private static void validateBoard(char[] stateOfBoardInProgress) throws Exception {
        Board.validateLength(stateOfBoardInProgress);
        Board.validateContent(stateOfBoardInProgress);
    }

    private static void validateLength(char[] stateOfBoardInProgress) throws Exception {
        if (stateOfBoardInProgress.length != 9)
            throw new Exception("The board must have exactly 9 spaces.");
    }

    private static void validateContent(char[] stateOfBoardInProgress) throws Exception {
        for (char space : stateOfBoardInProgress) {
            // TODO: check for syntax like if space not in [' ', 'X', 'O']
            if (space == ' ' || space == 'X' || space == 'O')
                continue;
            else
                throw new Exception("The board cannot contain characters other than ' ', 'X', or 'O'");
        }
    }

    public Board() {
        state = EMPTY_BOARD.clone();
    };

    // TODO: Decide to add setStateFromBoardInProgress
    public Board(char[] stateOfBoardInProgress) throws Exception {
        try {
            setStateFromBoardInProgress(stateOfBoardInProgress);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nStarting game with an empty board.");
            state = EMPTY_BOARD.clone();
        }
    }

    public void setStateFromBoardInProgress(char[] stateOfBoardInProgress) throws Exception {
        Board.validateBoard(stateOfBoardInProgress);
        state = stateOfBoardInProgress;
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

    public boolean gameIsOver() {
        return gameIsADraw() || gameIsWon();
    }

    public boolean gameIsADraw() {
        return !gameIsWon() && isFull();
    }

    public boolean gameIsWon() {
        for (int[] combo : WIN_COMBINATIONS ) {
            if (isPositionTaken(combo[0])
                    && allTokensMatch(combo))
                return true;
        }
        return false;
    }

    private boolean allTokensMatch(int[] winCombo) {
        return state[winCombo[0]] == state[winCombo[1]]
                && state[winCombo[1]] == state[winCombo[2]];
    }

    /* TODO: Determine if there is a way to use isPositionTaken() here
        instead of if space == ' ' */
    private boolean isFull() {
        for (char space : state) {
            if (space == ' ')
                return false;
        }
        return true;
    }





}
