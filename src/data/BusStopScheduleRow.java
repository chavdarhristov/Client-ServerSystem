package data;

import java.io.Serializable;
import java.sql.Time;

	/**
	** @author Krzysztof Majcher
	*/

public class BusStopScheduleRow implements Serializable{

	private String bus;
	private Time time;
	private int possibleDelay;
	
	public BusStopScheduleRow(String bus, Time time, int possibleDelay) {
		this.bus = bus;
		this.time = time;
		this.possibleDelay = possibleDelay;
	}

	public String getBus() {
		return bus;
	}

	public Time getTime() {
		return time;
	}

	public int getPossibleDelay() {
		return possibleDelay;
	}
}
