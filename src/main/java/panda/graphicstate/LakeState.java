package panda.graphicstate;

import panda.Scene;

public class LakeState extends State {
    private final Scene scene;

    LakeState(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void apply() {

    }

    @Override
    public State nextState() {
        return new EmptyState(scene);
    }

    @Override
    public String toString() {
        return "Lake";
    }
}
