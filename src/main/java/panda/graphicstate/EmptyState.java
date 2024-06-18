package panda.graphicstate;

import panda.Scene;

public class EmptyState extends LayoutState {
    private final Scene scene;

    public EmptyState(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void apply() {
        // do nothing
    }

    @Override
    public LayoutState nextState() {
        return new BambooForestState(scene);
    }

    @Override
    public String toString() {
        return "Empty";
    }
}
