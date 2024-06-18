package panda.graphicstate;

import panda.Scene;

public class EmptyState extends State {
    @Override
    public void apply(Scene scene) {
        // do nothing
    }

    @Override
    public State nextState() {
        return new BambooForestState();
    }

    @Override
    public String toString() {
        return "Empty State";
    }
}
