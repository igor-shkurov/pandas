package panda.graphicstate;

import panda.Scene;

public class TreeForestState extends LayoutState {
    private final Scene scene;

    public TreeForestState(Scene scene) {
        this.scene = scene;
        scene.createTreeForest();
    }

    @Override
    public void apply() {
        scene.drawTreeForest();
    }

    @Override
    public LayoutState nextState() {
        return new BushesState(scene);
    }

    @Override
    public String toString() {
        return "Trees";
    }
}
