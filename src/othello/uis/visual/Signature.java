package othello.uis.visual;

import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author henripau
 */
public class Signature extends Figure {

    public Signature(int x, int y) {
        super(x, y);
    }

    @Override
    public void drawYourself(Graphics g) {
        g.setColor(WHITE);
        g.setFont(new Font("Serif", Font.ITALIC, 10));
        g.drawString("created by Henri Paulamäki (2016)", x, y);
    }

    @Override
    public int[] coversSpace() {
        return null;
    }
    
}
