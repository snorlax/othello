package othello.game.players.util;

import java.util.ArrayList;
import othello.game.Tile;

public class GameSituation {

    public String[][] spots;
    public int size = 4;
    public String turnColor;
    public int value;
    public ArrayList<GameSituation> children;

    public GameSituation(String[][] spots, String turnColor) {
        this.turnColor = turnColor;
        this.spots = spots;
    }

    public String inverseColor() {
        if (turnColor.equals("light")) {
            return "dark";
        } else {
            return "light";
        }
    }

    public int getMinimaxValue() {
        if (children.isEmpty()) {
            return value;
        } else {
            return maxOfChildren();
        }
    }

    public int maxOfChildren() {
        int max = -100000000;
        for (GameSituation child : children) {
            int childsValue = child.getMinimaxValue();
            if (childsValue > max) {
                max = childsValue;
            }
        }
        return max;
    }

    public boolean equals(GameSituation other, int boardSize) {
        if (equalSpots(this.spots, other.spots, boardSize) && this.turnColor.equals(other.turnColor)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equalSpots(String[][] spots, String[][] otherSpots, int boardSize) {
        boolean b = true;
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                if (!spots[x][y].equals(otherSpots[x][y]))
                    b = false;
            }
        }
        return b;
    }
    
    public void playSpot(int x, int y, String color) {
        setSpot(x, y, color);
        Tile tile = new Tile(x, y, color);
        commitConsequences(consequences(tile));
    }
    public void setSpot(int x, int y, String color) {
        spots[x][y] = color;
    }
    
    public void commitConsequences(ArrayList<ArrayList<Tile>> list) {
        for (ArrayList<Tile> sublist : list) {
            for (Tile t : sublist) {
                setSpot(t.x, t.y, swapColor(t.color));
            }
        }
    }
    
    public boolean hasConsequences(Tile tile) {
        ArrayList<ArrayList<Tile>> conseq = consequences(tile);
        boolean hasCons = false;
        for (ArrayList<Tile> list : conseq) {
            if (!list.isEmpty()) {
                hasCons = true;
            }
        }
        return hasCons;
    }
    
