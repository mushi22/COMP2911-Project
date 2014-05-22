import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


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
			image = resize(image, 200, 200);
			JLabel picLabel = new JLabel(new ImageIcon(image));
			add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		
		path = System.getProperty("user.dir");
		System.out.println(path + "\\Graphics\\Neon Wall Sprite 1.png");
		file = new File(path + "\\Graphics\\Neon Wall Sprite 1.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING\
			image = resize(image, 200, 200);
			JLabel picLabel = new JLabel(new ImageIcon(image));
			add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		
	}
	
	public void setTextTESTING(String text) {
		txtrPlaceholderForGraphicsd.setText(text);
	}
	
	public static BufferedImage resize(BufferedImage image, int width, int height) {
	    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(image, 0, 0, width, height, null);
	    g2d.dispose();
	    return bi;
	}

	private BufferedImage image;
	private JTextArea txtrPlaceholderForGraphicsd;
}
