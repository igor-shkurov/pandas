package panda;

import java.awt.Color;

public class Eye extends BodyPart {
	private Pupil pupil; // aggregate
	
	public Eye(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void drawAt(int left, int bottom, Color color) {
		super.drawAt(left, bottom, color);
		
		pupil = new Pupil(width / 2, height / 2);
		pupil.drawAt(left + width / 2, bottom - height / 2, Color.black);
	}
}
