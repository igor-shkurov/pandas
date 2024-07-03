package panda;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Stroke;

public class Bush implements DrawableObject {
    private final int height, left, bottom;

    public Bush(int height, int left, int bottom) {
        this.height = height;
        this.left = left;
        this.bottom = bottom;
    }

    public void draw() {
        // Get the Graphics2D object from the Drawing class
        Graphics2D g = (Graphics2D) Drawing.pen();
        // Save the current stroke settings to restore them later
        Stroke oldStroke = g.getStroke();

        // Define the starting coordinates for drawing
        int x = left;
        int y = bottom;

        // Calculate the width of the bush, which is two-thirds of the height
        int bushWidth = height * 2 / 3;
        // Define the radius of each bush circle as one-sixth of the height
        int radius = height / 6;
        // Define the border radius slightly larger than the circle radius for the border outline
        int borderRadius = radius + 2;

        // Loop through the width of the bush in steps of the circle's radius
        for (int i = 0; i <= bushWidth; i += radius) {
            // Set the y-coordinate for the circle, starting from the middle height of the bush
            int circleY = y - height / 4;
            // Adjust the y-coordinate to stagger the circles vertically for a more natural look
            if (i % (2 * radius) == 0) {
                circleY -= radius / 2;
            }
            // Set the color to green for filling the circle
            g.setColor(Color.GREEN);
            // Draw the filled circle
            g.fillOval(x + i - radius / 2, circleY - radius / 2, radius * 2, radius * 2);
            // Set the color to black for the circle border
            g.setColor(Color.BLACK);
            // Set the stroke for the border
            g.setStroke(new BasicStroke(2));
            // Draw the border outline of the circle
            g.drawOval(x + i - borderRadius / 2, circleY - borderRadius / 2, borderRadius * 2, borderRadius * 2);
        }

        // Restore the original stroke settings
        g.setStroke(oldStroke);
    }
}
