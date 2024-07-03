package panda;

import java.awt.Color;

public class Head extends BodyPart {
	private Ear ears[]; // aggregate
	private BlackEyePatch patches[]; // composite
	private Eye eyes[]; // composite
	private Mouth mouth; // aggregate
	private Nose nose; // aggregate

	private Hat hat;
	
	public Head(int width, int height) {
		super(width, height);

		ears = new Ear[2];
		ears[0] = new Ear(width / 4, height / 4);
		ears[1] = new Ear(width / 4, height / 4);
		
		patches = new BlackEyePatch[2];
		patches[0] = new BlackEyePatch(width / 4, height / 4);
		patches[1] = new BlackEyePatch(width / 4, height / 4);
		
		eyes = new Eye[2];
		eyes[0] = new Eye(width / 6, height / 6);
		eyes[1] = new Eye(width / 6, height / 6);
		
		mouth = new Mouth(width / 4 , height / 4);
		
		nose = new Nose(width / 4, height / 5);
	}
	
	public int height() {
		return this.height + ears[0].height;
	}
	
	public void drawAt(int left, int bottom, Panda.HatType hatType) {
		ears[0].drawAt(left + width / 12, bottom - height / 5 * 4, Color.black);
		ears[1].drawAt(left + width / 3 * 2, bottom - height / 5 * 4, Color.black);
		
		super.drawAt(left, bottom, Color.white);
		
		patches[0].drawAt(left + width / 6, bottom - height / 2, Color.black);
		patches[1].drawAt(left + width / 12 * 7, bottom - height / 2, Color.black);
		
		eyes[0].drawAt(left + width / 6 + width / 25, bottom - height / 2, Color.white);
		eyes[1].drawAt(left + width / 16 * 9 + width / 25, bottom - height / 2, Color.white);
		
		mouth.drawAt(left + width / 4, bottom - height / 4, Color.black);
	
		nose.drawAt(left + width / 8 * 3, bottom - height / 4, Color.black);

		if (hatType == Panda.HatType.STRAW_HAT) {
			hat = new StrawHat(width, height / 2);
		}
		else if (hatType == Panda.HatType.NO_HAT) {
			hat = null;
		}

		if (hat != null) {
			hat.drawAt(left, bottom - height * 6 / 5);  
		}
	}
}
