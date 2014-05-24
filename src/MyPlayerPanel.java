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
	private Maze maz;
	private Player p;
	
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
		
		p = new Player();
		p.setPosition(x,y);
	}
	
	
	public void restartPlayer(BufferedImage playerSprite, Maze maz){
		this.playerSprite = playerSprite;
		x = 0;
		y = 0;
		delX = 0;
		delY = 0;
		this.maz = maz;
		p = new Player(maz);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(playerSprite, x, y, this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (x < 0) {
			x = 0;
			delX = 0;
		} else if (x > this.getWidth() - playerSprite.getWidth()) {
			x = this.getWidth() - playerSprite.getWidth();
			delX = 0;
		}
		
		if (y < 0) {
			y = 0;
			delY = 0;
		} else if (y > getHeight() - playerSprite.getHeight()) {
			y = this.getHeight() - playerSprite.getHeight();
			delY = 0;
		}
		
		if(x/playerSprite.getWidth() > p.getPosition().x)
			p.setPosition(p.getPosition().x + 1,p.getPosition().y);
		if(x/playerSprite.getWidth() < p.getPosition().x)
			p.setPosition(p.getPosition().x - 1,p.getPosition().y);
		if(y/playerSprite.getHeight() > p.getPosition().y)
			p.setPosition(p.getPosition().x,p.getPosition().y + 1);
		
		if(y/playerSprite.getHeight() < p.getPosition().y)
			p.setPosition(p.getPosition().x,p.getPosition().y - 1);
		
		x = x + delX;
		y = y + delY;
		
		
		System.out.println(p.getPosition().x + " " + p.getPosition().y);
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT && p.moveleft(maz)) {
			delX = -SPEED;
			delY = 0;
		} else if (key == KeyEvent.VK_RIGHT && p.moveright(maz)) {
			delX = SPEED;
			delY = 0;
		} else if (key == KeyEvent.VK_UP && p.moveup(maz)) {
			delX = 0;
			delY = -SPEED;
		} else if (key == KeyEvent.VK_DOWN && p.movedown(maz)) {
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
