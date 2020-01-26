package backUp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScheduleD extends JPanel {

	/**
	 * Create the panel.
	 */
	public ScheduleD() {
		setLayout(null);
		
		JLabel lblNextBusStop = new JLabel("Next Bus Stop:");
		lblNextBusStop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNextBusStop.setBounds(60, 60, 117, 24);
		add(lblNextBusStop);
		
		JLabel lblNextBusStop_1 = new JLabel("Next Bus Stop");
		lblNextBusStop_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNextBusStop_1.setBounds(187, 60, 117, 24);
		add(lblNextBusStop_1);
		
		JLabel lblScheduledTime = new JLabel("Scheduled time:");
		lblScheduledTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblScheduledTime.setBounds(60, 95, 117, 24);
		add(lblScheduledTime);
		
		JLabel lblScheduledTime_1 = new JLabel("Scheduled time");
		lblScheduledTime_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblScheduledTime_1.setBounds(187, 95, 117, 24);
		add(lblScheduledTime_1);
		
		JButton btnNewButton = new JButton("Arrived");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(151, 185, 129, 56);
		add(btnNewButton);

	}

}
