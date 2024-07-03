package panda.graphicstate;

import panda.Scene;

public class BambooForestState extends LayoutState {
	private static BambooForestState instance;
	
	private BambooForestState(Scene context) {
		this.context = context;
		bamboos = this;
	}
	
	public static LayoutState getInstance(Scene context) {
		if (instance == null) {
			instance = new BambooForestState(context);
		}
		return instance;
	}

	@Override
	public LayoutState drawBamboos() {
		context.createBambooForest();
		return this;
	}

	@Override
	public LayoutState drawTrees() {
		context.createTreeForest();
		return TreeForestState.getInstance(context);
	}

	@Override
	public LayoutState drawBushes() {
		context.createBushForest();
		return BushesState.getInstance(context);
	}

	@Override
	public LayoutState erase() {
		context.setObjectNumber(0);
		return EmptyState.getInstance(context);
	}
	
	@Override
	public String toString() {
		return "Bamboos";
	}
}
