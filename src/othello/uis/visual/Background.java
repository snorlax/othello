package hertta.uis.visualui.figures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author henripau
 */
public class Background extends Kuvio {
    private String filePathname;
    public Background(int x, int y, String filePathname) {
        super(x, y);
        this.filePathname = filePathname;
    }

    @Override
    public void piirra(Graphics g) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filePathname));
        } catch (IOException e) {
            System.out.println("Error while loading image: " + filePathname);
        }
        g.drawImage(img, x, y, null);
    }
    
}
