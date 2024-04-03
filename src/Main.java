import games.TickTackToe;
import model.Player;
import model.Symbol;

public class Main {
    public static void main(String[] args) {
        TickTackToe tickTackToe = new TickTackToe(3);
        tickTackToe.addPlayer(new Player("Kanishk", Symbol.X));
        tickTackToe.addPlayer(new Player("Nidhi", Symbol.O));
        tickTackToe.startGame();
    }
}