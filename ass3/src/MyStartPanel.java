import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;


public class MyStartPanel extends JPanel {
	private static final long serialVersionUID = -1621932320042675210L;
	private JLabel lblMazeGame;
	private JLabel lblNavigateMazeUsing;
	private JLabel lblCreatedByAndrew;

	/**
	 * Create the panel.
	 */
	public MyStartPanel(BufferedImage menu) {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setOpaque(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblMazeGame = new JLabel(new ImageIcon(menu));
		GridBagConstraints gbc_lblMazeGame = new GridBagConstraints();
		gbc_lblMazeGame.insets = new Insets(0, 0, 5, 0);
		gbc_lblMazeGame.gridx = 0;
		gbc_lblMazeGame.gridy = 0;
		add(lblMazeGame, gbc_lblMazeGame);
		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInstructions.setBackground(Color.BLACK);
		lblInstructions.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblInstructions = new GridBagConstraints();
		gbc_lblInstructions.insets = new Insets(0, 0, 5, 0);
		gbc_lblInstructions.gridx = 0;
		gbc_lblInstructions.gridy = 1;
		add(lblInstructions, gbc_lblInstructions);
		
		lblNavigateMazeUsing = new JLabel("Navigate maze using arrow keys!");
		lblNavigateMazeUsing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNavigateMazeUsing.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNavigateMazeUsing = new GridBagConstraints();
		gbc_lblNavigateMazeUsing.insets = new Insets(0, 0, 5, 0);
		gbc_lblNavigateMazeUsing.gridx = 0;
		gbc_lblNavigateMazeUsing.gridy = 2;
		add(lblNavigateMazeUsing, gbc_lblNavigateMazeUsing);
		
		lblCreatedByAndrew = new JLabel("Created by: Andrew Thanh Tran, Arien Judge, Peter Ho, Sohaib Mushtaq");
		lblCreatedByAndrew.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCreatedByAndrew = new GridBagConstraints();
		gbc_lblCreatedByAndrew.gridx = 0;
		gbc_lblCreatedByAndrew.gridy = 7;
		add(lblCreatedByAndrew, gbc_lblCreatedByAndrew);
	}

}
