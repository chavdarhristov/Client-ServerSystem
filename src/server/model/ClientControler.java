package server.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import data.ScheduleRow;

	/**
	** @author Krzysztof Majcher
	*/

public class ClientControler implements Runnable {

	private boolean run;
	private final int PORT = 4444;
	private DatabaseCommunication communication;
	private ServerSocket welcom;
	
	public ClientControler(){
	}
	
	public void kill(){
		run = false;
		try {
			welcom.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		welcom = null;
	}
	
	public void run() {
		welcom = null;
		try {
			welcom = new ServerSocket(PORT);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		run = true;
		while (run) {
			try {
				Thread newConnection = new Thread(new ClientComunication(welcom.accept(), communication));
				newConnection.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
