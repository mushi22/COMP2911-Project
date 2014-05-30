import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class MyInfoPanel extends JPanel {
	private static final long serialVersionUID = 8699105079283174266L;
	private Timer countdown;
	
	private int delay = 1000;
	private int secRemain;
	private JTextField timeField;
	private Timer t;
	/**
	 * Create the panel.
	 */
	public MyInfoPanel() {
		setBackground(Color.LIGHT_GRAY);
		
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[]{0,0};
		gbl_infoPanel.rowHeights = new int[]{0};
		gbl_infoPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_infoPanel.rowWeights = new double[]{1.0};
		setLayout(gbl_infoPanel);
		
		JLabel timeLabel = new JLabel("Time Remaining");
		GridBagConstraints gbc_timeLabel = new GridBagConstraints();
		gbc_timeLabel.insets = new Insets(0, 0, 0, 0);
		gbc_timeLabel.gridx = 0;
		gbc_timeLabel.gridy = 0;
		add(timeLabel, gbc_timeLabel);
		
		timeField = new JTextField();
		GridBagConstraints gbc_timeField = new GridBagConstraints();
		gbc_timeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeField.gridx = 1;
		gbc_timeField.gridy = 0;
		add(timeField, gbc_timeField);
		timeField.setColumns(10);
		timeField.setEnabled(false);
		t = new Timer(delay, updateBox);
	}
	
	ActionListener updateBox = new ActionListener() {
		
	      public void actionPerformed(ActionEvent e) {
	    	  secRemain--;
	    	  timeField.setText(Integer.toString(secRemain));
	      }
		};
		
	public void startCount(int time){
		if(t.isRunning())
			t.stop();
		secRemain = time;
		//t = new Timer(delay, updateBox);
		t.start();
	}

}
