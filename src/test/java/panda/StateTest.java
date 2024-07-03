package panda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import panda.graphicstate.*;

import java.awt.*;

public class StateTest {
    LayoutState state = EmptyState.getInstance(new Scene(new Dimension()));

    @Test
    void checkStateRotation() {
        assertInstanceOf(EmptyState.class, state);
        state = state.drawBamboos();
        assertInstanceOf(BambooForestState.class, state);
        state = state.drawTrees();
        assertInstanceOf(TreeForestState.class, state);
        state = state.drawBushes();
        assertInstanceOf(BushesState.class, state);
        state = state.erase();
        assertInstanceOf(EmptyState.class, state);
    }
}
