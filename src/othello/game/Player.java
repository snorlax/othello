package othello.game;

import java.util.ArrayList;
import java.util.Random;
import othello.UserInterface;

public abstract class Player {
    public String name;
    public UserInterface UI;

    public Player(UserInterface UI) {
        this.UI = UI;
        name = "random" + new Random().nextInt(1000000);
    }
    public Player(UserInterface UI, String name) {
        this.UI = UI;
        this.name = name;
    }
    
    
    

    public abstract int[] play(ArrayList<int[]> possibleMoves, Board board, String myColor); // if can't return null
    
}
