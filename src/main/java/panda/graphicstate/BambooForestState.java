package panda.graphicstate;

import panda.Scene;

public class BambooForestState extends State {
    @Override
    public void apply(Scene scene) {
        scene.createBambooForest();
        scene.drawBambooForest();
    }

    @Override
    public State nextState() {
        return new TreeForestState();
    }

    @Override
    public String toString() {
        return "Bamboo Forest State";
    }
}
