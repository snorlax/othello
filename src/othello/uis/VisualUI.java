package othello.uis;

import java.awt.Color;
import javax.swing.SwingUtilities;
import othello.UserInterface;
import othello.game.Board;
import othello.game.Othello;
import othello.game.Player;
import othello.uis.visual.*;


public class VisualUI extends UserInterface {
    
    public VisualBoard vb;
    public TextFlash tf1;
    public TextFlash tf2;
    public Frame frame;
    
    
    @Override
    public void ignition() {
        vb = new VisualBoard();
        tf1 = new TextFlash(5000, 5000, "");
        tf2 = new TextFlash(5000, 5000, "");
        frame = new Frame(vb);
        SwingUtilities.invokeLater(frame);
    }

    @Override
    public void setSettings() {
    }

    @Override
    public void newGameInitialized(Othello othello) {
        vb.grid.x = 50;
        vb.grid.y = 50;
        vb.grid.updatePositions();
        vb.setTextFlashes(tf1, tf2);
        tf1.text = ("hellou tf1");
        tf1.x = 200;
        tf1.y = 360;
        vb.repaint();
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
