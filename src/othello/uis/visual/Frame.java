package othello.uis.visual;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Frame implements Runnable {

    public JFrame frame;
    public VisualBoard vb;

    public Frame() {

    }

    @Override
    public void run() {
        frame = new JFrame("Othello");
        frame.setPreferredSize(new Dimension(720, 720));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    public void createComponents(Container container) {
        container.setLayout(new BorderLayout());
        vb = new VisualBoard();
        container.add(vb, BorderLayout.CENTER);
        //container.add(nappirivi, BorderLayout.SOUTH);
    }
    public String kysyPelaajanimi() {
        Dialog d = new Dialog();
        return null;
    }

    void naytaTulokset(String tulokset) {
        Dialog d = new Dialog();
    }

    boolean halutaankoVielaPelata() {
        Dialog d = new Dialog();
        return true;
    }
    
    
}
