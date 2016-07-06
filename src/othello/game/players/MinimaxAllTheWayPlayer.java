package othello.game.players;

import java.util.ArrayList;
import java.util.List;
import othello.UserInterface;
import othello.game.Board;
import othello.game.Othello;
import othello.game.Player;
import othello.game.players.util.GameSituation;

public class MinimaxAllTheWayPlayer extends Player {
    public String myColor;
    public GameSituation treetop;
    public Board copyBoard;

    public MinimaxAllTheWayPlayer(UserInterface UI, String name, Othello othello, String color) {
        super(UI);
        this.name = name;
        myColor = color;
        UI.preparingBotPlayer((Player) this);
        copyBoard = othello.board.copy();
        treetop = new GameSituation(copyBoard.spots, "light");
        learnLoop(treetop, othello);
    }

    @Override
    public int[] play(ArrayList<int[]> possibleMoves, Board board, String color) {
        if (possibleMoves.isEmpty()) {
            return null;
        } else {
            GameSituation current = findCorrectSituation(new GameSituation(board.spots.clone(), color), board.size);
            return bestMove(current);
        }
    }

    public void learnLoop(GameSituation gs, Othello othello) {
        gs.children = movesToGameSituations(gs, othello.possibleMoves(gs), copyBoard);
        if (gs.children.isEmpty()) {
            copyBoard.spots = gs.copySpots();
            if (myColor.equals("light")) {
                gs.value = copyBoard.countLight() - copyBoard.countDark();
            } else {
                gs.value = copyBoard.countDark() - copyBoard.countLight();
            }
        } else {
            for (GameSituation child : gs.children) {
                learnLoop(child, othello);
            }
        }

    }

    public ArrayList<GameSituation> movesToGameSituations(GameSituation gs, ArrayList<int[]> moves, Board board) {
        ArrayList<GameSituation> situations = new ArrayList<>();

        for (int[] move : moves) {
            
           GameSituation newGS = new GameSituation(gs.copySpots(), gs.inverseColor());
            newGS.playSpot(move[0], move[1], gs.turnColor);
            situations.add(newGS);
        }

        return situations;
    }

    public GameSituation findCorrectSituation(GameSituation gs, int boardSize) {
        return findMatch(treetop, gs, boardSize);
    }

    public GameSituation findMatch(GameSituation current, GameSituation gs, int boardSize) {
        if (current.equals(gs, boardSize)) {
            return current;
        } else {
            for (GameSituation child : current.children) {
                return findMatch(child, gs, boardSize);
            }
        }
        System.out.println("findMatch failed");
        return null;
    }

    public int[] bestMove(GameSituation current) {
        GameSituation toEndUpTo = current.children.get(0);
        int bestValue = toEndUpTo.getMinimaxValue();
        for (GameSituation child : current.children) {
            int childsValue = child.getMinimaxValue();
            if (childsValue > bestValue) {
                toEndUpTo = child;
                bestValue = childsValue;
            }
        }
        
        return moveToMake(current, toEndUpTo);
        
    }

    public int[] moveToMake(GameSituation current, GameSituation toEndUpTo) {
        String[][] iSpots = current.copySpots();
        String[][] fSpots = toEndUpTo.copySpots();
        
        int size = 4;
        int[] move = null;
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                if (!iSpots[x][y].equals(fSpots)) {
                    move[0] = x;
                    move[1] = y;
                }
            }
        }
        
        return move;
    }

}
