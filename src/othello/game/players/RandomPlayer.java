package othello.game.players;

import java.util.ArrayList;
import java.util.Random;
import othello.UserInterface;
import othello.game.Board;
import othello.game.Player;


public class RandomPlayer extends Player {

    public RandomPlayer(UserInterface UI) {
        super(UI);
    }

    public RandomPlayer(UserInterface UI, String name) {
        super(UI);
        this.name = name;
    }
    

    
    @Override
    public int[] play(ArrayList<int[]> possibleMoves, Board board, String  myColor) {
        if (possibleMoves.isEmpty()) {
            return null;
        } else {
            int indexFromList = new Random().nextInt(possibleMoves.size());
            return possibleMoves.get(indexFromList);
        }
    }
    
}
