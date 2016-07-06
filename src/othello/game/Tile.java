package othello.game;


public class Tile {
    public int x;
    public int y;
    public String color;

    public Tile(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Tile copy() {
        return new Tile(x, y, color);
    }
}
