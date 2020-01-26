package busClient.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Time;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.print.attribute.IntegerSyntax;

import data.ScheduleRow;

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
	
	public void login(String bus, String day, ArrayList<String> busStops, ArrayList<Time> stopTime){
		try {
			out.writeObject("Hi I'm Bus-client");
			out.writeObject(bus);
			out.writeObject(day);
			out.flush();
			ArrayList<String> one = (ArrayList<String>) in.readObject();
			for (int a = 0; a < one.size(); a++){
				busStops.add(one.get(a));
			}
			ArrayList<Time> two = (ArrayList<Time>) in.readObject();
			for (int a = 0; a < two.size(); a++){
				stopTime.add(two.get(a));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendRow(ScheduleRow row){
		try {
			out.writeObject(row);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
