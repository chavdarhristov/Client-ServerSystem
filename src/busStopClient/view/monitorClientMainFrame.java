package busStopClient.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

	/**
	** @author Krzysztof Majcher
	*/

public class monitorClientMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JButton button;

	
	
	public JPanel getContentPane() {
		return contentPane;
	}



	public JTextField getTextField() {
		return textField;
	}



	public JComboBox getComboBox() {
		return comboBox;
	}



	public JButton getButton() {
		return button;
	}



	public monitorClientMainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBusStop = new JLabel("Bus stop:");
		lblBusStop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBusStop.setBounds(89, 87, 88, 24);
		contentPane.add(lblBusStop);
		
		textField = new JTextField();
		textField.setBounds(172, 91, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDay.setBounds(89, 122, 88, 24);
		contentPane.add(lblDay);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY "}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(174, 126, 156, 20);
		contentPane.add(comboBox);
		
		JLabel lblPleaseLoginUsing = new JLabel("Please log-in using yor bus stop name and day of a week");
		lblPleaseLoginUsing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseLoginUsing.setBounds(41, 11, 357, 56);
		contentPane.add(lblPleaseLoginUsing);
		
		button = new JButton("Log-in");
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(146, 180, 133, 45);
		contentPane.add(button);
	}
}
