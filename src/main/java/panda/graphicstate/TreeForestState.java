package panda.graphicstate;

import panda.Scene;

public class TreeForestState extends LayoutState {
private static TreeForestState instance;
	
	private TreeForestState(Scene context) {
		this.context = context;
		trees = this;
	}
	
	public static LayoutState getInstance(Scene context) {
		if (instance == null) {
			instance = new TreeForestState(context);
		}
		return instance;
	}

	@Override
	public LayoutState drawBamboos() {
		context.createBambooForest();
		return BambooForestState.getInstance(context);
	}

	@Override
	public LayoutState drawTrees() {
		context.createTreeForest();
		return this;
	}

	@Override
	public LayoutState drawBushes() {
		context.createBushForest();
		return BushesState.getInstance(context);
	}

	@Override
	public LayoutState erase() {
		context.setObjectNumber(0);
		return BushesState.getInstance(context);
	}
	
	@Override
	public String toString() {
		return "Trees";
	}
}
