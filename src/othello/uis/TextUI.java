package othello.uis;

import java.util.Scanner;
import othello.UserInterface;
import othello.game.Board;
import othello.game.Othello;
import othello.game.Player;
import othello.game.players.UserPlayer;

public class TextUI extends UserInterface {

    @Override
    public void setSettings() {
        System.out.println("Default settings automatically set for now\n");
    }

    @Override
    public void newGameInitialized(Othello othello) {
        System.out.println("New othello game initialized\n");
        printBoard(othello.board);
    }

    @Override
    public void newTurn(String playerName) {
        System.out.println(playerName + "'s turn:");
    }

    @Override
    public void noLegalsFor(String playerName) {
        System.out.println(playerName + " can't play a legal move!");
    }
    
    @Override
    public void triedIllegalMove() {
        System.out.println("That move isn't allowed!");
    }

    @Override
    public void turnPlayed(Player player, Board board, String color) {
        if (player.getClass() != UserPlayer.class) {
            System.out.println(player.name + " played!");
        }
        printBoard(board);
    }

    @Override
    public void gameDone() {
        System.out.println("\nNeither could play anymore. Game finished!");
    }

    private void printBoard(Board board) {
        //System.out.println("\n[ ][ ][ ][ ]\n[ ][o][x][ ]\n[ ][x][o][ ]\n[ ][ ][ ][ ]\n");
        StringBuilder sb = new StringBuilder("");
        
        for (int y = 1; y <= board.size; y++) {
            for (int x = 1; x <= board.size; x++) {
                sb.append("[");
                if (board.spots[x][y].equals("empty")) { sb.append(" ");}
                else if (board.spots[x][y].equals("light")) { sb.append("x");}
                else if (board.spots[x][y].equals("dark")) { sb.append("o");}
                sb.append("]");
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    @Override
    public int[] userMove() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insert coords to play in:");
        System.out.print("x: ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("y: ");
        int y = Integer.parseInt(scanner.nextLine());
        
        int[] coords = {x, y};
        return coords;
    }

    @Override
    public void lightTiles(int amount) {
        System.out.println("Number of light tiles on board: " + amount);
    }

    @Override
    public void darkTiles(int amount) {
        System.out.println("Number of dark tiles on board: " + amount);
    }

    @Override
    public void winner(Player player) {
        System.out.println("Winner is " + player.name + "!!! Congratulations :)");
    }

    @Override
    public void draw() {
        System.out.println("Game ended in a draw!");
    }

    @Override
    public void ignition() {
    }

    @Override
    public String getPlayerName() {
        System.out.print("Enter playerName:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
}
