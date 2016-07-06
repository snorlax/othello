package othello.uis.visual;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author henripau
 */
public abstract class Figure {
    public int x;
    public int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract void drawYourself(Graphics g);
    
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }


    public abstract int[] coversSpace();

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setPosition(Point p) {
        this.x = (int) p.getX();
        this.y = (int) p.getY();
    }

    public Point getPosition() {
        return new Point(x, y);
    }
}
