import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSplitPane;
import java.awt.Color;


public class ApplicationUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6865397917577836605L;

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
		gridBagLayout.columnWeights = new double[]{3.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel MazePanel = new JPanel();
		MazePanel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_MazePanel = new GridBagConstraints();
		gbc_MazePanel.insets = new Insets(0, 0, 5, 5);
		gbc_MazePanel.fill = GridBagConstraints.BOTH;
		gbc_MazePanel.gridx = 0;
		gbc_MazePanel.gridy = 0;
		getContentPane().add(MazePanel, gbc_MazePanel);
		GridBagLayout gbl_MazePanel = new GridBagLayout();
		gbl_MazePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_MazePanel.rowHeights = new int[]{0, 0};
		gbl_MazePanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_MazePanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		MazePanel.setLayout(gbl_MazePanel);
		
		JPanel SettingsPanel = new JPanel();
		SettingsPanel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_SettingsPanel = new GridBagConstraints();
		gbc_SettingsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_SettingsPanel.fill = GridBagConstraints.BOTH;
		gbc_SettingsPanel.gridx = 1;
		gbc_SettingsPanel.gridy = 0;
		getContentPane().add(SettingsPanel, gbc_SettingsPanel);
	}
}
