package panda;

import java.awt.*;

public class ChineseFlag extends Flag {
    public ChineseFlag(int width, int height) {
        super(width, height);
    }

    public void drawAt(int left, int bottom) {
        Drawing.pen().setColor(Color.RED);
        Drawing.pen().fillRect(left, bottom, width, height);

        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawLine(left, bottom, left, bottom + 2 * width); // what line is being drawn here

        drawStar((Graphics2D) Drawing.pen(), left + width / 8, bottom + height / 4, width / 10, 0);

        double[][] smallStars = {
                {2.0, 1.0, -Math.PI / 10},
                {3.0, 2.0, Math.PI / 10},
                {3.0, 4.0, 0},
                {2.0, 5.0, -Math.PI / 10}
        };

        for (double[] star : smallStars) {
            drawStar((Graphics2D) Drawing.pen(), left + width / 10 * star[0], bottom + height / 10 * star[1], width / 20, star[2]);
        }
    }

    private void drawStar(Graphics2D g2d, double x, double y, double radius, double angle) {
        double innerRadius = radius / 2.5;
        int numPoints = 5;
        double[] xPoints = new double[numPoints * 2];
        double[] yPoints = new double[numPoints * 2];

        for (int i = 0; i < numPoints * 2; i++) {
            double currentRadius = (i % 2 == 0) ? radius : innerRadius;
            double currentAngle = i * Math.PI / numPoints + angle;
            xPoints[i] = x + Math.cos(currentAngle) * currentRadius;
            yPoints[i] = y + Math.sin(currentAngle) * currentRadius;
        }

        Polygon star = new Polygon();
        for (int i = 0; i < numPoints * 2; i++) {
            star.addPoint((int) xPoints[i], (int) yPoints[i]);
        }

        g2d.setColor(Color.YELLOW);
        g2d.fill(star);
    }
}
