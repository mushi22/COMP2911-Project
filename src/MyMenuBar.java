import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.EventListenerList;
import java.awt.Color;


public class MyMenuBar extends JMenuBar{
	private static final long serialVersionUID = -3004868188333448242L;
	
	public MyMenuBar() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		listenerList = new EventListenerList();
		
		gameMenu = new JMenu("Game");
		gameMenu.setForeground(Color.WHITE);
		gameMenu.setBackground(Color.BLACK);
		add(gameMenu);
		
		levelMenu = new JMenu("Level");
		levelMenu.setForeground(Color.WHITE);
		levelMenu.setBackground(Color.BLACK);
		gameMenu.add(levelMenu);
		
		beginnerMenu = new JMenuItem("Beginner");
		beginnerMenu.setForeground(Color.WHITE);
		beginnerMenu.setBackground(Color.BLACK);
		beginnerMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String menuName = "Beginner";
				String mazeText = "BEGINNER TEST\n"; //Call Maze.java
				fireEvent(new MenuBarEvent(this, menuName, mazeText));
			}
		});
		levelMenu.add(beginnerMenu);
		
		intermediateMenu = new JMenuItem("Intermediate");
		intermediateMenu.setForeground(Color.WHITE);
		intermediateMenu.setBackground(Color.BLACK);
		intermediateMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String menuName = "Intermediate";
				String mazeText = "INTERMEDIATE TEST\n"; //Call Maze.java
				fireEvent(new MenuBarEvent(this, menuName, mazeText));
			}
		});
		levelMenu.add(intermediateMenu);
		
		advancedMenu = new JMenuItem("Advanced");
		advancedMenu.setForeground(Color.WHITE);
		advancedMenu.setBackground(Color.BLACK);
		advancedMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String menuName = "Advanced";
				String mazeText = "ADVANCED TEST\n"; //Call Maze.java
				fireEvent(new MenuBarEvent(this, menuName, mazeText));
			}
		});
		levelMenu.add(advancedMenu);
		
		customMenu = new JMenuItem("Custom");
		customMenu.setForeground(Color.WHITE);
		customMenu.setBackground(Color.BLACK);
		customMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String menuName = "Custom";
				String mazeText = "CUSTOM TEST\n"; //Call Maze.java
				fireEvent(new MenuBarEvent(this, menuName, mazeText));
			}
		});
		levelMenu.add(customMenu);
		
		newGameMenu = new JMenuItem("New Game");
		newGameMenu.setForeground(Color.WHITE);
		newGameMenu.setBackground(Color.BLACK);
		newGameMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String menuName = "New Game";
				String mazeText = "NEW GAME TEST\n"; //Call Maze.java
				fireEvent(new MenuBarEvent(this, menuName, mazeText));
			}
		});
		gameMenu.add(newGameMenu);
		
		restartMenu = new JMenuItem("Restart");
		restartMenu.setForeground(Color.WHITE);
		restartMenu.setBackground(Color.BLACK);
		restartMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String menuName = "Restart";
				String mazeText = "RESTART TEST\n"; //Call Maze.java
				fireEvent(new MenuBarEvent(this, menuName, mazeText));
			}
		});
		gameMenu.add(restartMenu);
		
		quitMenu = new JMenuItem("Quit");
		quitMenu.setForeground(Color.WHITE);
		quitMenu.setBackground(Color.BLACK);
		quitMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String menuName = "Quit";
				String mazeText = "QUIT TEST\n"; //Call Maze.java
				fireEvent(new MenuBarEvent(this, menuName, mazeText));
			}
		});
		gameMenu.add(quitMenu);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setBackground(Color.BLACK);
		helpMenu.setForeground(Color.WHITE);
		add(helpMenu);
		
		instructionsMenu = new JMenuItem("Instructions");
		instructionsMenu.setForeground(Color.WHITE);
		instructionsMenu.setBackground(Color.BLACK);
		instructionsMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String menuName = "Instructions";
				String mazeText = "INSTRUCTIONS TEST"; //Call Maze.java
				fireEvent(new MenuBarEvent(this, menuName, mazeText));
			}
		});
		helpMenu.add(instructionsMenu);
		
		aboutUsMenu = new JMenuItem("About Us");
		aboutUsMenu.setForeground(Color.WHITE);
		aboutUsMenu.setBackground(Color.BLACK);
		aboutUsMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String menuName = "About Us";
				String mazeText = "ABOUT US TEST"; //Call Maze.java
				fireEvent(new MenuBarEvent(this, menuName, mazeText));
			}
		});
		helpMenu.add(aboutUsMenu);
	}
	
	public void fireEvent(MenuBarEvent event) {
		Object[] listeners = listenerList.getListenerList();
		
		for(int i = 0; i < listeners.length - 1; i += 2) {
			if(listeners[i] == MenuBarListener.class) {
				((MenuBarListener) listeners[i+1]).menuBarEventOccured(event); 
			}
		}
	}
	
	public void addMenuBarListener(MenuBarListener listener) {
		listenerList.add(MenuBarListener.class, listener);
	}
	
	public void removeMenuBarListener(MenuBarListener listener) {
		listenerList.remove(MenuBarListener.class, listener);
	}
	
	private JMenu gameMenu;
	private JMenu levelMenu;
	private JMenuItem beginnerMenu;
	private JMenuItem intermediateMenu;
	private JMenuItem advancedMenu;
	private JMenuItem customMenu;
	private JMenuItem restartMenu;
	private JMenuItem newGameMenu;
	private JMenuItem quitMenu;
	private JMenuItem instructionsMenu;
	private JMenuItem aboutUsMenu;
	private EventListenerList listenerList;
}
