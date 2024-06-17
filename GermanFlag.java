package panda;

import java.awt.*;

public class GermanFlag extends Flag{
    public GermanFlag(int width, int height) {
        super(width, height);
    }

    public void drawAt(int left, int bottom) {
        int stripeHeight = height / 3;
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawLine(left, bottom, left, bottom + 2 * width);

        Drawing.pen().fillRect(left, bottom, width, stripeHeight);

        Drawing.pen().setColor(Color.RED);
        Drawing.pen().fillRect(left, bottom + stripeHeight, width, stripeHeight);

        Drawing.pen().setColor(Color.YELLOW);
        Drawing.pen().fillRect(left, bottom + 2 * stripeHeight, width, stripeHeight);
    }
}
