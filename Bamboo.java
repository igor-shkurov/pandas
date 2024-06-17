package panda;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Bamboo {
	private final int height, left, bottom;
	
	public Bamboo(int height, int left, int bottom) {
		this.height = height;
		this.left = left;
		this.bottom = bottom;
	}
	
	public void draw() {
		Drawing.pen().setColor(Color.GREEN);
		int x = left;
		int y = bottom - height;
		
		Graphics2D g = (Graphics2D) Drawing.pen();
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(10));
        
		Drawing.pen().drawLine(x, y, x, y - height);
		
		Drawing.pen().setColor(Color.BLACK);
		g.setStroke(new BasicStroke(2));
		for (int i = 0; i < height; i += 20) {
			Drawing.pen().drawLine(x - 4, y - i, x + 4, y - i);
		}
		g.setStroke(oldStroke);
	}
}
