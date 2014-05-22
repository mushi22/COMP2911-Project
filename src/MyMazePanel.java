import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridLayout;


public class MyMazePanel extends JPanel {
	private static final long serialVersionUID = 3766751218594555709L;

	/**
	 * Create the panel.
	 * @throws IOException
	 */
	public MyMazePanel() throws IOException {
		setBackground(Color.DARK_GRAY);
		setLayout(new GridLayout(0, 3, 0, 0));
		
		txtrPlaceholderForGraphicsd = new JTextArea();
		add(txtrPlaceholderForGraphicsd);
		
		String path = System.getProperty("user.dir");
		System.out.println(path + "\\Graphics\\Player Sprite.png");
		File file = new File(path + "\\Graphics\\Player Sprite.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			JLabel picLabel = new JLabel(new ImageIcon(image));
			add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		
		path = System.getProperty("user.dir");
		System.out.println(path + "\\Graphics\\Neon Wall Sprite 1.png");
		file = new File(path + "\\Graphics\\Neon Wall Sprite 1.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			JLabel picLabel = new JLabel(new ImageIcon(image));
			add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		
	}
	
	public void setTextTESTING(String text) {
		txtrPlaceholderForGraphicsd.setText(text);
	}

	private BufferedImage image;
	private JTextArea txtrPlaceholderForGraphicsd;
}
