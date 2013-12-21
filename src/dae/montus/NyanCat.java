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

    private static int headOffsetX = 10;
    private static int headOffsetY = 4;
    private static int frontLegsOffsetX = 12;
    private static int frontLegsOffsetY = 16;
    private static int backLegsOffsetX = -3;
    private static int backLegsOffsetY = 14;
    private static int bodyOffsetX = 0;
    private static int bodyOffsetY = 0;
    private static int tailOffsetX = 0;
    private static int tailOffestY = 0;

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

    int frame = 5;

    public void nextFrame() {
        frame += 1;
        frame %= 6;
    }

    public void draw(Graphics2D g, int pixelSize) {
        rainbow.centerX = centerX;
        rainbow.centerY = centerY;
        Color[][] front = nyanLegsFront_2;
        Color[][] tail = nyanTail_1;
        if (frame == 0) {
            headOffsetX = 10;
            headOffsetY = 5;
            bodyOffsetY = 0;
            frontLegsOffsetX = 12;
            frontLegsOffsetY = 17;
            backLegsOffsetX = -3;
            backLegsOffsetY = 15;
            tail = nyanTail_1;
            tailOffsetX = -7;
            tailOffestY = 8;
        }
        if (frame == 1) {
            headOffsetX = 10;
            headOffsetY = 4;
            bodyOffsetY = 0;
            frontLegsOffsetX = 12;
            frontLegsOffsetY = 17;
            backLegsOffsetX = -3;
            backLegsOffsetY = 15;
            tail = nyanTail_2;
            tailOffsetX = -6;
            tailOffestY = 7;
        }
        if (frame == 2) {
            headOffsetX = 10;
            headOffsetY = 4;
            bodyOffsetY = -1;
            frontLegsOffsetX = 13;
            frontLegsOffsetY = 16;
            backLegsOffsetX = -2;
            backLegsOffsetY = 14;
            front = nyanLegsFront_1;
            tail = nyanTail_3;
            tailOffsetX = -6;
            tailOffestY = 6;
        }
        if (frame == 3) {
            headOffsetX = 11;
            headOffsetY = 4;
            bodyOffsetY = -1;
            frontLegsOffsetX = 14;
            frontLegsOffsetY = 16;
            backLegsOffsetX = -1;
            backLegsOffsetY = 14;
            tail = nyanTail_2;
            tailOffsetX = -6;
            tailOffestY = 7;
        }
        if (frame == 4) {
            headOffsetX = 11;
            headOffsetY = 5;
            bodyOffsetY = 0;
            frontLegsOffsetX = 15;
            frontLegsOffsetY = 17;
            backLegsOffsetX = 0;
            backLegsOffsetY = 15;
            tail = nyanTail_4;
            tailOffsetX = -6;
            tailOffestY = 10;
        }
        if (frame == 5) {
            headOffsetX = 11;
            headOffsetY = 5;
            bodyOffsetY = 0;
            frontLegsOffsetX = 14;
            frontLegsOffsetY = 17;
            backLegsOffsetX = -1;
            backLegsOffsetY = 15;
            tail = nyanTail_5;
            tailOffsetX = -6;
            tailOffestY = 10;
        }
        printBytes(g, pixelSize, tailOffsetX, tailOffestY, tail);
        printBytes(g, pixelSize, backLegsOffsetX, backLegsOffsetY, nyanLegsBack_1);
        printBytes(g, pixelSize, frontLegsOffsetX, frontLegsOffsetY, front);
        printBytes(g, pixelSize, bodyOffsetX, bodyOffsetY, nyanBody);
        printBytes(g, pixelSize, headOffsetX, headOffsetY, nyanHead);
    }

    private void printBytes(Graphics2D g, int pixelSize, int offsetX, int offsetY, Color[][] data) {
        int y = centerY + offsetY * pixelSize * 2;
        for (Color[] rowValues : data) {
            int x = centerX + offsetX * pixelSize * 2;
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

    private static final Color[][] nyanTail_1 = {
            {O, X, X, X, X, O, O},
            {X, G, G, G, X, X, X},
            {X, X, G, G, G, G, X},
            {O, O, X, X, X, X, G},
            {O, O, O, O, O, X, X}
    };

    private static final Color[][] nyanTail_2 = {
            {O, X, X, O, O, O},
            {X, G, G, X, O, O},
            {X, G, G, X, X, X},
            {O, X, G, G, G, G},
            {O, O, X, X, G, G},
            {O, O, O, O, X, X}
    };

    private static final Color[][] nyanTail_3 = {
            {X, X, X, X, O, O},
            {X, G, G, X, X, O},
            {X, X, G, G, X, X},
            {O, X, X, G, G, X},
            {O, O, X, X, G, G},
            {O, O, O, X, X, X},
            {O, O, O, O, O, X}
    };

    private static final Color[][] nyanTail_4 = {
            {O, O, O, O, O, X},
            {O, O, X, X, X, X},
            {X, X, G, G, G, G},
            {X, G, G, G, X, X},
            {O, X, X, X, X, O}
    };

    private static final Color[][] nyanTail_5 = {
            {O, O, O, O, X, X},
            {O, O, X, X, G, G},
            {O, X, G, G, G, G},
            {X, G, G, X, X, X},
            {X, G, G, X, O, O},
            {O, X, X, O, O, O},
    };

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
            {X, B, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, P, D, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, P, P, P, P, P, D, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, D, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, P, P, P, D, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, P, P, D, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, X},
            {X, B, B, B, P, P, P, P, P, P, P, P, P, P, P, P, P, P, B, B, X},
            {X, X, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, B, X, O},
            {O, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, X, O, O}
    };

    private static final Color[][] nyanLegsFront_1 = {
            {X, G, G, X, O, X, G, G, X},
            {X, G, G, X, O, X, G, G, X},
            {O, X, X, X, O, O, X, X, O}
    };

    private static final Color[][] nyanLegsFront_2 = {
            {X, G, G, X, O, X, G, G, X},
            {X, G, G, X, O, X, G, G, X},
            {O, X, X, X, O, O, X, X, X}
    };

    private static final Color[][] nyanLegsBack_1 = {
            {O, O, X, X, O, X, O, O, O},
            {O, X, G, X, X, X, O, O, O},
            {X, G, G, G, X, X, G, G, X},
            {X, G, G, X, O, X, G, G, X},
            {X, X, X, O, O, X, X, X, O}
    };
}
