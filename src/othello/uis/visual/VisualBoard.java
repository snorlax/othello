package othello.uis.visual;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class VisualBoard extends JPanel {
    
    public Rectangle background = new Rectangle(0, 0, 720, 720, Color.GREEN.darker().darker());
    public Signature sign = new Signature(530, 685);
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.drawYourself(g);
        sign.drawYourself(g);
    }
}
