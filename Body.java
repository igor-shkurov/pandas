package panda;

import java.awt.Color;

public class Body extends BodyPart {
	private Arm arms[]; // aggregate
	private Leg legs[]; // aggregate
	private BellySpot spot; // aggregate
	private Accessory accessory;
	
	public Body(int width, int height) {
		super(width, height);
		
		arms = new Arm[2];
		arms[0] = new Arm(width / 4, height / 4);
		arms[1] = new Arm(width / 4, height / 4);
		
		legs = new Leg[2];
		legs[0] = new Leg(width / 3, height / 3);
		legs[1] = new Leg(width / 3, height / 3);
		
		spot = new BellySpot(width / 2, height / 2);
	}
	
	public int width() {
		return arms[0].width() + width;
	}
	
	public void drawAt(int left, int bottom, Panda.AccessoryType accessoryType) {
		arms[0].drawAt(left - width / 12, bottom - width * 2 / 3, Color.black);
		arms[1].drawAt(left + width / 6 * 5, bottom - width * 2 / 3, Color.black);

		legs[0].drawAt(left - width / 12, bottom, Color.black);
		legs[1].drawAt(left + width / 12 * 9, bottom, Color.black);
		
		super.drawAt(left, bottom, Color.black);
		
		spot.drawAt(left + width / 4, bottom - height / 4, Color.white);

		if (accessoryType == Panda.AccessoryType.GERMAN_FLAG) {
			accessory = new GermanFlag(width / 4, height / 4);
		}
		else if (accessoryType == Panda.AccessoryType.CHINESE_FLAG) {
			accessory = new ChineseFlag(width / 4, height / 4);
		}
		else if (accessoryType == Panda.AccessoryType.HANDGUN) {
			accessory = new HandGun(width / 4, height / 4);
		}
		else if (accessoryType == Panda.AccessoryType.NO_ACCESSORY) {
			accessory = null;
		}

		if (accessory != null) {
			accessory.drawAt(left + width, bottom - height * 7 / 6);
		}
	}
}
