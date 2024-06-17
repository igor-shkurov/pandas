package panda;

import java.awt.Graphics;

public class Drawing {
 
	public class pen {}

	private static Graphics pen = null;
	
	public static void set(Graphics pen) {
		Drawing.pen = pen;
	}
	
	public static Graphics pen() {
		return Drawing.pen;
	}
}