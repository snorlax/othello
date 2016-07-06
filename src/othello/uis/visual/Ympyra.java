package hertta.uis.visualui.figures;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author henripau
 */
public class Ympyra extends Kuvio {
    private int halkaisija;
    private Color vari;
    
    /**
     *
     * @param x
     * @param y
     * @param halkaisija
     * @param vari
     * 
     */
    public Ympyra(int x, int y, int halkaisija, Color vari) {
        super(x, y);
        this.halkaisija = halkaisija;
        this.vari = vari;
    }
    
    @Override
    public void piirra(Graphics g) {
        g.setColor(vari);
        System.out.println(g.getColor());
        g.fillOval(x, y, halkaisija, halkaisija);
        
    }
    
}
