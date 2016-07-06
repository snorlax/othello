package othello.game.players;

import java.util.ArrayList;
import java.util.Scanner;
import othello.UserInterface;
import othello.game.Board;
import othello.game.Player;

public class UserPlayer extends Player {


    public UserPlayer(UserInterface UI) {
        super(UI);
        this.name = UI.getPlayerName();
    }
    
    public UserPlayer(UserInterface UI, String playerName) {
        super(UI);
        this.name = playerName;
    }

    @Override
    public int[] play(ArrayList<int[]> possibleMoves, Board board, String myColor) {
        if (possibleMoves.isEmpty()) {
            return null;
        } else {
            return UI.userMove();
        }
    }

}
