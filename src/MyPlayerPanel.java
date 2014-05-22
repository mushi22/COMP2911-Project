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

/*
 * So this creates a panel of the same size as mazePanel which will still 
 *  redraw a lot and will probably be slow still. We could try make the player panel smaller 
 *  and move the panel on each press. This will probably need a different layout type.
 *  
 */

public class MyPlayerPanel extends JPanel{
	private static final long serialVersionUID = 3084030380611255577L;

	public MyPlayerPanel() throws IOException {
		setLayout(new GridLayout(1, 3, 0, 0));
		
		setBackground(new Color(0,0,0,0));
	}
		
		public void drawPlayer(int[][] maz, BufferedImage spriteStart, BufferedImage spriteEnd) {
			
			//neonWall1 = image;
			int mHeight = maz.length;
			int mWidth = maz[0].length;
			
			//neonWall1 = resize(image, pWidth/mWidth, pHeight/mWidth);
			
			setLayout(new GridLayout(mHeight, mWidth, 0, 0));
			for(int i = 0; i < mWidth; i++){
				for(int j = 0; j < mHeight; j++){
					if(maz[i][j] == Maze.START){
						this.add(new JLabel(new ImageIcon(spriteStart)));
					}else if(maz[i][j] == Maze.END){
						this.add(new JLabel(new ImageIcon(spriteEnd)));
					} else{
						add(new JLabel());
						
					}
				
				}
			}
			
		}
		//txtrPlaceholderForGraphicsd = new JTextArea();
		//add(txtrPlaceholderForGraphicsd);
		
		//initGraphics();
		
}
