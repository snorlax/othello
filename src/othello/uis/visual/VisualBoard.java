package othello.uis.visual;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class VisualBoard extends JPanel {
    
    public Rectangle background = new Rectangle(0, 0, 720, 720, Color.GREEN.darker().darker());
    public Signature sign = new Signature(530, 685);
    public NamePlate player1 = new NamePlate(10, 680, "Player 1");
    public NamePlate player2 = new NamePlate(500, 30, "Player 2");
    public Grid grid = new Grid(5000, 5000, 4, 150);
    public ArrayList<Circle> circles = new ArrayList<>();
    public TextFlash tf1;
    public TextFlash tf2;
    
    
    public void addCircle(int i, int j, Color c) {
        int x = grid.squares.get(i).get(j).x + 4;
        int y = grid.squares.get(i).get(j).y + 4;
        circles.add(new Circle(x, y, 70, c));
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.drawYourself(g);
        sign.drawYourself(g);
        player1.drawYourself(g);
        player2.drawYourself(g);
        grid.drawYourself(g);
        
        for (Circle c : circles) {
            c.drawYourself(g);
        }
        tf1.drawYourself(g);
        tf2.drawYourself(g);
    }

    public void setTextFlashes(TextFlash tf1, TextFlash tf2) {
        this.tf1 = tf1;
        this.tf2 = tf2;
    }
}
