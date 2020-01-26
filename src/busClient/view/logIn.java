package busClient.view;

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

public class logIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JButton btnLogin;

	
	
	public JPanel getContentPane() {
		return contentPane;
	}



	public JTextField getTextField() {
		return textField;
	}



	public JComboBox getComboBox() {
		return comboBox;
	}



	public JButton getBtnLogin() {
		return btnLogin;
	}



	public logIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseLoginUsing = new JLabel("Please log-in using yor bus number and day of a week");
		lblPleaseLoginUsing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseLoginUsing.setBounds(50, 11, 360, 56);
		contentPane.add(lblPleaseLoginUsing);
		
		JLabel lblBusNumver = new JLabel("Bus Number");
		lblBusNumver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBusNumver.setBounds(96, 78, 75, 14);
		contentPane.add(lblBusNumver);
		
		textField = new JTextField();
		textField.setBounds(195, 76, 110, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDay.setBounds(96, 103, 75, 14);
		contentPane.add(lblDay);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY "}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(195, 101, 110, 20);
		contentPane.add(comboBox);
		
		btnLogin = new JButton("Log-in");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setBounds(151, 162, 133, 45);
		contentPane.add(btnLogin);
	}
}
