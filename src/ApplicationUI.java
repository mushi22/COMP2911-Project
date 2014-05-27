import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;


public class ApplicationUI extends JFrame {
	private static final long serialVersionUID = 3721536444080124105L;
	private static final int MAXSIZE = 800;
	
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
		setSize(808,868);
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
		mazePanel = new MyMazePanel();
		GridBagConstraints gbc_MazePanel = new GridBagConstraints();
		gbc_MazePanel.insets = new Insets(0, 0, 0, 0);
		gbc_MazePanel.fill = GridBagConstraints.BOTH;
		gbc_MazePanel.gridx = 0;
		gbc_MazePanel.gridy = 1;
		layeredPane.add(mazePanel, gbc_MazePanel, 1);
		
		playerPanel = new MyPlayerPanel(player);
		GridBagConstraints gbc_PlayerPanel = new GridBagConstraints();
		gbc_PlayerPanel.insets = new Insets(0, 0, 0, 0);
		gbc_PlayerPanel.fill = GridBagConstraints.BOTH;
		gbc_PlayerPanel.gridx = 0;
		gbc_PlayerPanel.gridy = 1;
		layeredPane.add(playerPanel, gbc_PlayerPanel, 0);
		
		/*Listeners*/
		menuBar.addMenuBarListener(new MenuBarListener() {
			public void menuBarEventOccured(MenuBarEvent event) {
				String menuName = event.getMenuName();
				command = event.getText();
				
				if (menuName.equals("Beginner") || menuName.equals("Intermediate") || menuName.equals("Advanced") || menuName.equals("Custom")) {
					if (menuName.equals("Beginner")) {
						row = 20;
						column = 20;
					} else if (menuName.equals("Intermediate")) {
						row = 40;
						column = 40;
					} else if (menuName.equals("Advanced")) {
						row = 60;
						column = 60;
					} else if (menuName.equals("Custom")) { //EDIT TO OPEN UP PROMPT MESSAGE, has to be square/ larger than 20
						row = 100;
						column = 100;
						//http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
						//http://docs.oracle.com/javase/tutorial/uiswing/examples/components/DialogDemoProject/src/components/CustomDialog.java
					}
					setSize(getSize(row) + 8, getSize(row) + 68);
					paintNewMaze();
				} else if (menuName.equals("Restart")) {
					if(row != 0 && column != 0) {
						paintNewMaze();
					} else {
						JOptionPane.showMessageDialog(mazePanel, "You need to start a game first!", "Error", JOptionPane.PLAIN_MESSAGE);
					}
				} else if (menuName.equals("Quit")) {
					int option = JOptionPane.showConfirmDialog(mazePanel, "Are you sure?", "Quit", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				} else if (menuName.equals("Instructions")) {
					
				} else if (menuName.equals("About Us")) {
					JOptionPane.showMessageDialog(mazePanel, "Created by:\n" + "Andrew Thanh Tran\n" + "Arien Judge\n" + "Peter Ho\n" + "Sohaib Mushtaq\n", "About Us", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
	
	private int getSize(int mazeSize) {
		int remainder = MAXSIZE%mazeSize;
		
		return (MAXSIZE - remainder);
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
		neonWall1Orig = image;
		
		file = new File("Graphics/Neon Wall Sprite 2.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		neonWall2 = image;
		neonWall2Orig = image;
		
		file = new File("Graphics/Player Sprite.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		player = image;
		playerOrig = image;
		
		file = new File("Graphics/rock sprite 1.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		rock1 = image;
		rock1Orig = image;
		
		file = new File("Graphics/rock sprite 2.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		rock2 = image;
		rock2Orig = image;
		
		file = new File("Graphics/rock sprite 3.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		rock3 = image;
		rock3Orig = image;
		
		file = new File("Graphics/rock sprite 4.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ... 
		}
		rock4 = image;
		rock4Orig = image;
		
		file = new File("Graphics/Wall Sprite 1.png");
		try {
			image = ImageIO.read(file); //Add IO HANDLING
			//JLabel picLabel = new JLabel(new ImageIcon(image));
			//add(picLabel);
		} catch (IOException ex) {
			// handle exception ...
		}
		wall = image;
		wallOrig = image;
	}
	
	private void paintNewMaze() {
		Maze mz = new Maze();
		command = mz.generateMaze(row, column);

		int pHeight = getHeight() - 68;
		int pWidth = getWidth() - 8;
		
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
		neonWall1 = resize(neonWall1Orig, width, height);
		neonWall2 = resize(neonWall2Orig, width, height);
		player = resize(playerOrig, width, height);
		rock1 = resize(rock1Orig, width, height);
		rock2 = resize(rock2Orig, width, height);
		rock3 = resize(rock3Orig, width, height);
		rock4 = resize(rock4Orig, width, height);
		wall = resize(wallOrig, width, height);
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
	
	private int row;
	private int column;
	private String command;
}
