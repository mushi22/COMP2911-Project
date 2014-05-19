import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ApplicationUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6865397917577836605L;
	private JTextField textField;

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
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 547);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{3.0, 0.5};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel MazePanel = new JPanel();
		MazePanel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_MazePanel = new GridBagConstraints();
		gbc_MazePanel.insets = new Insets(0, 0, 0, 0);
		gbc_MazePanel.fill = GridBagConstraints.BOTH;
		gbc_MazePanel.gridx = 0;
		gbc_MazePanel.gridy = 0;
		getContentPane().add(MazePanel, gbc_MazePanel);
		GridBagLayout gbl_MazePanel = new GridBagLayout();
		gbl_MazePanel.columnWidths = new int[]{0};
		gbl_MazePanel.rowHeights = new int[]{0};
		gbl_MazePanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_MazePanel.rowWeights = new double[]{Double.MIN_VALUE};
		MazePanel.setLayout(gbl_MazePanel);
		
		JPanel SettingsPanel = new JPanel();
		SettingsPanel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_SettingsPanel = new GridBagConstraints();
		gbc_SettingsPanel.insets = new Insets(0, 0, 0, 0);
		gbc_SettingsPanel.fill = GridBagConstraints.BOTH;
		gbc_SettingsPanel.gridx = 1;
		gbc_SettingsPanel.gridy = 0;
		getContentPane().add(SettingsPanel, gbc_SettingsPanel);
		GridBagLayout gbl_SettingsPanel = new GridBagLayout();
		gbl_SettingsPanel.columnWidths = new int[]{0, 0};
		gbl_SettingsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_SettingsPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_SettingsPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		SettingsPanel.setLayout(gbl_SettingsPanel);
		
		JButton btnIGiveUp = new JButton("I give up!");
		btnIGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnIGiveUp = new GridBagConstraints();
		gbc_btnIGiveUp.insets = new Insets(0, 0, 0, 0);
		gbc_btnIGiveUp.gridx = 0;
		gbc_btnIGiveUp.gridy = 0;
		SettingsPanel.add(btnIGiveUp, gbc_btnIGiveUp);
		
		JButton btnInstructions = new JButton("Instructions");
		GridBagConstraints gbc_btnInstructions = new GridBagConstraints();
		gbc_btnInstructions.insets = new Insets(0, 0, 0, 0);
		gbc_btnInstructions.gridx = 0;
		gbc_btnInstructions.gridy = 1;
		SettingsPanel.add(btnInstructions, gbc_btnInstructions);
		
		JToggleButton tglbtnSoundOnoff = new JToggleButton("Sound On/Off");
		GridBagConstraints gbc_tglbtnSoundOnoff = new GridBagConstraints();
		gbc_tglbtnSoundOnoff.insets = new Insets(0, 0, 0, 0);
		gbc_tglbtnSoundOnoff.gridx = 0;
		gbc_tglbtnSoundOnoff.gridy = 2;
		SettingsPanel.add(tglbtnSoundOnoff, gbc_tglbtnSoundOnoff);
		
		JPanel InfoPanel = new JPanel();
		GridBagConstraints gbc_InfoPanel = new GridBagConstraints();
		gbc_InfoPanel.insets = new Insets(0, 0, 0, 0);
		gbc_InfoPanel.anchor = GridBagConstraints.NORTH;
		gbc_InfoPanel.fill = GridBagConstraints.BOTH;
		gbc_InfoPanel.gridx = 0;
		gbc_InfoPanel.gridy = 3;
		SettingsPanel.add(InfoPanel, gbc_InfoPanel);
		GridBagLayout gbl_InfoPanel = new GridBagLayout();
		gbl_InfoPanel.columnWidths = new int[]{0};
		gbl_InfoPanel.rowHeights = new int[]{0, 0};
		gbl_InfoPanel.columnWeights = new double[]{0.0};
		gbl_InfoPanel.rowWeights = new double[]{0.0, 0.0};
		InfoPanel.setLayout(gbl_InfoPanel);
		
		JLabel label = new JLabel("Time Elapsed");
		label.setEnabled(false);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		InfoPanel.add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		InfoPanel.add(textField, gbc_textField);
		textField.setColumns(10);
	}
}
