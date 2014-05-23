import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyMazePanel extends JPanel {
	private static final long serialVersionUID = 3766751218594555709L;

	/**
	 * Create the panel.
	 * @throws IOException
	 */
	public MyMazePanel() throws IOException {
		setBackground(Color.BLACK);	
	}
	
	public void drawMaze(int[][] maz, BufferedImage sprite) {
		int mHeight = maz.length;
		int mWidth = maz[0].length;
		
		setLayout(new GridLayout(mHeight, mWidth, 0, 0));
		for(int i = 0; i < mWidth; i++){
			for(int j = 0; j < mHeight; j++){
				if(maz[i][j]== 0){
					JLabel picLabel = new JLabel(new ImageIcon(sprite));
					this.add(picLabel);
				} else{
					add(new JLabel());
					
				}
			}
		}
	}
}
