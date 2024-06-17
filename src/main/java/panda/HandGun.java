package panda;

import java.awt.*;

public class HandGun extends Accessory {
    public HandGun(int width, int height) {
        super(width, height);
    }

    @Override
    protected void drawAt(int left, int bottom) {
        Color gunMetal = new Color(105, 105, 105);
        Color gripColor = new Color(139, 69, 19);

        Drawing.pen().setColor(gunMetal);
        Drawing.pen().fillRect(left, bottom + height * 9 / 10, width * 9 / 10, height / 5);

        Drawing.pen().setColor(gunMetal);
        Drawing.pen().fillRect(left, bottom + height * 4 / 5, width, height / 5);

        Drawing.pen().setColor(gripColor);
        Drawing.pen().fillRect(left, bottom + height * 11 / 10, width / 3, height / 2);

        Drawing.pen().setColor(gunMetal);
        Drawing.pen().drawArc(left + width / 3, bottom + height * 9 / 10, width / 5, height / 3, -180, 180);

        Drawing.pen().setColor(gunMetal);
        Drawing.pen().drawArc(left + width * 2 / 5, bottom + height * 9 / 10, width / 10, height / 4, -180, 90);

        Drawing.pen().setColor(gunMetal);
        Drawing.pen().fillRect(left, bottom + height * 11 / 7, width / 3, height / 20);
    }


}
