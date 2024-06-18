package panda.graphicstate;

import panda.Scene;

public class LakeState extends State {
    @Override
    public void apply(Scene scene) {

    }

    @Override
    public State nextState() {
        return new EmptyState();
    }

    @Override
    public String toString() {
        return "Lake State";
    }
}
