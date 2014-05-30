import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class MyStartPanel extends JPanel {
	private static final long serialVersionUID = -1621932320042675210L;
	private JTextField txtNavigateMazeUsing;
	private JTextField txtBy;
	private JLabel lblMazeGame;

	/**
	 * Create the panel.
	 */
	public MyStartPanel(BufferedImage menu) {
		setOpaque(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblMazeGame = new JLabel(new ImageIcon(menu));
		GridBagConstraints gbc_lblMazeGame = new GridBagConstraints();
		gbc_lblMazeGame.insets = new Insets(0, 0, 5, 0);
		gbc_lblMazeGame.gridx = 0;
		gbc_lblMazeGame.gridy = 0;
		add(lblMazeGame, gbc_lblMazeGame);
		
		JLabel lblInstructions = new JLabel("Instructions");
		GridBagConstraints gbc_lblInstructions = new GridBagConstraints();
		gbc_lblInstructions.insets = new Insets(0, 0, 5, 0);
		gbc_lblInstructions.gridx = 0;
		gbc_lblInstructions.gridy = 1;
		add(lblInstructions, gbc_lblInstructions);
		
		txtNavigateMazeUsing = new JTextField();
		txtNavigateMazeUsing.setHorizontalAlignment(SwingConstants.CENTER);
		txtNavigateMazeUsing.setEditable(false);
		txtNavigateMazeUsing.setText("Navigate maze using arrow keys!");
		GridBagConstraints gbc_txtNavigateMazeUsing = new GridBagConstraints();
		gbc_txtNavigateMazeUsing.insets = new Insets(0, 0, 5, 0);
		gbc_txtNavigateMazeUsing.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNavigateMazeUsing.gridx = 0;
		gbc_txtNavigateMazeUsing.gridy = 2;
		add(txtNavigateMazeUsing, gbc_txtNavigateMazeUsing);
		txtNavigateMazeUsing.setColumns(10);
		
		txtBy = new JTextField();
		txtBy.setEditable(false);
		txtBy.setHorizontalAlignment(SwingConstants.CENTER);
		txtBy.setText("Created by: Andrew Thanh Tran, Arien Judge, Peter Ho, Sohaib Mushtaq");
		GridBagConstraints gbc_txtBy = new GridBagConstraints();
		gbc_txtBy.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBy.gridx = 0;
		gbc_txtBy.gridy = 7;
		add(txtBy, gbc_txtBy);
		txtBy.setColumns(10);
	}

}
