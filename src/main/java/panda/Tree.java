package panda;

import java.awt.*;

public class Tree implements DrawableObject {
    private final int height, left, bottom;

    public Tree(int height, int left, int bottom) {
        this.height = height;
        this.left = left;
        this.bottom = bottom;
    }

    public void draw() {
        Drawing.pen().setColor(new Color(139, 69, 19)); // Brown color for the trunk
        int x = left;
        int y = bottom;

        Graphics2D g = (Graphics2D) Drawing.pen();
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(10));

        // Draw the trunk
        Drawing.pen().drawLine(x, y, x, y - height); 
        g.setStroke(oldStroke);

        // Draw the leafy top
        Drawing.pen().setColor(Color.GREEN);
        g.setStroke(new BasicStroke(2));
        int crownRadius = height / 3;
        Drawing.pen().fillOval(x - crownRadius, y - height - crownRadius, 2 * crownRadius, 2 * crownRadius);
    }
}