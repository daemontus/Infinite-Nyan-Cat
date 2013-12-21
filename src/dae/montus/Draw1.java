package dae.montus;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

class Draw1 extends JFrame // create frame for canvas
{
    public Draw1() {
        super("Draw1");
        setBounds(50, 50, 1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con = this.getContentPane();
        con.setBackground(Color.white);
        GCanvas canvas = new GCanvas();
        con.add(canvas);
        setVisible(true);
    }

    public static void main(String arg[]) {
        new Draw1();
    }
}

class GCanvas extends Canvas // create a canvas for your graphics
{
    private ArrayList<Star> stars;
    private Rainbow rainbow;

    int f = 0;

    public void paint(Graphics g) {
        int pixelSize = (int) (getWidth() / 80f / 2f);
        if (stars == null) {
            stars = new ArrayList<Star>();
            int y = 0;
            for (int i = 0; i < 10; i++) {
                int dir = ((int) (Math.random() * 3)) % 2 == 0 ? -1 : 1;
                stars.add(new Star(
                        (int) (Math.random() * getWidth()),
                        /*(int) (Math.random()*getHeight())*/ y,
                        dir,
                        (int) (Math.random() * 5)));
                y += getHeight() / 10;
            }
            new Thread(new Renderer(stars, this)).start();
        }
        if (rainbow == null) {
            rainbow = new Rainbow(500, 500, 10);
        }
        Graphics2D g2D = (Graphics2D) g; // cast to 2D
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //blue background
        g2D.setColor(new Color(13, 66, 121));
        Rectangle2D.Float background = new Rectangle2D.Float(0, 0, getWidth(), getHeight());
        g2D.fill(background);
        //stars
        g.setColor(Color.WHITE);
        for (Star star : stars) {
            star.draw(g2D, pixelSize);
        }
        rainbow.draw(g2D, pixelSize);
        f++;
        if (f % 5 == 0) rainbow.toggleState();
    }
}

class Renderer implements Runnable {

    ArrayList<Star> stars;
    Canvas parent;

    public Renderer(ArrayList<Star> stars, Canvas parent) {
        this.stars = stars;
        this.parent = parent;
    }

    @Override
    public void run() {
        while (parent.isVisible()) {

            // Repaint the balls pen...
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    parent.repaint();
                }
            });

            // This is a little dangrous, as it's possible
            // for a repaint to occur while we're updating...
            for (Star star : stars) {
                star.advance();
            }

            // Some small delay...
            try {
                Thread.sleep(120);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }
}
