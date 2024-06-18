package panda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import panda.graphicstate.*;

import java.awt.*;

public class StateTest {
    State state = new EmptyState(new Scene(new Dimension()));

    @Test
    void checkStateRotation() {
        assertInstanceOf(EmptyState.class, state);
        state = state.nextState();
        assertInstanceOf(BambooForestState.class, state);
        state = state.nextState();
        assertInstanceOf(TreeForestState.class, state);
        state = state.nextState();
        assertInstanceOf(BushesState.class, state);
        state = state.nextState();
        assertInstanceOf(EmptyState.class, state);
    }
}
