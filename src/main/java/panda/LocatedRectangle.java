package panda;

import java.awt.Point;

public interface LocatedRectangle {
	Point address();
	int width();
	int height();
	void draw();

	default boolean intersects(LocatedRectangle other) {
		return !doesNotIntersect(other, 0);
	}	
	
	default boolean intersects(LocatedRectangle other, int margin) {
		return !doesNotIntersect(other, margin);
	}
	
	private boolean doesNotIntersect(LocatedRectangle other, int margin) {
		return 	leftOf(other, margin) || rightOf(other, margin) || 
				above(other, margin) || below(other, margin);
	}
	
	default boolean leftOf(LocatedRectangle other, int margin){
		return this.address().x + this.width() + margin < other.address().x;
	}
	
	default boolean rightOf(LocatedRectangle other, int margin){
		return this.address().x > other.address().x + other.width() + margin;
	}
	
	private boolean above(LocatedRectangle other, int margin) {
		return this.address().y + this.height() + margin <= other.address().y;
	}
	
	private boolean below(LocatedRectangle other, int margin) {
		return this.address().y >= other.address().y + other.height() + margin;
	}
}