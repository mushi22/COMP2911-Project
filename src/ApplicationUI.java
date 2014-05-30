import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class ApplicationUI extends JFrame {
	private static final long serialVersionUID = 3721536444080124105L;
	private static final int MAXSIZE = 800;
	private int heightOffSet;
	private int widthOffSet;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationUI frame = new ApplicationUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ApplicationUI() {
		setTitle("Maze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1000, 1000);
		setSize(MAXSIZE, MAXSIZE);
		setResizable(false);
		initGraphics();
		
		Container mainPane = getContentPane();
		layeredPane = new JLayeredPane();
		layeredPane.setOpaque(false);
		mainPane.add(layeredPane);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 10.0, Double.MIN_VALUE};
		layeredPane.setLayout(gridBagLayout);
		
		/*Menu Bar*/
		menuBar = new MyMenuBar();
		setJMenuBar(menuBar);
		
		/*Info Section*/
		infoPanel = new MyInfoPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.anchor = GridBagConstraints.WEST;
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 0;
		layeredPane.add(infoPanel, gbc_infoPanel);
		
		/*Maze Section*/
		GridBagConstraints gbc_MazeSection = new GridBagConstraints();
		gbc_MazeSection.insets = new Insets(0, 0, 0, 0);
		gbc_MazeSection.fill = GridBagConstraints.BOTH;
		gbc_MazeSection.gridx = 0;
		gbc_MazeSection.gridy = 1;
		
		mazePanel = new MyMazePanel();
		
		layeredPane.add(mazePanel, gbc_MazeSection, 2);
		
		playerPanel = new MyPlayerPanel(player);
		layeredPane.add(playerPanel, gbc_MazeSection, 1);
		
		startPanel = new MyStartPanel();
		layeredPane.add(startPanel, gbc_MazeSection, 0);
		
		/*Listeners*/
		menuBar.addMenuBarListener(new MenuBarListener() {
			public void menuBarEventOccured(MenuBarEvent event) {
				String menuName = event.getMenuName();
				command = event.getText();
				
				if (menuName.equals("Beginner") || menuName.equals("Intermediate") || menuName.equals("Advanced") || menuName.equals("Custom")) {
					if (menuName.equals("Beginner")) {
						row = 20;
						column = 20;
						infoPanel.startCount(20);
					} else if (menuName.equals("Intermediate")) {
						row = 40;
						column = 40;
						infoPanel.startCount(40);
					} else if (menuName.equals("Advanced")) {
						row = 60;
						column = 60;
						infoPanel.startCount(60);
					} else if (menuName.equals("Custom")) { //EDIT TO OPEN UP PROMPT MESSAGE, has to be square/ larger than 20
						int ans = 20;
						try{
							ans = Integer.parseInt( JOptionPane.showInputDialog("Enter the dimensions of the desired maze."));
						} catch(NumberFormatException e){
							JOptionPane.showMessageDialog(layeredPane, "Integer was not input. Defaulting to beginner.",
								    "Error",
								    JOptionPane.ERROR_MESSAGE, null); 
						}
						row = ans;
						column = ans;
						infoPanel.startCount(row);
						//http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
						//http://docs.oracle.com/javase/tutorial/uiswing/examples/components/DialogDemoProject/src/components/CustomDialog.java
					}
					paintNewMaze();
				} else if (menuName.equals("New Game")) {
					paintNewMaze();
				} else if (menuName.equals("Restart")) {
					playerPanel.restartPlayer();
				} else if (menuName.equals("Quit")) {
					int option = JOptionPane.showConfirmDialog(mazePanel, "Are you sure?", "Quit", JOptionPane.YES_NO_OPTION);
					mazePanel.requestFocus();
					if (option == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				} else if (menuName.equals("Instructions")) {
					JOptionPane.showMessageDialog(mazePanel, "Use arrow keys on to maneuver character around the maze.\n  ", "Instructions", JOptionPane.PLAIN_MESSAGE);
				} else if (menuName.equals("About Us")) {
					JOptionPane.showMessageDialog(mazePanel, "Created by:\n" + "Andrew Thanh Tran\n" + "Arien Judge\n" + "Peter Ho\n" + "Sohaib Mushtaq\n", "About Us", JOptionPane.PLAIN_MESSAGE);
				}playerPanel.requestFocus();
			}
		});
		
		playerPanel.addKeyListener(new KeyListener() {
			public void keyReleased(KeyEvent e) {
				if (playerPanel.checkWin()){
					int option = JOptionPane.showConfirmDialog(playerPanel, "Congratulations, you finished in " + Integer.toString(infoPanel.getInitial() - infoPanel.stopCount())
																+ " seconds. Would you like you like to play again?", "You Win!", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						paintNewMaze();
					} else {
						System.exit(0);
					}
				}
			}

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				playerPanel.movePlayer(key);
			}

			public void keyTyped(KeyEvent e) {
			}
		});
		
		playerPanel.setFocusable(true);
	}
	
	private int getSize(int mazeSize) {
		int remainder = MAXSIZE%mazeSize;
		return (MAXSIZE - remainder);
	}
	
	private void initGraphics() {
		File file = new File("Graphics/Neon Wall Sprite 1.png");
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException ex) {
		}
		neonWall1 = image;			validate();
		neonWall1Orig = image;
		
		file = new File("Graphics/Neon Wall Sprite 2.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException ex) {
		}
		neonWall2 = image;
		neonWall2Orig = image;
		
		file = new File("Graphics/Player Sprite.png");
		try {
			image = ImageIO.read(file); 
		} catch (IOException ex) {
		}
		player = image;
		playerOrig = image;
		
		file = new File("Graphics/rock sprite 1.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException ex) {
		}
		rock1 = image;
		rock1Orig = image;
		
		file = new File("Graphics/rock sprite 2.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException ex) {
		}
		rock2 = image;
		rock2Orig = image;
		
		file = new File("Graphics/rock sprite 3.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException ex) {
		}
		rock3 = image;
		rock3Orig = image;
		
		file = new File("Graphics/rock sprite 4.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException ex) { 
		}
		rock4 = image;
		rock4Orig = image;
		
		file = new File("Graphics/Wall Sprite 1.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException ex) {
		}
		wall = image;
		wallOrig = image;
	}
	
	private void paintNewMaze() {
		if(row != 0 && column != 0) {
			startPanel.setVisible(false);
			playerPanel.requestFocus();
			Maze mz = new Maze();
			command = mz.generateMaze(row, column);
			heightOffSet = this.getHeight() - mazePanel.getHeight();
			widthOffSet = this.getWidth() - mazePanel.getWidth();
			
			setSize(getSize(row) + widthOffSet, getSize(row) + heightOffSet);
			validate();
			repaint();
			
			int pWidth = mazePanel.getWidth();
			int pHeight = mazePanel.getHeight();
			
			int mHeight = mz.getMaz().length;
			int mWidth = mz.getMaz()[0].length;
			
			resizeEverything(pWidth/mWidth, pHeight/mHeight);
			mazePanel.removeAll();
			mazePanel.drawMaze(mz.getMaz(), rock4, rock1);
			
			mazePanel.revalidate();
			mazePanel.repaint();
			
			playerPanel.revalidate();
			playerPanel.repaint();
			playerPanel.restartPlayer(player, mz);
		} else {
			JOptionPane.showMessageDialog(mazePanel, "You need to start a game first!", "Error", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	private BufferedImage resizeImage(BufferedImage origImage, int width, int height) {
	    BufferedImage tempImage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D tempGraphics = (Graphics2D) tempImage.createGraphics();
	    tempGraphics.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED));
	    tempGraphics.drawImage(origImage, 0, 0, width, height, null);
	    tempGraphics.dispose();
	    return tempImage;
	}
	
	private void resizeEverything (int width, int height){
		neonWall1 = resizeImage(neonWall1Orig, width, height);
		neonWall2 = resizeImage(neonWall2Orig, width, height);
		player = resizeImage(playerOrig, width, height);
		rock1 = resizeImage(rock1Orig, width, height);
		rock2 = resizeImage(rock2Orig, width, height);
		rock3 = resizeImage(rock3Orig, width, height);
		rock4 = resizeImage(rock4Orig, width, height);
		wall = resizeImage(wallOrig, width, height);
	}

	private BufferedImage neonWall1Orig;
	private BufferedImage neonWall2Orig;
	private BufferedImage playerOrig;
	private BufferedImage rock1Orig;
	private BufferedImage rock2Orig;
	private BufferedImage rock3Orig;
	private BufferedImage rock4Orig;
	private BufferedImage wallOrig;
	
	private BufferedImage neonWall1;
	private BufferedImage neonWall2;
	private BufferedImage player;
	private BufferedImage rock1;
	private BufferedImage rock2;
	private BufferedImage rock3;
	private BufferedImage rock4;
	private BufferedImage wall;
	
	JLayeredPane layeredPane;
	
	private MyMenuBar menuBar;
	private MyMazePanel mazePanel;
	private MyInfoPanel infoPanel;
	private MyPlayerPanel playerPanel;
	private MyStartPanel startPanel;
	
	private int row;
	private int column;
	private String command;
}
