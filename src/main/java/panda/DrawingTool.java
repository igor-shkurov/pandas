package panda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DrawingTool extends JFrame implements ActionListener, ItemListener {
	private static final int LABEL_H_MARGIN = 20;
	private static final int LABEL_V_MARGIN = 5;

	private JButton bambooOn, bambooOff;
	private JLabel bambooLabel, bambooNumberLabel;
	private DrawingArea area;
	private ArrayList<JRadioButton> radioButtons;
	private JCheckBox cbStraw;

	private int bambooNumber = 0;

	public DrawingTool(String title) {
		super(title);
		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);

		JPanel sidePanel = new JPanel();

		JPanel verticalPanel = new JPanel();
		verticalPanel.setLayout(new GridLayout(4, 1));
		verticalPanel.add(bambooPanel());
		radioButtons = new ArrayList<>();
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

	public ArrayList<JRadioButton> getRadioButtons() {
		return radioButtons;
	}

	public static void main(String[] args) {
		new DrawingTool("Panda");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bambooOn) {
			cleanup();
			area.getScene().setBambooNumber(bambooNumber);
			area.getScene().createBambooForest();
		} else if (e.getSource() == bambooOff) {
			cleanup();
			area.getScene().deleteBambooForest();
		} else if (e.getSource() == radioButtons.get(1)) {
			cleanup();
			area.getScene().addAccessory(Panda.AccessoryType.CHINESE_FLAG);
		} else if (e.getSource() == radioButtons.get(2)) {
			cleanup();
			area.getScene().addAccessory(Panda.AccessoryType.GERMAN_FLAG);
		} else if (e.getSource() == radioButtons.get(3)) {
			cleanup();
			area.getScene().addAccessory(Panda.AccessoryType.HANDGUN);
		} else if (e.getSource() == radioButtons.get(0)) {
			cleanup();
			area.getScene().addAccessory(Panda.AccessoryType.NO_ACCESSORY);
		}
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
		cbStraw = new JCheckBox("Stray Hat");
		cbStraw.addItemListener(this);

		ButtonGroup buttonGroup = new ButtonGroup();
		radioButtons.forEach(buttonGroup::add);

		radioButtons.forEach(customPanel::add);
		customPanel.add(cbStraw);

		return customPanel;
	}

	public JPanel bambooPanel() {
		JPanel bambooPanel = new JPanel();

		bambooLabel = new JLabel("Bamboo forest:");
		bambooLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		bambooLabel.setBorder(new EmptyBorder(LABEL_V_MARGIN, LABEL_H_MARGIN, LABEL_V_MARGIN, LABEL_H_MARGIN));

		bambooOn = new JButton("Add bamboo");
		bambooOn.addActionListener(this);
		bambooOn.setAlignmentX(Component.CENTER_ALIGNMENT);

		bambooOff = new JButton("Turn off");
		bambooOff.addActionListener(this);
		bambooOff.setAlignmentX(Component.CENTER_ALIGNMENT);

		bambooNumberLabel = new JLabel("Bamboo number: 0");
		bambooNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JSlider slider = new JSlider(JSlider.VERTICAL, 1, 250, 1);

		slider.addChangeListener(e -> {
			bambooNumber = ((JSlider) e.getSource()).getValue();
			bambooNumberLabel.setText("Bamboo number: " + bambooNumber);
		});
		bambooPanel.setLayout(new BoxLayout(bambooPanel, BoxLayout.Y_AXIS));
		bambooPanel.add(bambooLabel);
		bambooPanel.add(bambooOn);
		bambooPanel.add(bambooOff);
		bambooPanel.add(bambooNumberLabel);
		bambooPanel.add(slider, BorderLayout.CENTER);

		return bambooPanel;
	}

}