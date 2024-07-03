package panda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import panda.graphicstate.BambooForestState;
import panda.graphicstate.BushesState;
import panda.graphicstate.EmptyState;
import panda.graphicstate.TreeForestState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

class DrawingToolTest {
    DrawingTool drawingTool = new DrawingTool("Panda");
    Scene scene = drawingTool.getDrawingArea().getScene();

    @Test
    void testIfStrawHatChangeApplies() {
        Panda.HatType requiredHat = Panda.HatType.STRAW_HAT;
        ItemEvent e = new ItemEvent(new JCheckBox(), 0, new Object(), ItemEvent.SELECTED);
        drawingTool.itemStateChanged(e);
        ArrayList<Panda> pandas = drawingTool.getDrawingArea().getScene().getPandas();
        assertTrue(pandas.stream().allMatch(panda -> { return panda.getHatType() == requiredHat; }));
    }

    @Test
    void testIfNoHatChangeApplies() {
        Panda.HatType requiredHat = Panda.HatType.NO_HAT;
        ItemEvent e = new ItemEvent(new JCheckBox(), 0, new Object(), ItemEvent.DESELECTED);
        drawingTool.itemStateChanged(e);
        ArrayList<Panda> pandas = drawingTool.getDrawingArea().getScene().getPandas();
        assertTrue(pandas.stream().allMatch(panda -> { return panda.getHatType() == requiredHat; }));
    }

    @Test
    void testThatFourRadioButtonsAreCreated() {
        assertEquals(4, drawingTool.getRadioButtons().size());
    }

    @Test
    void testIfNoFlagChangeApplies() {
        Panda.AccessoryType requiredAccessory = Panda.AccessoryType.NO_ACCESSORY;
        ActionEvent e = new ActionEvent(drawingTool.getRadioButtons().get(0), 0, "");
        drawingTool.actionPerformed(e);
        ArrayList<Panda> pandas = drawingTool.getDrawingArea().getScene().getPandas();
        assertTrue(pandas.stream().allMatch(panda -> { return panda.getAccessoryType() == requiredAccessory; }));
    }

    @Test
    void testIfChineseFlagChangeApplies() {
        Panda.AccessoryType requiredAccessory = Panda.AccessoryType.CHINESE_FLAG;
        ActionEvent e = new ActionEvent(drawingTool.getRadioButtons().get(1), 0, "");
        drawingTool.actionPerformed(e);
        ArrayList<Panda> pandas = drawingTool.getDrawingArea().getScene().getPandas();
        assertTrue(pandas.stream().allMatch(panda -> { return panda.getAccessoryType() == requiredAccessory; }));
    }

    @Test
    void testIfGermanFlagChangeApplies() {
        Panda.AccessoryType requiredAccessory = Panda.AccessoryType.GERMAN_FLAG;
        ActionEvent e = new ActionEvent(drawingTool.getRadioButtons().get(2), 0, "");
        drawingTool.actionPerformed(e);
        ArrayList<Panda> pandas = drawingTool.getDrawingArea().getScene().getPandas();
        assertTrue(pandas.stream().allMatch(panda -> { return panda.getAccessoryType() == requiredAccessory; }));
    }

    @Test
    void testIfHandGunChangeApplies() {
        Panda.AccessoryType requiredAccessory = Panda.AccessoryType.HANDGUN;
        ActionEvent e = new ActionEvent(drawingTool.getRadioButtons().get(3), 0, "");
        drawingTool.actionPerformed(e);
        ArrayList<Panda> pandas = drawingTool.getDrawingArea().getScene().getPandas();
        assertTrue(pandas.stream().allMatch(panda -> { return panda.getAccessoryType() == requiredAccessory; }));
    }

    @Test
    void testChangeToBamboos() {
        assertInstanceOf(EmptyState.class, scene.getState());
        ActionEvent e = new ActionEvent(drawingTool.getButtons().get(0), 0, "");
        drawingTool.actionPerformed(e);
        assertInstanceOf(BambooForestState.class, scene.getState());
    }

    @Test
    void testChangeToTrees() {
        ActionEvent e = new ActionEvent(drawingTool.getButtons().get(1), 0, "");
        drawingTool.actionPerformed(e);
        assertInstanceOf(TreeForestState.class, scene.getState());
    }

    @Test
    void testChangeToBushes() {
        ActionEvent e = new ActionEvent(drawingTool.getButtons().get(2), 0, "");
        drawingTool.actionPerformed(e);
        assertInstanceOf(BushesState.class, scene.getState());
    }

    @Test
    void testDisableStateButton() {
        ActionEvent e = new ActionEvent(drawingTool.getButtons().get(3), 0, "");
        drawingTool.actionPerformed(e);
        assertInstanceOf(EmptyState.class, scene.getState());
    }
}