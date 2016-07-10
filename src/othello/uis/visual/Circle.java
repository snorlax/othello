package othello.uis.visual;

import java.awt.Color;
import java.awt.Graphics;


public class Circle extends Figure {
    
    public int radius;
    public Color color = Color.CYAN;

    public Circle(int x, int y, int r, Color color) {
        super(x, y);
        radius = r;
        this.color = color;
    }

    
    @Override
    public void drawYourself(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public int[] coversSpace() {
        return null;
    }
    
    
}
