import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Board extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Master frame = new Master();
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
	public Board() {
		setTitle("Maze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel BoardPanel = new JPanel();
		GridBagConstraints gbc_BoardPanel = new GridBagConstraints();
		gbc_BoardPanel.gridwidth = 13;
		gbc_BoardPanel.insets = new Insets(0, 0, 0, 5);
		gbc_BoardPanel.fill = GridBagConstraints.BOTH;
		gbc_BoardPanel.gridx = 0;
		gbc_BoardPanel.gridy = 0;
		contentPane.add(BoardPanel, gbc_BoardPanel);
		GridBagLayout gbl_BoardPanel = new GridBagLayout();
		gbl_BoardPanel.columnWidths = new int[]{0};
		gbl_BoardPanel.rowHeights = new int[]{0};
		gbl_BoardPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_BoardPanel.rowWeights = new double[]{Double.MIN_VALUE};
		BoardPanel.setLayout(gbl_BoardPanel);
		
		JPanel SettingsPanel = new JPanel();
		GridBagConstraints gbc_SettingsPanel = new GridBagConstraints();
		gbc_SettingsPanel.fill = GridBagConstraints.BOTH;
		gbc_SettingsPanel.gridx = 13;
		gbc_SettingsPanel.gridy = 0;
		contentPane.add(SettingsPanel, gbc_SettingsPanel);
		GridBagLayout gbl_SettingsPanel = new GridBagLayout();
		gbl_SettingsPanel.columnWidths = new int[]{103, 78, 0};
		gbl_SettingsPanel.rowHeights = new int[]{20, 0};
		gbl_SettingsPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_SettingsPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		SettingsPanel.setLayout(gbl_SettingsPanel);
		
		JLabel lblTime = new JLabel("Time Left: ");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.insets = new Insets(0, 0, 0, 5);
		gbc_lblTime.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTime.gridx = 0;
		gbc_lblTime.gridy = 0;
		SettingsPanel.add(lblTime, gbc_lblTime);
		
	}

}
