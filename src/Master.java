import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class Master extends JFrame {

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
	public Master() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		gbc_BoardPanel.gridwidth = 10;
		gbc_BoardPanel.insets = new Insets(0, 0, 0, 5);
		gbc_BoardPanel.fill = GridBagConstraints.BOTH;
		gbc_BoardPanel.gridx = 0;
		gbc_BoardPanel.gridy = 0;
		contentPane.add(BoardPanel, gbc_BoardPanel);
		
		JPanel SettingsPanel = new JPanel();
		GridBagConstraints gbc_SettingsPanel = new GridBagConstraints();
		gbc_SettingsPanel.gridwidth = 4;
		gbc_SettingsPanel.fill = GridBagConstraints.BOTH;
		gbc_SettingsPanel.gridx = 10;
		gbc_SettingsPanel.gridy = 0;
		contentPane.add(SettingsPanel, gbc_SettingsPanel);
	}

}
