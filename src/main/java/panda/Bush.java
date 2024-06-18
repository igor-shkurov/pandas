package panda;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Stroke;

public class Bush {
    private final int height, left, bottom;

    public Bush(int height, int left, int bottom) {
        this.height = height;
        this.left = left;
        this.bottom = bottom;
    }

    public void draw() {
        Graphics2D g = (Graphics2D) Drawing.pen();
        Stroke oldStroke = g.getStroke();

        int x = left;
        int y = bottom;

        int bushWidth = height * 2 / 3;
        int radius = height / 6;
        int borderRadius = radius + 2;

        for (int i = 0; i <= bushWidth; i += radius) {
            int circleY = y - height / 2;
            if (i % (2 * radius) == 0) {
                circleY -= radius / 2;
            }
            g.setColor(Color.GREEN);
            g.fillOval(x + i - radius / 2, circleY - radius / 2, radius * 2, radius * 2);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(2));
            g.drawOval(x + i - borderRadius / 2, circleY - borderRadius / 2, borderRadius * 2, borderRadius * 2);
        }

        g.setStroke(oldStroke);
    }
}
