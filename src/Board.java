import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/*Bookmarks
 * http://www.eclipse.org/windowbuilder/
 * http://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
 * http://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html*/

public class Board extends JFrame {
	public Board(String title) {
		super(title);
		
		// Set Layout Manager
		// Will switch to GridBagLayout
		setLayout(new BorderLayout());
		
		// Create Swing Components
		final JTextArea textArea = new JTextArea();
		JButton button = new JButton("TESTING");
		
		// Add Swing components to content pane
		Container contentPane = getContentPane();
		
		contentPane.add(textArea, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.SOUTH);
		
		// Add Behaviour
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("TESTING\n");
			}
			
		});
	}
}