package panda.graphicstate;

import panda.Scene;

public class EmptyState extends State {
    private final Scene scene;

    public EmptyState(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void apply() {
        // do nothing
    }

    @Override
    public State nextState() {
        return new BambooForestState(scene);
    }

    @Override
    public String toString() {
        return "Nothing";
    }
}
