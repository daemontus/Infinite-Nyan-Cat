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
public class NyanCat {

    private static final int headOffsetX = 10;
    private static final int headOffsetY = 4;

    private static final Color G = new Color(169, 169, 169);
    private static final Color C = new Color(255, 165, 165);
    private static final Color B = new Color(255, 215, 150);
    private static final Color P = new Color(255, 163, 255);
    private static final Color D = new Color(255, 69, 175);
    private static final Color W = Color.WHITE;
    private static final Color X = Color.BLACK;
    private static final Color O = null;

    int centerX;
    int centerY;
    Rainbow rainbow;

    public NyanCat(int x, int y, Rainbow rainbow) {
        this.centerX = x;
        this.centerY = y;
        this.rainbow = rainbow;
        rainbow.centerX = x;
        rainbow.centerY = y;
    }

    private static final Color[][] nyanHead = {
            {O, O, X, X, O, O, O, O, O, O, O, O, X, X, O, O},
            {O, X, G, G, X, O, O, O, O, O, O, X, G, G, X, O},
            {O, X, G, G, G, X, O, O, O, O, X, G, G, G, X, O},
            {O, X, G, G, G, G, X, X, X, X, G, G, G, G, X, O},
            {O, X, G, G, G, G, G, G, G, G, G, G, G, G, X, O},
            {X, G, G, G, G, G, G, G, G, G, G, G, G, G, G, X},
            {X, G, G, G, W, X, G, G, G, G, G, W, X, G, G, X},
            {X, G, G, G, X, X, G, G, G, X, G, X, X, G, G, X},
            {X, G, C, C, G, G, G, G, G, G, G, G, G, C, C, X},
            {X, G, C, C, G, X, G, G, X, G, G, X, G, C, C, X},
            {O, X, G, G, G, X, X, X, X, X, X, X, G, G, X, O},
            {O, O, X, G, G, G, G, G, G, G, G, G, G, X, O, O},
            {O, O, O, X, X, X, X, X, X, X, X, X, X, O, O, O}
    };

    //21x18
    private static final Color[][] nyanBody = {
            {O, O, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, O, O},
            {O, X, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, X, O},
            {X, B, B, B, P, P, P, P, P, P, P, P, P, P, P, P, P, B, B, B, X},
            {X, B, B, P, P, P, P, P, P, D, P, P, D, P, P, P, P, P, B, B, X},
            {X, B, P, P, D, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, P, P, P, P, P, P, P, P, P, P, P, P, D, P, P, B, X},
            {X, B, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, P, P, P, P, D, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, P, D, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, P, P, P, P, P, D, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, D, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, P, P, P, D, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, D, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, B, B, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, B, X},
            {X, X, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, X, O},
            {O, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, O, O}
            //{X,B,,,,,,,,,,,,,,,,,,B,X},
    };

    public void draw(Graphics2D g, int pixelSize) {
        int y;
        y = centerY;
        for (Color[] rowValues : nyanBody) {
            int x = centerX;
            for (Color rowValue : rowValues) {
                if (rowValue != null) {
                    g.setColor(rowValue);
                    Rectangle2D pixel = new Rectangle2D.Float(x, y, 2 * pixelSize, 2 * pixelSize);
                    g.fill(pixel);
                }
                x += 2 * pixelSize;
            }
            y += 2 * pixelSize;
        }
        y = centerY + headOffsetY * pixelSize * 2;
        for (Color[] rowValues : nyanHead) {
            int x = centerX + headOffsetX * pixelSize * 2;
            for (Color rowValue : rowValues) {
                if (rowValue != null) {
                    g.setColor(rowValue);
                    Rectangle2D pixel = new Rectangle2D.Float(x, y, 2 * pixelSize, 2 * pixelSize);
                    g.fill(pixel);
                }
                x += 2 * pixelSize;
            }
            y += 2 * pixelSize;
        }
    }
}
