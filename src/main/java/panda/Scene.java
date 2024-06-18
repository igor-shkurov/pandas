package panda;

import panda.graphicstate.*;

import java.awt.*;
import java.util.ArrayList;

public class Scene {
	private static final int OBJECT_MAX_HEIGHT = 250;
	private static final int OBJECT_MIN_HEIGHT = 100;
	private static final int PANDA_SIZE = 150;

	private LayoutState graphicState;

	private final int pandaNumber;
	private final ArrayList<Panda> pandas;
	private final ArrayList<Object> objects;
	private final Dimension screenSize;

	private int objectNumber;
	
	public Scene(Dimension screenSize) {
        this.graphicState = new EmptyState(this);
		this.screenSize = screenSize;

		pandaNumber = this.screenSize.width / PANDA_SIZE;
		pandas = new ArrayList<>();
		objects = new ArrayList<>();
		createPandas();
	}

	public ArrayList<Panda> getPandas() { // used for testing
		return pandas;
	}
	
	public void createBambooForest() {
		objects.clear();
		objectNumber = 200;
		for (int i = 0; i < objectNumber; i++) {
			objects.add(new Bamboo(RandomNumber.between(OBJECT_MIN_HEIGHT, OBJECT_MAX_HEIGHT),
					RandomNumber.between(50, screenSize.width - 100),
					RandomNumber.between(300, screenSize.height)));
		}
	}

	public void drawBambooForest() {
		for (Object object : objects) {
			((Bamboo) object).draw();
		}
	}

	public void createTreeForest() {
		objects.clear();
		objectNumber = 30;
		for (int i = 0; i < objectNumber; i++) {
			objects.add(new Tree(RandomNumber.between(OBJECT_MIN_HEIGHT, OBJECT_MAX_HEIGHT),
					RandomNumber.between(50, screenSize.width - 100),
					RandomNumber.between(300, screenSize.height)));
		}
	}

	public void drawTreeForest() {
		for (Object object : objects) {
			((Tree) object).draw();
		}
	}

	public void createBushForest() {
		objects.clear();
		objectNumber = 15;
		for (int i = 0; i < objectNumber; i++) {
			objects.add(new Bush(RandomNumber.between(OBJECT_MIN_HEIGHT + 200, OBJECT_MAX_HEIGHT + 200),
					RandomNumber.between(50, screenSize.width - 100),
					RandomNumber.between(300, screenSize.height)));
		}
	}

	public void drawBushForest() {
		for (Object object : objects) {
			((Bush) object).draw();
		}
	}

	public void changeObjectNumber(int newObjectNumber) {
		if (newObjectNumber < objectNumber) {
			for (int i = 0; i < objectNumber - newObjectNumber; i++) {
				objects.removeLast();
			}
		}
		else {
			for (int i = 0; i < newObjectNumber - objectNumber; i++) {
				if (getState() instanceof BambooForestState) {
					objects.add(new Bamboo(RandomNumber.between(OBJECT_MIN_HEIGHT, OBJECT_MAX_HEIGHT),
							RandomNumber.between(50, screenSize.width - 100),
							RandomNumber.between(300, screenSize.height)));
				}
				else if (getState() instanceof TreeForestState) {
					objects.add(new Tree(RandomNumber.between(OBJECT_MIN_HEIGHT, OBJECT_MAX_HEIGHT),
							RandomNumber.between(50, screenSize.width - 100),
							RandomNumber.between(300, screenSize.height)));
				}
				else if (getState() instanceof BushesState) {
					objects.add(new Bush(RandomNumber.between(OBJECT_MIN_HEIGHT + 200, OBJECT_MAX_HEIGHT + 200),
							RandomNumber.between(50, screenSize.width - 100),
							RandomNumber.between(300, screenSize.height)));
				}
			}
		}
		objectNumber = newObjectNumber;
	}
		
	public void createPandas() {
		pandas.add(new Panda(RandomNumber.between(50, screenSize.width - 300),
				RandomNumber.between(250, screenSize.height - 150), PANDA_SIZE, PANDA_SIZE));
		
		Panda current;
		for (int i = 0; i < pandaNumber; i++) {
			do {
				current = new Panda(RandomNumber.between(50, screenSize.width - 300),
						RandomNumber.between(250, screenSize.height - 150), PANDA_SIZE, PANDA_SIZE);
			} while (pandaIntersects(current));
			pandas.add(current);
		}
	}

	public void setObjectNumber(int objectNumber) {
		this.objectNumber = objectNumber;
	}

	public int getObjectNumber() {
		return objectNumber;
	}

	
	public boolean pandaIntersects(Panda panda) {
		return pandas.stream().anyMatch(panda::intersects);
	}
	
	public void draw() {
		graphicState.apply();

		for (Panda panda : pandas) {
			panda.draw();
		}
	}

	public void changeState() {
		graphicState = graphicState.nextState();
	}

	public void removeState() {
		graphicState = new EmptyState(this);
	}

	public LayoutState getState() {
		return graphicState;
	}

	public void addAccessory(Panda.AccessoryType accessoryType) {
		for (Panda panda : pandas) {
			panda.setAccessoryType(accessoryType);
		}
	}

	public void addHat(Panda.HatType hatType) {
		for (Panda panda : pandas) {
			panda.setHatType(hatType);
		}
	}
}

