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
		
		initGraphics();
	}
	
	private void initGraphics() {
		File file = new File("Graphics/Neon Wall Sprite 1.png");
		BufferedImage image = null;
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		neonWall1 = image;
		
		file = new File("Graphics/Neon Wall Sprite 2.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		neonWall2 = image;
		
		JLabel picLabel1 = new JLabel(new ImageIcon(neonWall1));
		add(picLabel1);
		
		JLabel picLabel2 = new JLabel(new ImageIcon(neonWall2));
		add(picLabel2);
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

	private BufferedImage neonWall1;
	private BufferedImage neonWall2;
//	private BufferedImage player;
//	private BufferedImage rock1;
//	private BufferedImage rock2;
//	private BufferedImage rock3;
//	private BufferedImage rock4;
//	private BufferedImage wall;
	private JTextArea txtrPlaceholderForGraphicsd;
}
