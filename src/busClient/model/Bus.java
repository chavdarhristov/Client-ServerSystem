package busClient.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import data.ScheduleRow;


/**
** @author Krzysztof Majcher
*/

public class Bus {

	private ArrayList<String> busStops;
	private ArrayList<Time> timeStops;
	private ServerCommunication serverCommunication;
	private String bus;
	private String day;
	private int busStopNumber;

	public Bus() {
		this.busStops = new ArrayList<>();
		this.timeStops = new ArrayList<>();
		serverCommunication = new ServerCommunication();
	}

	public void login(String bus, String day){
		this.bus = bus;
		this.day = day;
		serverCommunication.login(bus, day, busStops, timeStops);
	}

	public void createRow(){
		GregorianCalendar now = new GregorianCalendar();
		ScheduleRow row = new ScheduleRow(bus,
				busStops.get(busStopNumber),
				clculateDalay(timeStops.get(busStopNumber),now),
				now);
		busStopNumber++;
		serverCommunication.sendRow(row);
	}
	
	private int clculateDalay(Time to , GregorianCalendar from){
		int toInSec = to.getHours() * 3600 + to.getMinutes() * 60 + to.getSeconds();
		int formInSec = from.get(from.HOUR_OF_DAY) * 3600 + from.get(from.MINUTE) * 60 + from.get(from.SECOND);
		return toInSec - formInSec;
	}
	
	public boolean isLast(){
		return busStopNumber == busStops.size();
	}
	
	public boolean isMoreThenLast(){
		return busStopNumber > busStops.size();
	}

	public String getBusStops() {
		return busStops.get(busStopNumber);
	}

	public String getTimeStops() {
		return timeStops.get(busStopNumber).toString();
	}	
}
