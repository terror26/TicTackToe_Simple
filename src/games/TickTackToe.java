package games;

import model.Board;
import model.Player;
import model.TicTackToeBoard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TickTackToe {
    Board board;
    Deque<Player> playerQueu = new LinkedList<Player>();
    private Scanner scanner = new Scanner(System.in);

    public TickTackToe(int n) { // boardSize
        board = new TicTackToeBoard(n);
    }
    public boolean addPlayer(Player player) {
        return playerQueu.add(player);
    }
    public void startGame() {
        while(board.hasValidMovesLeft() && !board.winnerExists()) {
            Player player = playerQueu.poll();
            System.out.println("Player = " + player.getPlayerName() + " enter x,y position");
            int[] arr = getNextMove(player);
            int x = arr[0];
            int y = arr[1];
            if(board.place(player.getSymbol(), x,y)) { // placed successfully
                playerQueu.addLast(player);
                board.print();
            } else {
                playerQueu.addFirst(player);
                System.out.println("Oope wrong input try again");
            }
        }
        if(board.winnerExists()) {
            System.out.println("Game won by player" + playerQueu.getLast().getPlayerName());
        } else {
            System.out.println("exiting ... ");
        }
    }

    private int[] getNextMove(Player player) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new int[]{x,y};
    }


}


















