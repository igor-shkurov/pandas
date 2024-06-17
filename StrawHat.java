package panda;

import java.awt.*;

public class StrawHat extends Hat {
    public StrawHat(int width, int height) {
        super(width, height);
    }

    public void drawAt(int left, int bottom) {
        Drawing.pen().setColor(new Color(194, 178, 128));
        Drawing.pen().fillOval(left, bottom, width, height);

        Drawing.pen().setColor(new Color(255, 223, 186));
        Drawing.pen().fillRect(left + width / 4, bottom - height / 8, width / 2, height / 2);
        Drawing.pen().fillOval(left + width / 4, bottom + height / 8, width / 2, height / 2);

        Drawing.pen().setColor(new Color(139, 69, 19));
        Drawing.pen().fillOval(left + width / 4, bottom - height / 4, width / 2, height / 4);
    }
}
