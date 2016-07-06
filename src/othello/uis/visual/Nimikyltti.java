package hertta.uis.visualui.figures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author henripau
 */
public class Nimikyltti extends Kuvio {
    private String teksti;
    
    public Nimikyltti(int x, int y, String teksti) {
        super(x, y);
        this.teksti = teksti;
    }

    @Override
    public void piirra(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y - 25, teksti.length() * 25, 30);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.BOLD, 26));
        g.drawString(teksti, x, y);
    }
    
}