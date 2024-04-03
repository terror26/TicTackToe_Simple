package model;

public interface Board {
    boolean place(Symbol symbol,int x,int y);
    boolean initBoard(int n);

    void print();

    boolean winnerExists();

    boolean hasValidMovesLeft();
}
