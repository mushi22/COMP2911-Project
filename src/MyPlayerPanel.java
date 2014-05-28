import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
/*
 * So this creates a panel of the same size as mazePanel which will still 
 *  redraw a lot and will probably be slow still. We could try make the player panel smaller 
 *  and move the panel on each press. This will probably need a different layout type.
 *  
 */
import javax.swing.Timer;

public class MyPlayerPanel extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 3084030380611255577L;
	public static final int ANIMATION_SPEED = 5;
	private Timer animationTimer;
	private int x;
	private int y;
	private BufferedImage playerSprite;
	private Maze maz;
	private Player p;
	
	public MyPlayerPanel(BufferedImage playerSprite){
		setOpaque(false);
		x = 0;
		y = 0;
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
		this.maz = maz;
		p = new Player(maz);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(playerSprite, x, y, this);
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT && p.moveleft(maz)) {
			x = x - playerSprite.getWidth();
			p.setPosition(p.getPosition().x - 1,p.getPosition().y);
		} else if (key == KeyEvent.VK_RIGHT && p.moveright(maz)) {
			x = x + playerSprite.getWidth();
			p.setPosition(p.getPosition().x + 1,p.getPosition().y);
		} else if (key == KeyEvent.VK_UP && p.moveup(maz)) {
			y = y - playerSprite.getHeight();
			p.setPosition(p.getPosition().x,p.getPosition().y - 1);
		} else if (key == KeyEvent.VK_DOWN && p.movedown(maz)) {
			p.setPosition(p.getPosition().x,p.getPosition().y + 1);
			y  = y + playerSprite.getHeight();
		}
		//System.out.println(playerSprite.getWidth() + " " +playerSprite.getHeight());
	}
	

	public void keyTyped(KeyEvent arg0) {}
	public void keyReleased(KeyEvent arg0) {
	}
}
