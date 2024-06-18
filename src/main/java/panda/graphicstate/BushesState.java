package panda.graphicstate;

import panda.Scene;

public class BushesState extends State {
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
    public State nextState() {
        return new EmptyState(scene);
    }

    @Override
    public String toString() {
        return "Bushes";
    }
}
