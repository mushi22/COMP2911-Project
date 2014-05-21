import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;


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
	 */
	public ApplicationUI() {
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
				String text = event.getText();
				
				if (menuName.equals("Beginner") || menuName.equals("Intermediate") || menuName.equals("Advanced")) {
					mazePanel.appendTextTESTING(text);
				} else if (menuName.equals("Custom")) {
					mazePanel.appendTextTESTING(text);
				} else if (menuName.equals("Restart")) {
					mazePanel.appendTextTESTING(text);
				} else if (menuName.equals("Quit")) {
					mazePanel.appendTextTESTING(text);
				} else if (menuName.equals("Instructions")) {
					mazePanel.appendTextTESTING(text);
				} else if (menuName.equals("About Us")) {
					mazePanel.appendTextTESTING(text);
				}
			}
		});
	}
	
	private MyMenuBar menuBar;
	private MyMazePanel mazePanel;
	private MyInfoPanel infoPanel;
}
