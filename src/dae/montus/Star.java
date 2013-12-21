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
public class Star {
    int frame;
    int direction;
    int x;
    int y;

    public Star(int x, int y, int direction, int frame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.frame = frame;
    }

    public void advance() {
        frame += direction;
        frame %= 6;
        if (frame < 0) frame = 5;

    }

    public void draw(Graphics2D g, int pixelSize) {
        Rectangle2D pixel;
        //center dot
        if (frame == 0 || frame == 3) {
            pixel = new Rectangle2D.Float(x - pixelSize, y - pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
        }
        //cross lvl0
        if (frame == 2 || frame == 1) {
            pixel = new Rectangle2D.Float(x - pixelSize, y - 3 * pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x + pixelSize, y - pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x - pixelSize, y + pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x - 3 * pixelSize, y - pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
        }
        //cross lvl1
        if (frame == 2 || frame == 3) {
            pixel = new Rectangle2D.Float(x - pixelSize, y - 5 * pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x + 3 * pixelSize, y - pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x - pixelSize, y + 3 * pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x - 5 * pixelSize, y - pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
        }
        //cross lvl2
        if (frame == 3 || frame == 4 || frame == 5) {
            pixel = new Rectangle2D.Float(x - pixelSize, y - 7 * pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x + 5 * pixelSize, y - pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x - pixelSize, y + 5 * pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x - 7 * pixelSize, y - pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
        }
        //cross trans
        if (frame == 4) {
            pixel = new Rectangle2D.Float(x - 5f * pixelSize, y - 5f * pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x + 3f * pixelSize, y - 5f * pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x + 3f * pixelSize, y + 3f * pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
            pixel = new Rectangle2D.Float(x - 5f * pixelSize, y + 3f * pixelSize, 2 * pixelSize, 2 * pixelSize);
            g.fill(pixel);
        }
    }
}
