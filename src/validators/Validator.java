package validators;

import model.Player;

public interface Validator {
    boolean isOpenPosition(int x,int y);
    Player GameWonBy();

    boolean checkWinner();
}
