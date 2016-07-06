package othello.uis;

import javax.swing.SwingUtilities;
import othello.UserInterface;
import othello.game.Board;
import othello.game.Othello;
import othello.game.Player;
import othello.uis.visual.*;


public class VisualUI extends UserInterface {
    
    public Frame frame = new Frame();
    
    @Override
    public void ignition() {
        SwingUtilities.invokeLater(frame);
    }

    @Override
    public void setSettings() {
    }

    @Override
    public void newGameInitialized(Othello othello) {
    }

    @Override
    public void newTurn(String playerName) {
    }

    @Override
    public void noLegalsFor(String playerName) {
    }

    @Override
    public void turnPlayed(Player player, Board board, String color) {
    }

    @Override
    public void gameDone() {
    }

    @Override
    public void triedIllegalMove() {
    }

    @Override
    public int[] userMove() {
        return null;
    }

    @Override
    public void lightTiles(int countLight) {
    }

    @Override
    public void darkTiles(int countDark) {
    }

    @Override
    public void winner(Player player1) {
    }

    @Override
    public void draw() {
    }

    @Override
    public String getPlayerName() {
        return "playerName";
    }
    
}
