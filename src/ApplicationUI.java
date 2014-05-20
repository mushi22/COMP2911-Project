import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ApplicationUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6865397917577836605L;
	private JTextField timeRemainingField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationUI frame = new ApplicationUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ApplicationUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 547);
		
		/*Menu Items*/
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Game");
		menuBar.add(mnNewMenu);
		
		JMenu mnLevel = new JMenu("Level");
		mnNewMenu.add(mnLevel);
		
		JMenuItem mntmBeginner = new JMenuItem("Beginner");
		mnLevel.add(mntmBeginner);
		
		JMenuItem mntmIntermediate = new JMenuItem("Intermediate");
		mnLevel.add(mntmIntermediate);
		
		JMenuItem mntmAdvanced = new JMenuItem("Advanced");
		mnLevel.add(mntmAdvanced);
		
		JMenuItem mntmCustom = new JMenuItem("Custom");
		mnLevel.add(mntmCustom);
		
		JMenuItem mntmRestart = new JMenuItem("Restart");
		mnNewMenu.add(mntmRestart);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnNewMenu.add(mntmQuit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmInstructions = new JMenuItem("Instructions");
		mnHelp.add(mntmInstructions);
		
		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mnHelp.add(mntmAboutUs);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{10.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		/*Maze Section*/
		JPanel MazeUI = new JPanel();
		MazeUI.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_MazeUI = new GridBagConstraints();
		gbc_MazeUI.insets = new Insets(0, 0, 0, 0);
		gbc_MazeUI.fill = GridBagConstraints.BOTH;
		gbc_MazeUI.gridx = 0;
		gbc_MazeUI.gridy = 0;
		getContentPane().add(MazeUI, gbc_MazeUI);
		GridBagLayout gbl_MazeUI = new GridBagLayout();
		gbl_MazeUI.columnWidths = new int[]{0, 0};
		gbl_MazeUI.rowHeights = new int[]{0, 0};
		gbl_MazeUI.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_MazeUI.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		MazeUI.setLayout(gbl_MazeUI);
		
		JTextArea txtrPlaceholderForGraphicsd = new JTextArea();
		txtrPlaceholderForGraphicsd.setText("PLACEHOLDER FOR GRAPHICS2D");
		GridBagConstraints gbc_txtrPlaceholderForGraphicsd = new GridBagConstraints();
		gbc_txtrPlaceholderForGraphicsd.fill = GridBagConstraints.BOTH;
		gbc_txtrPlaceholderForGraphicsd.gridx = 0;
		gbc_txtrPlaceholderForGraphicsd.gridy = 0;
		MazeUI.add(txtrPlaceholderForGraphicsd, gbc_txtrPlaceholderForGraphicsd);
		
		/*Info Section*/
		JPanel InfoPanel = new JPanel();
		InfoPanel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_InfoPanel = new GridBagConstraints();
		gbc_InfoPanel.anchor = GridBagConstraints.WEST;
		gbc_InfoPanel.fill = GridBagConstraints.BOTH;
		gbc_InfoPanel.gridx = 0;
		gbc_InfoPanel.gridy = 1;
		getContentPane().add(InfoPanel, gbc_InfoPanel);
		GridBagLayout gbl_InfoPanel = new GridBagLayout();
		gbl_InfoPanel.columnWidths = new int[]{0,0};
		gbl_InfoPanel.rowHeights = new int[]{0};
		gbl_InfoPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_InfoPanel.rowWeights = new double[]{1.0};
		InfoPanel.setLayout(gbl_InfoPanel);
		
		JLabel lblTimeRemaining = new JLabel("Time Remaining");
		GridBagConstraints gbc_lblTimeRemaining = new GridBagConstraints();
		gbc_lblTimeRemaining.insets = new Insets(0, 0, 0, 0);
		gbc_lblTimeRemaining.gridx = 0;
		gbc_lblTimeRemaining.gridy = 0;
		InfoPanel.add(lblTimeRemaining, gbc_lblTimeRemaining);
		
		timeRemainingField = new JTextField();
		GridBagConstraints gbc_timeRemainingField = new GridBagConstraints();
		gbc_timeRemainingField.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeRemainingField.gridx = 1;
		gbc_timeRemainingField.gridy = 0;
		InfoPanel.add(timeRemainingField, gbc_timeRemainingField);
		timeRemainingField.setColumns(10);
		timeRemainingField.setEnabled(false);
		
	}
}
