import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * A sample user management system
 * 
 * @author Prince Duepa
 */
public class EpicViwer extends JPanel implements ActionListener {
	private JButton addPatientBtn;
	protected static PatientList pList = new PatientList();

	public EpicViwer() {
		super(new GridLayout(1, 1));
		pList.add(new Patient("Prince", "Duepa", "12/01/1993"));

		addPatientBtn = new JButton("Add patient");
		addPatientBtn.addActionListener(this);

		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("images/middle.gif");
		JPanel parent = new JPanel();
		JComponent addPatientPanel = new AddPatientPanel();
		// addPatientPanel.
		parent.add(addPatientPanel);
		parent.add(addPatientBtn);

		tabbedPane.addTab("Add patient (1)", icon, parent, "Add a new patient record");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent searchPatientPanel = new SearchPatientPanel();
		tabbedPane.addTab("Search patient (2)", icon, searchPatientPanel, "Search for existing patient record");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = EpicViwer.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public static void main(String[] args) {
		Random rand = new Random();

		System.out.println(Math.abs(rand.nextInt()));
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Epic");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add content to the window.
		frame.add(new EpicViwer(), BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String name = AddPatientPanel.nameTextField.getText();
		String dob = AddPatientPanel.dobTextField.getText();
		String address = AddPatientPanel.addressTextField.getText();

		if ((name.length()) != 0 && (dob.length() != 0) && (address.length() != 0)) {
			String[] names = name.split(" ");
			Patient p = new Patient(names[0], names[1], dob);
			p.setAddress(address);
			pList.add(p);
		}
	}

}
