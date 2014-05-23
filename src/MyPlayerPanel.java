import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * So this creates a panel of the same size as mazePanel which will still 
 *  redraw a lot and will probably be slow still. We could try make the player panel smaller 
 *  and move the panel on each press. This will probably need a different layout type.
 *  
 */

public class MyPlayerPanel extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 3084030380611255577L;
	public static final int SPEED = 2;
	public static final int ANIMATION_SPEED = 5;
	private Timer animationTimer;
	private int x;
	private int y;
	private int delX;
	private int delY;
	private BufferedImage playerSprite;
	
	public MyPlayerPanel(BufferedImage playerSprite){
		setOpaque(false);
		x = 0;
		y = 0;
		delX = 0;
		delY = 0;
		animationTimer = new Timer(ANIMATION_SPEED, this);
		animationTimer.start();
		addKeyListener(this);
		setFocusable(true); //Enable KeyListener
		setFocusTraversalKeysEnabled(false); //No shift/tab keys
		this.playerSprite = playerSprite;
	}
	public void restartPlayer(){
		x = 0;
		y = 0;
		delX = 0;
		delY = 0;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(playerSprite, x, y, this);
	}
	
	public void actionPerformed(ActionEvent e) {
		x = x + delX;
		y = y + delY;
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			delX = -SPEED;
			delY = 0;
		} else if (key == KeyEvent.VK_RIGHT) {
			delX = SPEED;
			delY = 0;
		} else if (key == KeyEvent.VK_UP) {
			delX = 0;
			delY = -SPEED;
		} else if (key == KeyEvent.VK_DOWN) {
			delX = 0;
			delY = SPEED;
		}
	}
	

	public void keyTyped(KeyEvent arg0) {}
	public void keyReleased(KeyEvent arg0) {
		delX = 0;
		delY = 0;
	}
}
