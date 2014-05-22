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
import javax.swing.JOptionPane;


public class ApplicationUI extends JFrame {
	private static final long serialVersionUID = 3721536444080124105L;
	
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

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public ApplicationUI() throws IOException {
		setTitle("Maze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{10.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		/*Menu Bar*/
		menuBar = new MyMenuBar();
		setJMenuBar(menuBar);
		
		/*Maze Section*/
		mazePanel = new MyMazePanel();
		GridBagConstraints gbc_MazePanel = new GridBagConstraints();
		gbc_MazePanel.insets = new Insets(0, 0, 0, 0);
		gbc_MazePanel.fill = GridBagConstraints.BOTH;
		gbc_MazePanel.gridx = 0;
		gbc_MazePanel.gridy = 0;
		getContentPane().add(mazePanel, gbc_MazePanel);
		
		playerPanel = new MyPlayerPanel();
		GridBagConstraints gbc_PlayerPanel = new GridBagConstraints();
		gbc_PlayerPanel.insets = new Insets(0, 0, 0, 0);
		gbc_PlayerPanel.fill = GridBagConstraints.BOTH;
		gbc_PlayerPanel.gridx = 0;
		gbc_PlayerPanel.gridy = 0;
		getContentPane().add(playerPanel, gbc_PlayerPanel);
		
		/*Info Section*/
		infoPanel = new MyInfoPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.anchor = GridBagConstraints.WEST;
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 1;
		getContentPane().add(infoPanel, gbc_infoPanel);
		
		
		initGraphics();
		/*Listeners*/
		menuBar.addMenuBarListener(new MenuBarListener() {
			public void menuBarEventOccured(MenuBarEvent event) {
				String menuName = event.getMenuName();
				String text = event.getText();	//Change to COMMAND!
				
				if (menuName.equals("Beginner") || menuName.equals("Intermediate") || menuName.equals("Advanced") || menuName.equals("Custom")) {
					Maze mz = new Maze();
					int row = 0;
					int column = 0;
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
					}
					//System.out.println("Hello");
					text = mz.generateMaze(row, column);
					
					int pHeight = mazePanel.getHeight();
					int pWidth = mazePanel.getWidth();
					
					//neonWall1 = image;
					int mHeight = mz.getMaz().length;
					int mWidth = mz.getMaz()[0].length;
					
					resizeEverything(pWidth/mWidth, pHeight/mHeight);
					//mazePanel.setTextTESTING(text);
					mazePanel.removeAll();
					playerPanel.removeAll();
					mazePanel.drawMaze(mz.getMaz(), rock4);
					playerPanel.drawPlayer(mz.getMaz(),player,rock1);
					//mazePanel.addPic();
					
					mazePanel.revalidate();
					mazePanel.repaint();
					playerPanel.revalidate();
					playerPanel.repaint();
				} else if (menuName.equals("Restart")) {
					//mazePanel.setTextTESTING(text);
					//USING THIS FOR DEBUG -> LOADING GRAPHICS RESOURCES
					String path = System.getProperty("user.dir");
					System.out.println(path + "\\Graphics\\Neon Wall Sprite 1.png");
					File file = new File(path + "\\Graphics\\Neon Wall Sprite 1.png");
					
					if(!file.exists()) {
						System.out.println("Something is broken :(");
					}
					
				} else if (menuName.equals("Quit")) {
					int option = JOptionPane.showConfirmDialog(mazePanel, "Are you sure?", "Quit", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				} else if (menuName.equals("Instructions")) {
					//mazePanel.setTextTESTING(text);
				} else if (menuName.equals("About Us")) {
					JOptionPane.showMessageDialog(mazePanel, "Created by:\n" + "Andrew Thanh Tran\n" + "Arien Judge\n" + "Peter Ho\n" + "Sohaib Mushtaq\n", "About Us", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
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
	
	private MyMenuBar menuBar;
	private MyMazePanel mazePanel;
	private MyInfoPanel infoPanel;
	private MyPlayerPanel playerPanel;
}
