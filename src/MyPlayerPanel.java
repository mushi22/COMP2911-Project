import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
/*
 * So this creates a panel of the same size as mazePanel which will still 
 *  redraw a lot and will probably be slow still. We could try make the player panel smaller 
 *  and move the panel on each press. This will probably need a different layout type.
 *  
 */
import javax.swing.Timer;

public class MyPlayerPanel extends JPanel implements ActionListener{
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
		this.playerSprite = playerSprite;
		
		/*this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0),
                "moveright");
		
		this.getActionMap().put("moveright",
                moveright);
		
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0),
                "moveleft");
		
		this.getActionMap().put("moveleft",
                moveleft);
		
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
                "moveup");
		
		this.getActionMap().put("moveup",
                moveup);
		
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),
                "movedown");
		
		this.getActionMap().put("movedown",
                movedown);*/ 
		
		p = new Player();
		p.setPosition(x,y);
	}
	
	/*Action moveright = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        movePlayer(KeyEvent.VK_RIGHT);
	    }
	};
	
	Action moveleft = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        movePlayer(KeyEvent.VK_LEFT);
	    }
	};
	
	Action moveup = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        movePlayer(KeyEvent.VK_UP);
	    }
	};
	
	Action movedown = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        movePlayer(KeyEvent.VK_DOWN);
	    }
	};*/
	
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
	
	public Boolean checkWin() {
		return p.checkWin(maz);
	}
	
	public void movePlayer(int key) {
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
	}

	public void restartPlayer() {
		x = 0;
		y = 0;
		p = new Player();
		
	}
}
