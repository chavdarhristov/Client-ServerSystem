package busStopClient.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

	/**
	** @author Krzysztof Majcher
	*/

public class TablePanel{

	private JPanel contentPane;
	private JTable table;
	private JLabel lblBusStop;

	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JTable getTable() {
		return table;
	}

	public JLabel getLblBusStop() {
		return lblBusStop;
	}

	public TablePanel() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		lblBusStop = new JLabel("bus stop");
		lblBusStop.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusStop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBusStop.setBounds(10, 11, 414, 29);
		contentPane.add(lblBusStop);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 414, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bus", "Time", "Average delay"
			}
		));
		scrollPane.setViewportView(table);
	}
}
