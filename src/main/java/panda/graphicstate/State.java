package panda.graphicstate;

import panda.Scene;

public abstract class State {
    public abstract void apply();

    public abstract State nextState();
}
