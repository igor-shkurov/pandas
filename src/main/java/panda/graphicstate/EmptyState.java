package panda.graphicstate;

import panda.Scene;

public class EmptyState extends LayoutState {
	private static EmptyState instance;
	
	private EmptyState(Scene context) {
		this.context = context;
		nothing = this;
	}
	
	public static LayoutState getInstance(Scene context) {
		if (instance == null) {
			instance = new EmptyState(context);
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
		return this;
	}
}
