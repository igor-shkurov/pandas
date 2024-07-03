package panda.graphicstate;

import panda.Scene;

public abstract class LayoutState {
	protected Scene context;
	
	protected static EmptyState nothing;
	protected static BambooForestState bamboos;
	protected static TreeForestState trees;
	protected static BushesState bushes;
	
    public abstract LayoutState drawBamboos();
    public abstract LayoutState drawTrees();
    public abstract LayoutState drawBushes();
    public abstract LayoutState erase();
}
