package othello;

import othello.game.Board;
import othello.game.Othello;
import othello.game.Player;


public abstract class UserInterface {

    public abstract void setSettings();
    
    public abstract void newGameInitialized(Othello othello);

    public abstract void newTurn(String playerName);

    public abstract void noLegalsFor(String playerName);
    
    public abstract void triedIllegalMove();

    public abstract void turnPlayed(Player player, Board board, String color);

    public void lightTurnPlayed(Player player, Board board) {
        turnPlayed(player, board, "light");
    }
    
    public void darkTurnPlayed(Player player, Board board) {
        turnPlayed(player, board, "dark");
    }
    

    public abstract void gameDone();

    public abstract int[] userMove();

    public abstract void lightTiles(int countLight);

    public abstract void darkTiles(int countDark);

    public abstract void winner(Player player1);

    public abstract void draw();

    public abstract void ignition();

    public abstract String getPlayerName();

    public void preparingBotPlayer(Player player) {
    }


    
    
}
