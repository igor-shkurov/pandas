package panda.graphicstate;

import panda.Scene;

public abstract class LayoutState {
    public abstract void apply();

    public abstract LayoutState nextState();
}
