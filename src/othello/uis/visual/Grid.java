package othello.uis.visual;

import java.awt.Graphics;
import java.util.ArrayList;

public class Grid extends Figure {
    public int size;
    public int squareSize;
    public ArrayList<ArrayList<Square>> squares;

    public Grid(int x, int y, int size, int squareSize) {
        super(x, y);
        this.size = size;
        this.squareSize = squareSize;
        
        int ix = 0;
        int jy = 0;
        squares = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            squares.add(new ArrayList<Square>());
            if (i >= 1) {
                for (int j = 0; j <= size; j++) {
                    ix = computeX(i);
                    jy = computeY(j);
                    squares.get(i).add(new Square(ix, jy, squareSize));
                }
            }
        }
    }

    
    @Override
    public void drawYourself(Graphics g) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                squares.get(i).get(j).drawYourself(g);
            }
        }
    }

    @Override
    public int[] coversSpace() {
        return null;
    }

    private int computeX(int i) {
        if (i == 0) {
            return 5000;
        }
        i--;
        return x + i * squareSize;
    }

    private int computeY(int j) {
        if (j == 0) {
            return 5000;
        }
        j--;
        return y + j * squareSize;
    }

    public void updatePositions() {
        int ix = 0;
        int jy = 0;
        for (int i = 1; i <= size; i++) {
            squares.add(new ArrayList<Square>());
                for (int j = 1; j <= size; j++) {
                    ix = computeX(i);
                    jy = computeY(j);
                    squares.get(i).get(j).x = ix;
                    squares.get(i).get(j).y = jy;
                }
            }
        }
    }
