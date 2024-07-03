package panda.graphicstate;

import panda.Scene;

public class BushesState extends LayoutState {
	private static BushesState instance;
	
	private BushesState(Scene context) {
		this.context = context;
		bushes = this;
		
	}
	
	public static LayoutState getInstance(Scene context) {
		if (instance == null) {
			instance = new BushesState(context);
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
		return this;
	}

	@Override
	public LayoutState erase() {
		context.setObjectNumber(0);
		return EmptyState.getInstance(context);
	}
    
	@Override
	public String toString() {
		return "Bushes";
	}
}
