package panda;

import java.awt.Color;

public class Nose extends BodyPart {
	public Nose(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void drawAt(int left, int bottom, Color color) {
		Drawing.pen().setColor(color);
		int x = left;
		int y = bottom - height;
		Drawing.pen().fillArc(x, y, width, height, 30, 120);
	}
}
