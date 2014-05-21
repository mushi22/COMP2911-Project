import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MyMenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3454796118738865237L;

	public MyMenuBar() {
		JMenu gameMenu = new JMenu("Game");
		add(gameMenu);
		
		JMenu levelMenu = new JMenu("Level");
		gameMenu.add(levelMenu);
		
		JMenuItem beginnerMenu = new JMenuItem("Beginner");
		levelMenu.add(beginnerMenu);
		
		JMenuItem intermediateMenu = new JMenuItem("Intermediate");
		levelMenu.add(intermediateMenu);
		
		JMenuItem advancedMenu = new JMenuItem("Advanced");
		levelMenu.add(advancedMenu);
		
		JMenuItem customMenu = new JMenuItem("Custom");
		levelMenu.add(customMenu);
		
		JMenuItem restartMenu = new JMenuItem("Restart");
		gameMenu.add(restartMenu);
		
		JMenuItem quitMenu = new JMenuItem("Quit");
		gameMenu.add(quitMenu);
		
		JMenu helpMenu = new JMenu("Help");
		add(helpMenu);
		
		JMenuItem instructionsMenu = new JMenuItem("Instructions");
		helpMenu.add(instructionsMenu);
		
		JMenuItem aboutUsMenu = new JMenuItem("About Us");
		helpMenu.add(aboutUsMenu);
	}
}
