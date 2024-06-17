package panda;

import java.awt.Color;

abstract public class BodyPart {
	protected int width, height;
	
	protected BodyPart(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int width() {
		return width;
	}
	
	public int height() {
		return height;
	}
	
	protected void drawAt(int left, int bottom, Color color) {
		Drawing.pen().setColor(color);
		int x = left;
		int y = bottom - height;
		Drawing.pen().fillOval(x, y, width, height);
	}
}