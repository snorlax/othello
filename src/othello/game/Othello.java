package othello.game;

import java.util.ArrayList;
import othello.Settings;
import othello.UserInterface;
import othello.game.players.*;
import othello.game.players.util.GameSituation;


public class Othello {
    public Board board;
    public Player player1;
    public Player player2;

    public Othello(Settings settings, UserInterface UI) {
        board = new Board(settings.boardSize);
        player1 = createPlayerByType(settings.playerType1, UI, "light");
        player2 = createPlayerByType(settings.playerType2, UI, "dark");
    }

    private Player createPlayerByType(String playerType, UserInterface UI, String color) {
        switch (playerType) {
            case "user": return new UserPlayer(UI, "user");
            case "random": return new RandomPlayer(UI, "randomPlayer");
            case "minimaxAllTheWay": return new MinimaxAllTheWayPlayer(UI, "minimaxATWPLayer", this, color);
            default: return new UserPlayer(UI, "user");
        }
    }

    public int[] playPlayer1Turn() {
        return player1.play(possibleMoves("light"), board, "light");
    }
    public int[] playPlayer2Turn() {
        return player2.play(possibleMoves("dark"), board, "light");
    }

    public boolean checkIfLegal(int[] spot, String color) {
        for (int[] possibleSpot : possibleMoves(color)) {
            if (spot[0] == possibleSpot[0] && spot[1] == possibleSpot[1]) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<int[]> possibleMoves(String color) {
        ArrayList<int[]> list = new ArrayList<>();
        
        for (int y = 1; y <= board.size; y++) {
            for (int x = 1; x <= board.size; x++) {
                if (board.readSpot(x, y).equals("empty")) {
                    if (board.hasConsequences(new Tile(x, y, color))) {
                        int[] letsAdd = {x, y};
                        list.add(letsAdd);
                    }
                }
            }
        }
        
        return list;
    }
    public ArrayList<int[]> possibleMoves(GameSituation gs) {
        String[][] oldSpots = board.spots;
        
        board.spots = gs.spots;
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for (int y = 1; y <= board.size; y++) {
            for (int x = 1; x <= board.size; x++) {
                if (board.readSpot(x, y).equals("empty")) {
                    if (board.hasConsequences(new Tile(x, y, gs.turnColor))) {
                        int[] letsAdd = {x, y};
                        list.add(letsAdd);
                    }
                }
            }
        }
        
        board.spots = oldSpots;
        return list;
    }
}
