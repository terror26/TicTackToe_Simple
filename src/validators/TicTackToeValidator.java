package validators;

import model.Board;
import model.Player;
import model.Symbol;

public class TicTackToeValidator implements Validator {
    Symbol[][] board;
    public TicTackToeValidator(Symbol[][] board) {
        this.board = board;
    }

    @Override
    public boolean isOpenPosition(int x, int y) {
        return (board[x][y] == null);
    }

    @Override
    public Player GameWonBy() {
        return null;
    }

    @Override
    public boolean checkWinner() {
        int n = board.length;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                if(board[i][j] != null) {
                    if(diagonal(i,j,board[i][j]) || row(i,j, board[i][j]) || col(i,j,board[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean diagonal(int x, int y, Symbol symbol) {
        for(int i = 0;i<3;i++) {
            int xnew = x + i;
            int ynew = y+i;
            if(!isValid(xnew,ynew,board.length) || board[xnew][ynew] != symbol) return false;
        }
        return true;
    }
    private boolean row(int x, int y, Symbol symbol) {
        for(int i = 0;i<3;i++) {
            int xnew = x + i;
            if(!isValid(xnew,y,board.length) || board[xnew][y] != symbol) return false;
        }
        return true;
    }

    private boolean col(int x, int y, Symbol symbol) {
        for(int i = 0;i<3;i++) {
            int ynew = y+i;
            if(!isValid(x,ynew,board.length) || board[x][ynew] != symbol) return false;
        }
        return true;
    }

    public boolean isValid(int x,int y,int n) {
        return x>=0 && y>=0 && x<n && y<n;
    }

}
