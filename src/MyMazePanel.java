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
		setBackground(Color.BLACK);
		setLayout(new GridLayout(1, 3, 0, 0));
		
		//txtrPlaceholderForGraphicsd = new JTextArea();
		//add(txtrPlaceholderForGraphicsd);
		
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
		
		file = new File("Graphics/Player Sprite.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		player = image;
		
		file = new File("Graphics/rock sprite 1.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		rock1 = image;

		file = new File("Graphics/rock sprite 2.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		rock2 = image;
		
		file = new File("Graphics/rock sprite 3.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		rock3 = image;
		
		file = new File("Graphics/rock sprite 4.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		rock4 = image;
		
		file = new File("Graphics/Wall Sprite 1.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		wall = image;
	
	}
	
	public void setTextTESTING(String text) {
		//txtrPlaceholderForGraphicsd.setText(text);
	}
	
	
	//TODO: re-do this so its legit ;).
	private BufferedImage resize(BufferedImage image, int width, int height) {
	    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(image, 0, 0, width, height, null);
	    g2d.dispose();
	    return bi;
	}
	
	private void resizeEverything (int width, int height){
		neonWall1 = resize(neonWall1, width, height);
		neonWall2 = resize(neonWall2, width, height);
		player = resize(player, width, height);
		rock1 = resize(rock1, width, height);
		rock2 = resize(rock2, width, height);
		rock3 = resize(rock3, width, height);
		rock4 = resize(rock4, width, height);
		wall = resize(wall, width, height);
	}

	private BufferedImage neonWall1;
	private BufferedImage neonWall2;
	private BufferedImage player;
	private BufferedImage rock1;
	private BufferedImage rock2;
	private BufferedImage rock3;
	private BufferedImage rock4;
	private BufferedImage wall;
	//private JTextArea txtrPlaceholderForGraphicsd;

	public void drawMaze(int[][] maz) {
		int pHeight = this.getHeight();
		int pWidth = this.getWidth();
		
		//neonWall1 = image;
		int mHeight = maz.length;
		int mWidth = maz[0].length;
		
		resizeEverything(pWidth/mWidth, pHeight/mHeight);
		//neonWall1 = resize(image, pWidth/mWidth, pHeight/mWidth);
		
		setLayout(new GridLayout(mHeight, mWidth, 0, 0));
		for(int i = 0; i < mWidth; i++){
			for(int j = 0; j < mHeight; j++){
				if(maz[i][j]== 0){
					JLabel picLabel1 = new JLabel(new ImageIcon(rock4));
					this.add(picLabel1);
				}else if(maz[i][j] == Maze.START){
					this.add(new JLabel(new ImageIcon(player)));
				}else if(maz[i][j] == Maze.END){
					this.add(new JLabel(new ImageIcon(rock1)));
				} else{
					add(new JLabel());
					
				}
			
			}
		}
		
	}

	public void addPic() {
		// TODO Auto-generated method stub
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
}
