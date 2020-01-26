package data;

import java.io.Serializable;
import java.sql.Date;
import java.util.GregorianCalendar;

	/**
	** @author Krzysztof Majcher
	*/

public class ScheduleRow implements Serializable{

	private String bus;
	private GregorianCalendar date;
	private int dalay;
	private String busStop;
	
	
	public ScheduleRow(String bus, String busStop , int dalay, GregorianCalendar date) {
		this.bus = bus;
		this.date = date;
		this.dalay = dalay;
		this.busStop = busStop;
	}


	public String getBus() {
		return bus;
	}


	public GregorianCalendar getDate() {
		return date;
	}


	public int getDalay() {
		return dalay;
	}


	public String getBusStop() {
		return busStop;
	}
	
}