    public String[][] copySpots() {
        String[][] copies = new String[size + 1][size + 1];
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                copies[x][y] = spots[x][y];
            }
        }
        return copies;
    }
    
    public String swapColor(String color) {
        if (color.equals("light")) {
            return "dark";
        } else if (color.equals("dark")) {
            return "light";
        } else {
            System.out.println("Tried to swap the color of empty or null Tile!");
            return null;
        }
    }
    
    public ArrayList<ArrayList<Tile>> consequences(Tile tile) {
        ArrayList<ArrayList<Tile>> mainList = new ArrayList<>();
        
        // try going north
        ArrayList<Tile> tmp = new ArrayList<>();
        Tile current = tile.copy();
        while (true) {
            current = stepNorth(current);
            if (current == null) {
                tmp.clear();
                break;
            } else if (current.color.equals(tile.color)) {
                break;
            } else if (current.color.equals("empty")) {
                tmp.clear();
                break;
            } else {
                tmp.add(current);
                continue;
            }
        }
        mainList.add(tmp);
        
        // try going northeast
        tmp = new ArrayList<>();
        current = tile.copy();
        while (true) {
            current = stepNortheast(current);
            if (current == null) {
                tmp.clear();
                break;
            } else if (current.color.equals(tile.color)) {
                break;
            } else if (current.color.equals("empty")) {
                tmp.clear();
                break;
            } else {
                tmp.add(current);
                continue;
            }
        }
        mainList.add(tmp);
        
        // try going east
        tmp = new ArrayList<>();
        current = tile.copy();
        while (true) {
            current = stepEast(current);
            if (current == null) {
                tmp.clear();
                break;
            } else if (current.color.equals(tile.color)) {
                break;
            } else if (current.color.equals("empty")) {
                tmp.clear();
                break;
            } else {
                tmp.add(current);
                continue;
            }
        }
        mainList.add(tmp);
        
        // try going southeast
        tmp = new ArrayList<>();
        current = tile.copy();
        while (true) {
            current = stepSoutheast(current);
            if (current == null) {
                tmp.clear();
                break;
            } else if (current.color.equals(tile.color)) {
                break;
            } else if (current.color.equals("empty")) {
                tmp.clear();
                break;
            } else {
                tmp.add(current);
                continue;
            }
        }
        mainList.add(tmp);
        
        // try going south
        tmp = new ArrayList<>();
        current = tile.copy();
        while (true) {
            current = stepSouth(current);
            if (current == null) {
                tmp.clear();
                break;
            } else if (current.color.equals(tile.color)) {
                break;
            } else if (current.color.equals("empty")) {
                tmp.clear();
                break;
            } else {
                tmp.add(current);
                continue;
            }
        }
        mainList.add(tmp);
        
        // try going southwest
        tmp = new ArrayList<>();
        current = tile.copy();
        while (true) {
            current = stepSouthwest(current);
            if (current == null) {
                tmp.clear();
                break;
            } else if (current.color.equals(tile.color)) {
                break;
            } else if (current.color.equals("empty")) {
                tmp.clear();
                break;
            } else {
                tmp.add(current);
                continue;
            }
        }
        mainList.add(tmp);
        
        // try going west
        tmp = new ArrayList<>();
        current = tile.copy();
        while (true) {
            current = stepWest(current);
            if (current == null) {
                tmp.clear();
                break;
            } else if (current.color.equals(tile.color)) {
                break;
            } else if (current.color.equals("empty")) {
                tmp.clear();
                break;
            } else {
                tmp.add(current);
                continue;
            }
        }
        mainList.add(tmp);
        
        // try going northwest
        tmp = new ArrayList<>();
        current = tile.copy();
        while (true) {
            current = stepNorthwest(current);
            if (current == null) {
                tmp.clear();
                break;
            } else if (current.color.equals(tile.color)) {
                break;
            } else if (current.color.equals("empty")) {
                tmp.clear();
                break;
            } else {
                tmp.add(current);
                continue;
            }
        }
        mainList.add(tmp);
        
       
        
        return mainList;
    }
    
    public Tile stepNorth(Tile current) {
        // returns null if illegal coords
        int newX = current.x;
        int newY = current.y - 1;
        
        if (newX > 0 && newX <= size && newY > 0 && newY <= size) {
            return new Tile(newX, newY, spots[newX][newY]);
        } else {return null;}
    }
    public Tile stepNortheast(Tile current) {
        // returns null if illegal coords
        int newX = current.x + 1;
        int newY = current.y - 1;
        
        if (newX > 0 && newX <= size && newY > 0 && newY <= size) {
            return new Tile(newX, newY, spots[newX][newY]);
        } else {return null;}
    }
    public Tile stepEast(Tile current) {
        // returns null if illegal coords
        int newX = current.x + 1;
        int newY = current.y;
        
        if (newX > 0 && newX <= size && newY > 0 && newY <= size) {
            return new Tile(newX, newY, spots[newX][newY]);
        } else {return null;}
    }
    public Tile stepSoutheast(Tile current) {
        // returns null if illegal coords
        int newX = current.x + 1;
        int newY = current.y + 1;
        
        if (newX > 0 && newX <= size && newY > 0 && newY <= size) {
            return new Tile(newX, newY, spots[newX][newY]);
        } else {return null;}
    }
    public Tile stepSouth(Tile current) {
        // returns null if illegal coords
        int newX = current.x;
        int newY = current.y + 1;
        
        if (newX > 0 && newX <= size && newY > 0 && newY <= size) {
            return new Tile(newX, newY, spots[newX][newY]);
        } else {return null;}
    }
    public Tile stepSouthwest(Tile current) {
        // returns null if illegal coords
        int newX = current.x - 1;
        int newY = current.y + 1;
        
        if (newX > 0 && newX <= size && newY > 0 && newY <= size) {
            return new Tile(newX, newY, spots[newX][newY]);
        } else {return null;}
    }
    public Tile stepWest(Tile current) {
        // returns null if illegal coords
        int newX = current.x - 1;
        int newY = current.y;
        
        if (newX > 0 && newX <= size && newY > 0 && newY <= size) {
            return new Tile(newX, newY, spots[newX][newY]);
        } else {return null;}
    }
    public Tile stepNorthwest(Tile current) {
        // returns null if illegal coords
        int newX = current.x - 1;
        int newY = current.y - 1;
        
        if (newX > 0 && newX <= size && newY > 0 && newY <= size) {
            return new Tile(newX, newY, spots[newX][newY]);
        } else {return null;}
    }

}
