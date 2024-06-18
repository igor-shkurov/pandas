package panda.graphicstate;

import panda.Scene;

public class TreeForestState extends State {
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
    public State nextState() {
        return new LakeState(scene);
    }

    @Override
    public String toString() {
        return "Trees";
    }
}
