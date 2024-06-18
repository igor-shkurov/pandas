package panda.graphicstate;

import panda.Scene;

public class BushesState extends LayoutState {
    private final Scene scene;

    BushesState(Scene scene) {
        this.scene = scene;
        scene.createBushForest();
    }

    @Override
    public void apply() {
        scene.drawBushForest();
    }

    @Override
    public LayoutState nextState() {
        return new EmptyState(scene);
    }

    @Override
    public String toString() {
        return "Bushes";
    }
}
