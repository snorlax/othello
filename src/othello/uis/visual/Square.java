package othello.uis.visual;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Figure {

    public int sideLength;
    public Color color = Color.BLACK;
    
    public Square(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }
    

    @Override
    public void drawYourself(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, sideLength, sideLength);
    }

    @Override
    public int[] coversSpace() {
        int[] area = {x, y, x + sideLength, y + sideLength};
        return area;
    }
    
}
