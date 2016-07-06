package othello.game;

import java.util.ArrayList;

public class Board {

    public int size; // must be 4, 6, 8, 10... Board always square
    public String[][] spots;

    public Board(int size) {
        this.size = size;
        
        //0th row and column stay null and we'll only work with normal indexes
        spots = new String[size + 1][size + 1];
        
        initializeSpots();
        
    }
    
    public void playSpot(int x, int y, String color) {
        setSpot(x, y, color);
        Tile tile = new Tile(x, y, color);
        commitConsequences(consequences(tile));
    }
    public void setSpot(int x, int y, String color) {
        spots[x][y] = color;
    }
    public String readSpot(int x, int y) {
        return spots[x][y];
    }
    public int countLight() {
        int counter = 0;
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                if (readSpot(x, y).equals("light")) {
                    counter++;
                }
            }
        }
        return counter;
    }
    public int countDark() {
        int counter = 0;
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                if (readSpot(x, y).equals("dark")) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public void initializeSpots() {
        int mid1 = size / 2;
        int mid2 = mid1 + 1;
        
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                if (x == mid1 && y == mid1) {
                    spots[x][y] = "dark";
                } else if (x == mid2 && y == mid2) {
                    spots[x][y] = "dark";
                } else if (x == mid1 && y == mid2) {
                    spots[x][y] = "light";
                } else if (x == mid2 && y == mid1) {
                    spots[x][y] = "light";
                } else {
                    spots[x][y] = "empty";
                }
            }
        }
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
    
    public Board copy() {
        Board copycat = new Board(size);
        copycat.initializeSpots();
        return copycat;
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
    public String[][] copySpots() {
        String[][] copies = new String[size][size];
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                copies[x][y] = spots[x][y];
            }
        }
        return copies;
    }
    
}

