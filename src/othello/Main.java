package othello;

import othello.game.*;
import othello.game.players.util.GameSituation;
import othello.uis.*;




public class Main {

    public static void main(String[] args) {
        new GameMaster("textui").run();
        
        //testing();
    }
    
    public static void testing() {
        Board board1 = new Board(4);
        board1.initializeSpots();
        
        Board board2 = new Board(4);
        board2.initializeSpots();
        board2.playSpot(4, 3, "light");
        board2.playSpot(4, 4, "dark");
        board2.playSpot(2, 1, "light");
        
        Settings settings = new Settings();
        TextUI ui = new TextUI();
        Othello othello = new Othello(settings, ui);
        
        GameSituation gs1 = new GameSituation(board1.spots, "light");   
        GameSituation gs2 = new GameSituation(board2.spots, "light");
        
        //System.out.println(othello.possibleMoves(gs1).size());
        System.out.println(othello.possibleMoves(gs2).size());
    }
    
    
    
}
