package server.model;

import java.util.GregorianCalendar;

import data.ScheduleRow;

public class DBTest {

	public static void main (String []args){
		DatabaseCommunication communication = new DatabaseCommunication();
		communication.CreateDalay(new ScheduleRow("bus1", "HIGH SCHOOL", 15, new GregorianCalendar()));
	}
}
