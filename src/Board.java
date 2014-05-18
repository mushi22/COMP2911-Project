import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Board {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame windowFrame = new JFrame("Board Game");
				windowFrame.setSize(500,500);
				windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				windowFrame.setVisible(true);
			}
		});
	}
}
