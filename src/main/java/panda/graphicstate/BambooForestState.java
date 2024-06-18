package panda.graphicstate;

import panda.Scene;

public class BambooForestState extends State {
    private Scene scene;

    public BambooForestState(Scene scene) {
        this.scene = scene;
        scene.createBambooForest();
    }

    @Override
    public void apply() {
        scene.drawBambooForest();
    }

    @Override
    public State nextState() {
        return new TreeForestState(scene);
    }

    @Override
    public String toString() {
        return "Bamboos";
    }
}
