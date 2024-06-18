package panda.graphicstate;

import panda.Scene;

public abstract class State {
    public abstract void apply(Scene scene);

    public abstract State nextState();
}
