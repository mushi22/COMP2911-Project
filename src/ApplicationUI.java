import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

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
		setBounds(100, 100, 843, 547);
		
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
		
		/*Info Section*/
		infoPanel = new MyInfoPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.anchor = GridBagConstraints.WEST;
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 1;
		getContentPane().add(infoPanel, gbc_infoPanel);
		
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
						row = 5;
						column = 5;
					} else if (menuName.equals("Intermediate")) {
						row = 10;
						column = 10;
					} else if (menuName.equals("Advanced")) {
						row = 15;
						column = 15;
					} else if (menuName.equals("Custom")) { //EDIT TO OPEN UP PROMPT MESSAGE
						row = 20;
						column = 20;
					}
					
					text = mz.generateMaze(row, column);
					mazePanel.setTextTESTING(text);
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
					mazePanel.setTextTESTING(text);
				} else if (menuName.equals("About Us")) {
					JOptionPane.showMessageDialog(mazePanel, "Create by:\n" + "Andrew Thanh Tran\n" + "Arien Judge\n" + "Peter Ho\n" + "Sohaib Mushtaq\n", "About Us", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
	
	private MyMenuBar menuBar;
	private MyMazePanel mazePanel;
	private MyInfoPanel infoPanel;
}
