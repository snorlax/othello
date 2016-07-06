package othello.uis.visual;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author henripau
 */
public class Rectangle extends Figure {
    public int width;
    public int height;
    public Color color;

    public Rectangle(int x, int y, int leveys, int korkeus, Color vari) {
        super(x, y);
        this.width = leveys;
        this.height = korkeus;
        this.color = vari;
    }
    

    @Override
    public void drawYourself(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public int[] coversSpace() {
        int[] ret =  {x, y, x + width, y + height};
        return ret;
    }
    
}
