package panda;

import panda.graphicstate.EmptyState;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DrawingTool extends JFrame implements ActionListener, ItemListener {
	private static final int LABEL_H_MARGIN = 20;
	private static final int LABEL_V_MARGIN = 5;
	private static final String alignmentProperty = "<head><style>body{text-align: center;}</style></head>";

	private JLabel stateLabel, stateObjectsLabel;
	private final DrawingArea area;
	private final ArrayList<JRadioButton> radioButtons;
	private final ArrayList<JButton> buttons;

	private JSlider objectSlider;

    private int stateObjectsNumber;

	public DrawingTool(String title) {
		super(title);
		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);

		buttons = new ArrayList<>();
		radioButtons = new ArrayList<>();

		JPanel sidePanel = new JPanel();

		JPanel verticalPanel = new JPanel();
		verticalPanel.setLayout(new GridLayout(4, 1));
		verticalPanel.add(statePanel());
		verticalPanel.add(customizationPanel());

		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		sidePanel.add(verticalPanel);
		sidePanel.add(new JButton());

		area = new DrawingArea();
		add(sidePanel, BorderLayout.WEST);
		add(area, BorderLayout.CENTER);

		setVisible(true);
	}

	public DrawingArea getDrawingArea() { // used for testing
		return area;
	}

	public ArrayList<JRadioButton> getRadioButtons() { // used for testing
		return radioButtons;
	}

	public ArrayList<JButton> getButtons() { // used for testing
		return buttons;
	}

	public static void main(String[] args) {
		new DrawingTool("Panda");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Scene scene = area.getScene();

		if (e.getSource() == buttons.get(0)) {
			scene.createBambooForest();
			scene.changeToBamboos();
		} else if (e.getSource() == buttons.get(1)) {
			scene.createTreeForest();
			scene.changeToTrees();
		} else if (e.getSource() == buttons.get(2)) {
			scene.createBushForest();
			scene.changeToBushes();
		} else if (e.getSource() == buttons.get(3)) {
			objectSlider.setEnabled(false);
			objectSlider.setValue(0);
			stateObjectsLabel.setText("-");
			area.getScene().removeState();
			stateLabel.setText("<html>" + alignmentProperty + "<body>Panda Location:<br>At home</body></html>");
		} else if (e.getSource() == radioButtons.get(1)) {
			scene.addAccessory(Panda.AccessoryType.CHINESE_FLAG);
		} else if (e.getSource() == radioButtons.get(2)) {
			scene.addAccessory(Panda.AccessoryType.GERMAN_FLAG);
		} else if (e.getSource() == radioButtons.get(3)) {
			scene.addAccessory(Panda.AccessoryType.HANDGUN);
		} else if (e.getSource() == radioButtons.get(0)) {
			scene.addAccessory(Panda.AccessoryType.NO_ACCESSORY);
		}

		if (e.getSource() instanceof JButton && e.getSource() != buttons.get(3)) {
			stateLabel.setText("<html>" + alignmentProperty + "<body>Panda Location:<br>" + scene.getState().toString() + "</body></html>");
			objectSlider.setEnabled(true);
			stateObjectsLabel.setText("Object number: " + scene.getObjectNumber());
			int currentObjectVal = scene.getObjectNumber();
			objectSlider.setMaximum(currentObjectVal);
			objectSlider.setValue(currentObjectVal);
		}

		cleanup();
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			cleanup();
			area.getScene().addHat(Panda.HatType.STRAW_HAT);
		} else {
			cleanup();
			area.getScene().addHat(Panda.HatType.NO_HAT);
		}
	}

	private void cleanup() {
		area.repaint();
		area.revalidate();
		area.repaint();
	}

	public JPanel customizationPanel() {
		JPanel customPanel = new JPanel();
		customPanel.setLayout(new BoxLayout(customPanel, BoxLayout.Y_AXIS));

		radioButtons.add(new JRadioButton("None"));
		radioButtons.get(0).addActionListener(this);
		radioButtons.add(new JRadioButton("Chinese flag"));
		radioButtons.get(1).addActionListener(this);
		radioButtons.add(new JRadioButton("German flag"));
		radioButtons.get(2).addActionListener(this);
		radioButtons.add(new JRadioButton("Handgun"));
		radioButtons.get(3).addActionListener(this);
        JCheckBox cbStraw = new JCheckBox("Stray Hat");
		cbStraw.addItemListener(this);

		ButtonGroup buttonGroup = new ButtonGroup();
		radioButtons.forEach(buttonGroup::add);

		radioButtons.forEach(customPanel::add);
		customPanel.add(cbStraw);

		return customPanel;
	}

	public JPanel statePanel() {
		JPanel statePanel = new JPanel();

		stateLabel = new JLabel("<html>" + alignmentProperty + "<body>Panda Location:<br>At home</body></html>");
		stateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		stateLabel.setBorder(new EmptyBorder(LABEL_V_MARGIN, LABEL_H_MARGIN, LABEL_V_MARGIN, LABEL_H_MARGIN));

		buttons.add(new JButton("Bamboos"));
		buttons.get(0).addActionListener(this);
		buttons.get(0).setAlignmentX(Component.CENTER_ALIGNMENT);
		
		buttons.add(new JButton("Trees"));
		buttons.get(1).addActionListener(this);
		buttons.get(1).setAlignmentX(Component.CENTER_ALIGNMENT);
		
		buttons.add(new JButton("Bushes"));
		buttons.get(2).addActionListener(this);
		buttons.get(2).setAlignmentX(Component.CENTER_ALIGNMENT);

		buttons.add(new JButton("Disable state"));
		buttons.get(3).addActionListener(this);
		buttons.get(3).setAlignmentX(Component.CENTER_ALIGNMENT);

		stateObjectsLabel = new JLabel("Object number: 0");
		stateObjectsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		objectSlider = new JSlider(JSlider.VERTICAL, 0, 200, 1);
		objectSlider.setEnabled(false);
		objectSlider.addChangeListener(e -> {
			cleanup();
			stateObjectsNumber = ((JSlider) e.getSource()).getValue();
			stateObjectsLabel.setText("Object number: " + stateObjectsNumber);
			area.getScene().changeObjectNumber(stateObjectsNumber);

		});

		statePanel.setLayout(new BoxLayout(statePanel, BoxLayout.Y_AXIS));
		statePanel.add(stateLabel);
		statePanel.add(buttons.get(0));
		statePanel.add(buttons.get(1));
		statePanel.add(buttons.get(2));
		statePanel.add(buttons.get(3));
		statePanel.add(stateObjectsLabel);
		statePanel.add(objectSlider, BorderLayout.CENTER);

		return statePanel;
	}

}