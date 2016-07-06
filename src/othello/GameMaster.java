package othello;

import javax.swing.SwingUtilities;
import othello.game.Othello;
import othello.uis.*;

public class GameMaster {

    public UserInterface UI;
    public Settings settings;
    public Othello currentGame;

    public GameMaster(String ui_type) {

        // select used user interface and initialize it
        switch (ui_type) {
            case "textui":
                this.UI = new TextUI();
                break;
            case "visualui":
                this.UI = new VisualUI();
                UI.ignition();
                break;
            default:
                this.UI = new TextUI();
                break;
        }

        // initialize settings with default values
        this.settings = new Settings();
    }

    public void run() {
        UI.setSettings();

        // for now we'll simply run a single game with defaults
        Othello othello = new Othello(settings, UI);
        UI.newGameInitialized(othello);

        // take turns until neither can play
        boolean p1couldPlay = true;
        boolean p2couldPlay = true;

        while (p1couldPlay || p2couldPlay) {

            // player 1
            UI.newTurn(othello.player1.name);
            int[] spotToPlay = playTurn(othello, "light");

            if (spotToPlay == null) {
                UI.noLegalsFor(othello.player1.name);
                p1couldPlay = false;
            } else {
                UI.lightTurnPlayed(othello.player1, othello.board);
                p1couldPlay = true;
            }

            // player 2
            UI.newTurn(othello.player2.name);
            spotToPlay = playTurn(othello, "dark");

            if (spotToPlay == null) {
                UI.noLegalsFor(othello.player2.name);
                p2couldPlay = false;
            } else {
                UI.darkTurnPlayed(othello.player2, othello.board);
                p2couldPlay = true;
            }
        }

        UI.gameDone();
        int lightTiles = othello.board.countLight();
        int darkTiles = othello.board.countDark();
        UI.lightTiles(lightTiles);
        UI.darkTiles(darkTiles);
        if (lightTiles > darkTiles) {
            UI.winner(othello.player1);
        } else if (darkTiles > lightTiles) {
            UI.winner(othello.player2);
        } else {
            UI.draw();
        }
    }

    private int[] playTurn(Othello oth, String color) {
        int[] spotToPlay = null;
        boolean legalMove = false;
        while (!legalMove) {

            if (color.equals("light")) {
                spotToPlay = oth.playPlayer1Turn();
            } else {
                spotToPlay = oth.playPlayer2Turn();
            }
            if (spotToPlay == null) {
                break;
            }
            legalMove = oth.checkIfLegal(spotToPlay, color);
            if (!legalMove) {
                UI.triedIllegalMove();
            }
        }

        if (spotToPlay == null) {
            return null;
        } else {
            oth.board.playSpot(spotToPlay[0], spotToPlay[1], color);
            return spotToPlay;
        }
    }

}
