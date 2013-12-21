package dae.montus;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created with IntelliJ IDEA.
 * User: daemontus
 *
 * @author Samuel Pastva
 * @version 21/12/13
 */
public class Rainbow {

    private static final Color[] colors = new Color[]{
            new Color(255, 19, 19),
            new Color(255, 167, 17),
            new Color(255, 255, 10),
            new Color(62, 255, 10),
            new Color(20, 170, 255),
            new Color(117, 70, 255)
    };
    private static final int BLOCK_W = 8;
    private static final int BLOCK_H = 3;

    int centerX;
    int centerY;
    int len;
    int state;

    public void toggleState() {
        state += 1;
        state %= 2;
    }

    public Rainbow(int x, int y, int len) {
        this.centerX = x;
        this.centerY = y;
        this.len = len;
        state = 0;
    }

    public void draw(Graphics2D g, int pixelSize) {
        int x = centerX - BLOCK_W * pixelSize;
        for (int i = 0; i < len; i++) {
            int y = centerY;
            if ((i + state) % 2 == 0) y += pixelSize;
            for (Color color : colors) {
                if (i <= 4) g.setColor(color);
                else {
                    g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), (int) ((((float) (len - i + 4)) / len) * 255)));
                }

                Rectangle2D pixel = new Rectangle2D.Float(x, y, BLOCK_W * pixelSize * 2, BLOCK_H * pixelSize * 2);
                g.fill(pixel);
                y += BLOCK_H * pixelSize * 2;
            }
            x -= BLOCK_W * pixelSize * 2;
        }
    }
}
