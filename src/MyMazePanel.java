import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MyMazePanel extends JPanel {
	private static final long serialVersionUID = 3766751218594555709L;

	/**
	 * Create the panel.
	 */
	public MyMazePanel() {
		setBackground(Color.DARK_GRAY);
		
		GridBagLayout gbl_MazePanel = new GridBagLayout();
		gbl_MazePanel.columnWidths = new int[]{0, 0};
		gbl_MazePanel.rowHeights = new int[]{0, 0};
		gbl_MazePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_MazePanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gbl_MazePanel);
		
		txtrPlaceholderForGraphicsd = new JTextArea();
		//txtrPlaceholderForGraphicsd.setText("PLACEHOLDER FOR GRAPHICS2D");
		GridBagConstraints gbc_txtrPlaceholderForGraphicsd = new GridBagConstraints();
		gbc_txtrPlaceholderForGraphicsd.fill = GridBagConstraints.BOTH;
		gbc_txtrPlaceholderForGraphicsd.gridx = 0;
		gbc_txtrPlaceholderForGraphicsd.gridy = 0;
		add(txtrPlaceholderForGraphicsd, gbc_txtrPlaceholderForGraphicsd);
	}
	
	public void setTextTESTING(String text) {
		txtrPlaceholderForGraphicsd.setText(text);
	}
	
	private JTextArea txtrPlaceholderForGraphicsd;
}
