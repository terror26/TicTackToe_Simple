package model;

import validators.TicTackToeValidator;
import validators.Validator;

public class TicTackToeBoard implements Board {

    Symbol[][] board;
    Validator validator;

    int moves;

    public TicTackToeBoard(int n) {
        initBoard(n);
        moves = n*n;
        initializeValidator(board);
    }


    private void initializeValidator(Symbol[][] board) {
        validator = new TicTackToeValidator(board);
    }

    @Override
    public boolean place(Symbol symbol, int x, int y) { // placed then return true
        if (validator.isOpenPosition(x, y)) {
            this.board[x][y] = symbol;
            moves--;
            return true;
        }
        return false;
    }

    @Override
    public boolean initBoard(int n) {
        board = new Symbol[n][n];
        return true;
    }

    @Override
    public void print() {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + "   ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean winnerExists() {

        boolean exists = validator.checkWinner(); // won
        return exists;
    }

    @Override
    public boolean hasValidMovesLeft() {
        return moves > 0 ;
    }

}
