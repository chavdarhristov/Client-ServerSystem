package server.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Time;
import java.util.ArrayList;

import data.BusStopScheduleRow;
import data.ScheduleRow;
import server.controler.ViewControler;

	/**
	** @author Krzysztof Majcher
	*/

public class ClientComunication implements Runnable{

	private Socket connection;
	private DatabaseCommunication communication;
	
	public ClientComunication(Socket connection, DatabaseCommunication communication) {
		this.connection = connection;
		this.communication = new DatabaseCommunication();
	}
	
	private void busClient(ObjectInputStream in, ObjectOutputStream out) throws ClassNotFoundException, IOException{
		String bus = (String) in.readObject();
		String day = (String) in.readObject();
		ViewControler.addLog("Bus: " + bus +" connected and asked for schedule for: " + day);
		System.out.println(bus);
		System.out.println(day);
		ArrayList<String> busStops = new ArrayList<>();
		ArrayList<Time> time = new ArrayList<>();
		communication.getSchedule(bus, day, busStops, time);
		out.writeObject(busStops);
		out.flush();
		out.writeObject(time);
		out.flush();
		while(connection.isConnected()){
			ScheduleRow row = (ScheduleRow) in.readObject();
			communication.CreateDalay(row);
			ViewControler.addLog("Bus: " + row.getBus() +" arrived at bus stop: " + row.getBusStop() + " with delay: " + row.getDalay() + " second");
			System.out.println(row.getBus());
			System.out.println(row.getDalay());
		}
	}
	
	private void monitorClient(ObjectInputStream in, ObjectOutputStream out) throws ClassNotFoundException, IOException{
		String busStop = (String) in.readObject();
		String day = (String) in.readObject();
		ArrayList<BusStopScheduleRow> row = new ArrayList<>();
		communication.getPossibleDelay(busStop, day, row);
		out.writeObject(row);
		out.flush();
	}

	public void run() {
		ViewControler.addLog("Client connected");
		try {
			ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
			String identity = (String) in.readObject();
			System.out.println(identity);
			if(identity.equals("Hi I'm Bus-client")){
				busClient(in, out);
			}
			else if (identity.equals("Hi I'm Monitor-client")){
				monitorClient(in, out);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
