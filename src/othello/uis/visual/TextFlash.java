package othello.uis.visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TextFlash extends Figure {
    public String text;
    
    public TextFlash(int x, int y, String teksti) {
        super(x, y);
        this.text = teksti;
    }

    @Override
    public void drawYourself(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y - 45, text.length() * 33, 60);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.BOLD, 50));
        g.drawString(text, x, y);
    }

    @Override
    public int[] coversSpace() {
        return null;
    }
    
}
