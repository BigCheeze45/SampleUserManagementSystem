import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class AddPatientPanel extends JPanel {
	private String[] inputLabels = { "Name:", "Date Of Birth (DOB):", "Address:" };
	protected static JTextField nameTextField, dobTextField, addressTextField;
	private JLabel label;
	private String[] toolTips	= {"Patient's name", "Patient's DOB", "Patient's address"};

	public AddPatientPanel() {
		initPanel();
	}

	private void initPanel() {
		setLayout(new SpringLayout());
		label = new JLabel(inputLabels[0], JLabel.TRAILING);
		add(label);
		nameTextField = new JTextField(10);
		label.setLabelFor(nameTextField);
		add(nameTextField);
		
		label = new JLabel(inputLabels[1], JLabel.TRAILING);
		add(label);
		dobTextField = new JTextField(10);
		label.setLabelFor(dobTextField);
		add(dobTextField);
		
		label = new JLabel(inputLabels[2], JLabel.TRAILING);
		add(label);
		addressTextField = new JTextField(10);
		label.setLabelFor(addressTextField);
		add(addressTextField);
		
//		for (int i = 0; i < inputLabels.length; i++) {
//			JLabel label = new JLabel(inputLabels[i], JLabel.TRAILING);
//			add(label);
//			JTextField textField = new JTextField(10);
//			textField.addActionListener(new ActionPeformer());
//			textField.setToolTipText(toolTips[i]);
//			label.setLabelFor(textField);
//			add(textField);
//		}

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, inputLabels.length, 2, // rows, cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad
	}

	/*
	 * public static void main(String[] args) { // Schedule a job for the event
	 * dispatch thread: // creating and showing this application's GUI.
	 * SwingUtilities.invokeLater(new Runnable() { public void run() { // Turn off
	 * metal's use of bold fonts UIManager.put("swing.boldMetal", Boolean.FALSE);
	 * createAndShowGUI(); } }); }
	 * 
	 * /** Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 * 
	 * private static void createAndShowGUI() { // Create and set up the window.
	 * JFrame frame = new JFrame("AddPatient");
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.setPreferredSize(new Dimension(750, 600)); // Add content to the
	 * window. frame.add(new AddPatientPanel(), BorderLayout.CENTER);
	 * 
	 * // Display the window. frame.pack(); frame.setLocationRelativeTo(null);
	 * frame.setVisible(true); }
	 */

}
