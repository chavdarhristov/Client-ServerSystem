package server.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollPane;

	/**
	** @author Krzysztof Majcher
	*/

public class ServerMainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblStatus;
	private JButton btnStart;
	private JTextPane txtpnDasdsd;
	
	
	
	public JPanel getContentPane() {
		return contentPane;
	}



	public JLabel getLblStatus() {
		return lblStatus;
	}



	public JButton getBtnStart() {
		return btnStart;
	}



	public JTextPane getTxtpnDasdsd() {
		return txtpnDasdsd;
	}



	public ServerMainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStatus = new JLabel("Status: Disactivate");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		lblStatus.setForeground(Color.RED);
		lblStatus.setBounds(10, 11, 414, 19);
		contentPane.add(lblStatus);
		
		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnStart.setBounds(174, 219, 108, 41);
		contentPane.add(btnStart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 424, 162);
		contentPane.add(scrollPane);
		
		txtpnDasdsd = new JTextPane();
		txtpnDasdsd.setEditable(false);
		scrollPane.setViewportView(txtpnDasdsd);
	}
}
