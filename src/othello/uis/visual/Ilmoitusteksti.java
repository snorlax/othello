package hertta.uis.visualui.figures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author henripau
 */
public class Ilmoitusteksti extends Kuvio {
    private String teksti;
    
    public Ilmoitusteksti(int x, int y, String teksti) {
        super(x, y);
        this.teksti = teksti;
    }

    @Override
    public void piirra(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y - 45, teksti.length() * 33, 60);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.BOLD, 50));
        g.drawString(teksti, x, y);
    }
    
}
