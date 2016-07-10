package othello.uis.visual;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author henripau
 */
public class ImageFigure extends Figure {
    private String filePathname;
    public ImageFigure(int x, int y, String filePathname) {
        super(x, y);
        this.filePathname = filePathname;
    }

    @Override
    public void drawYourself(Graphics g) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filePathname));
        } catch (IOException e) {
            System.out.println("Error while loading image: " + filePathname);
        }
        g.drawImage(img, x, y, null);
    }

    @Override
    public int[] coversSpace() {
        return null;
    }
    
}
