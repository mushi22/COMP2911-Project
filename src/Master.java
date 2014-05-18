import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//This is the Master/Main Java Class and is reserved for calling other java classes/bringing everything together
public class Master {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame windowFrame = new Board("Board Game");
				windowFrame.setSize(500,500);
				windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				windowFrame.setVisible(true);
			}
		});
	}
}
