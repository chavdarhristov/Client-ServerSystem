package server.controler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import server.model.ClientControler;
import server.view.ServerMainFrame;

	/**
	** @author Krzysztof Majcher
	*/

public class ViewControler {
	
	private static ServerMainFrame mainFrame = new ServerMainFrame();
	private Thread clientControlerThread;
	private ClientControler clientControler;
	private ActionListener listener;
	
	public ViewControler(){
		createActionListener();
		addActionListener();
		mainFrame.setVisible(true);
	}
	
	public static void addLog(String log){
		mainFrame.getTxtpnDasdsd().setText(mainFrame.getTxtpnDasdsd().getText() + log + "\n");
	}
	
	public void createActionListener(){
		listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(mainFrame.getBtnStart()) && mainFrame.getBtnStart().getText().equals("Start")){
					clientControler = new ClientControler();
					clientControlerThread = new Thread(clientControler);
					clientControlerThread.start();
					mainFrame.getLblStatus().setText("Status: Active");
					mainFrame.getLblStatus().setForeground(Color.GREEN);
					mainFrame.getBtnStart().setText("Stop");
				}
				else if(e.getSource().equals(mainFrame.getBtnStart()) && mainFrame.getBtnStart().getText().equals("Stop")){
					clientControler.kill();
					clientControler = null;
					mainFrame.getLblStatus().setText("Status: Disactivate");
					mainFrame.getLblStatus().setForeground(Color.RED);
					mainFrame.getBtnStart().setText("Start");
				}
			}
		};
	}
	
	public void addActionListener(){
		mainFrame.getBtnStart().addActionListener(listener);
	}
}
