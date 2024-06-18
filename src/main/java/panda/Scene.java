package panda;

import panda.graphicstate.BambooForestState;
import panda.graphicstate.EmptyState;
import panda.graphicstate.State;

import java.awt.Dimension;
import java.util.ArrayList;

public class Scene {
	private static final int BAMBOO_MAX_HEIGHT = 250;
	private static final int BAMBOO_MIN_HEIGHT = 100;
	private static final int PANDA_SIZE = 150;

	private int bambooNumber;
	private State graphicState;

	private final int pandaNumber;
	private final ArrayList<Panda> pandas;
	private final ArrayList<Object> bamboos;
	private final Dimension screenSize;
	
	public Scene(Dimension screenSize) {
        this.graphicState = new EmptyState(this);
		this.screenSize = screenSize;

        bambooNumber = 50;
		pandaNumber = this.screenSize.width / PANDA_SIZE;
		pandas = new ArrayList<>();
		bamboos = new ArrayList<>();
		createPandas();
	}

	public ArrayList<Panda> getPandas() { // used for testing
		return pandas;
	}

	public void setBambooNumber(int bambooNumber) {
		this.bambooNumber = bambooNumber;
	}

	public int getBambooNumber() {
		return bambooNumber;
	}
	
	public void createBambooForest() {
		bamboos.clear();
		for (int i = 0; i < bambooNumber; i++) {
			bamboos.add(new Bamboo(RandomNumber.between(BAMBOO_MIN_HEIGHT, BAMBOO_MAX_HEIGHT),
					RandomNumber.between(50, screenSize.width - 100),
					RandomNumber.between(300, screenSize.height)));
		}
	}

	public void drawBambooForest() {
		for (Object bamboo : bamboos) {
			((Bamboo) bamboo).draw();
		}
	}

	public void createTreeForest() {
		bamboos.clear();
		for (int i = 0; i < bambooNumber; i++) {
			bamboos.add(new Tree(RandomNumber.between(BAMBOO_MIN_HEIGHT, BAMBOO_MAX_HEIGHT),
					RandomNumber.between(50, screenSize.width - 100),
					RandomNumber.between(300, screenSize.height)));
		}
	}

	public void drawTreeForest() {
		for (Object bamboo : bamboos) {
			((Tree) bamboo).draw();
		}
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
	
	public boolean pandaIntersects(Panda panda) {
		return pandas.stream().anyMatch(panda::intersects);
	}
	
	public void draw() {
		graphicState.apply();

		for (Panda panda : pandas) {
			panda.draw();
		}
	}

	public State changeState() {
		graphicState = graphicState.nextState();
		System.out.println("changed to " + graphicState);
		return graphicState;
	}

	public void removeState() {
		graphicState = new EmptyState(this);
		System.out.println("empty now");
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

