package panda;

import java.awt.Point;
//Field Declarations
public class Panda implements LocatedRectangle {
	private Body body;
	private Head head;
	private int width, height, left, bottom;
	private HatType hatType;
	private AccessoryType accessoryType;

	public enum HatType {
		NO_HAT, STRAW_HAT;
	}

	public enum AccessoryType {
		NO_ACCESSORY, GERMAN_FLAG, CHINESE_FLAG, HANDGUN;
	}

	public Panda(int left, int bottom, int width, int height) {
		this.width = width;
		this.height = height;
		this.left = left;
		this.bottom = bottom;
		hatType = HatType.NO_HAT;
		accessoryType = AccessoryType.NO_ACCESSORY;
		body = new Body(width, height);
		head = new Head(width * 2 / 3, height * 2 / 3);
	}
	
	public void drawAt(int left, int bottom) {
		body.drawAt(left, bottom, accessoryType);
		head.drawAt(left + width / 6, bottom - height + height / 12, hatType);
	}

	public void setAccessoryType(AccessoryType accessoryType) {
		this.accessoryType = accessoryType;
	}

	public AccessoryType getAccessoryType() {
		return accessoryType;
	}

	public void setHatType(HatType hatType) {
		this.hatType = hatType;
	}

	public HatType getHatType() {
		return hatType;
	}

	@Override
	public void draw() {
		drawAt(left, bottom);
	}

	@Override
	public Point address() {
		return new Point(left, bottom);
	}

	@Override
	public int width() {
		return body.width();
	}

	@Override
	public int height() {
		return head.height() + body.height() ;
	}
}
