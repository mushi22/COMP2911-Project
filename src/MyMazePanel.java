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
		
		//initGraphics();
		
	}
	
	
	//private JTextArea txtrPlaceholderForGraphicsd;
	public void setTextTESTING(String text) {
		//txtrPlaceholderForGraphicsd.setText(text);
	}
	
	public void drawMaze(int[][] maz, BufferedImage sprite) {
		
		//neonWall1 = image;
		int mHeight = maz.length;
		int mWidth = maz[0].length;
		
		//neonWall1 = resize(image, pWidth/mWidth, pHeight/mWidth);
		
		setLayout(new GridLayout(mHeight, mWidth, 0, 0));
		for(int i = 0; i < mWidth; i++){
			for(int j = 0; j < mHeight; j++){
				if(maz[i][j]== 0){
					JLabel picLabel1 = new JLabel(new ImageIcon(sprite));
					this.add(picLabel1);
				//}else if(maz[i][j] == Maze.START){
				//	this.add(new JLabel(new ImageIcon(player)));
				//}else if(maz[i][j] == Maze.END){
				//	this.add(new JLabel(new ImageIcon(rock1)));
				} else{
					add(new JLabel());
					
				}
			
			}
		}
		
	}
}
