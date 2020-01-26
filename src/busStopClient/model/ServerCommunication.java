package busStopClient.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import data.BusStopScheduleRow;

	/**
	** @author Krzysztof Majcher
	*/

public class ServerCommunication {

	private Socket connection;
	private	ObjectOutputStream out;
	private ObjectInputStream in;

	public ServerCommunication(){
		try {
			connection = new Socket("localhost", 4444);
			out = new ObjectOutputStream(connection.getOutputStream());
			in = new ObjectInputStream(connection.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<BusStopScheduleRow> login(String busStop, String day){
		try {
			out.writeObject("Hi I'm Monitor-client");
			out.flush();
			out.writeObject(busStop);
			out.writeObject(day);
			out.flush();
			ArrayList<BusStopScheduleRow> row = (ArrayList<BusStopScheduleRow>) in.readObject();
			return row;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
