package panda;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Mouth extends BodyPart {
	public Mouth(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void drawAt(int left, int bottom, Color color) {
		Drawing.pen().setColor(color);
		int x = left;
		int y = bottom - height;
		
		Graphics2D g = (Graphics2D) Drawing.pen();
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(width / 40));

		g.drawArc(x, y, width, height, 0, -135);
		g.drawArc(x + width, y, width, height, 180, 135);
		
		g.setStroke(oldStroke);
	}
}
