import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MyStartPanel extends JPanel {
	private static final long serialVersionUID = -1621932320042675210L;
	private JTextField txtMazeGame;

	/**
	 * Create the panel.
	 */
	public MyStartPanel() {
		setOpaque(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtMazeGame = new JTextField();
		txtMazeGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtMazeGame.setFont(new Font("Traditional Arabic", Font.BOLD, 50));
		txtMazeGame.setText("Maze Game!");
		GridBagConstraints gbc_txtMazeGame = new GridBagConstraints();
		gbc_txtMazeGame.insets = new Insets(0, 0, 5, 0);
		gbc_txtMazeGame.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMazeGame.gridx = 0;
		gbc_txtMazeGame.gridy = 0;
		add(txtMazeGame, gbc_txtMazeGame);
		txtMazeGame.setColumns(10);
		txtMazeGame.setEnabled(false);
		
		JButton btnNewButton = new JButton("Start New Game!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Instructions!");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		add(btnNewButton_1, gbc_btnNewButton_1);

	}

}
