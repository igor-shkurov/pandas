package panda.graphicstate;

import panda.Scene;

public class TreeForestState extends State {
    @Override
    public void apply(Scene scene) {

    }

    @Override
    public State nextState() {
        return new LakeState();
    }

    @Override
    public String toString() {
        return "Tree Forest State";
    }
}
