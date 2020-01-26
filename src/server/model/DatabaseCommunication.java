package server.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import data.BusStopScheduleRow;
import data.ScheduleRow;

	/**
	** @author Krzysztof Majcher
	*/

public class DatabaseCommunication {
	
	private Connection connection;
	private java.sql.Statement statement;
	
	public DatabaseCommunication(){
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/busdata",
			        "busadmin", "busadmin1");
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CreateDalay(ScheduleRow row){
		String bus = row.getBus();
		String busstop = row.getBusStop();
		String delay = Integer.toString(row.getDalay());
		String date = row.getDate().get(GregorianCalendar.MONTH) + 1 + "/" 
		+ row.getDate().get(GregorianCalendar.DAY_OF_MONTH) + "/"
		+ row.getDate().get(GregorianCalendar.YEAR); 
		String sql = "INSERT INTO bus.delay (bus, busstop, delay, date) VALUES('" + 
				bus + "', '" + 
				busstop + "', '" + 
				delay + "', '" + 
				date + "')";
		System.out.println(sql);
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getSchedule(String bus , String day ,ArrayList<String> busStops, ArrayList<Time> time){
		String sql = "SELECT s.busstop , s.time FROM bus.schedule s WHERE s.bus = '" + bus + 
				"' AND s.dayoftheweek = '" + day +"' ORDER BY s.time";
		try {
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				busStops.add(result.getString("busstop"));
				time.add(result.getTime("time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getPossibleDelay(String busStop, String day, ArrayList<BusStopScheduleRow> row){
		String askForBuses = "SELECT s.bus, s.time FROM bus.schedule s " + 
				"WHERE s.busstop = '" + busStop + "'" 
				+ "AND s.dayoftheweek = '" + day + "'"
				+ " ORDER BY s.time";
		ArrayList<String> buses = new ArrayList<>();
		ArrayList<Time> times = new ArrayList<>();
		ArrayList<Integer> deays = new ArrayList<>();
		try {
			ResultSet busesR = statement.executeQuery(askForBuses);
			while(busesR.next()){
				buses.add(busesR.getString("bus"));
				times.add(busesR.getTime("time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int a = 0; a < buses.size(); a++){
			ArrayList<String> busStops = new ArrayList<>();
			String sql = "SELECT s.busstop FROM bus.schedule s WHERE s.bus = '" + buses.get(a) + "'";
			try {
				ResultSet schedule = statement.executeQuery(sql);
				while(schedule.next()){
					busStops.add(schedule.getString("busstop"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int b = 0; b < busStops.size(); b++){
				if(busStops.get(b).equals(busStop)){
					GregorianCalendar now = new GregorianCalendar();
					String date = now.get(GregorianCalendar.MONTH) + 1 + "/" +
							now.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
							now.get(GregorianCalendar.YEAR);
					int possibleDelay = 0;
					if(b - 1 >= 0){
						String askForDelay = "SELECT d.delay FROM bus.delay d WHERE d.bus = '" + buses.get(a) + "'" +
								"and d.busstop = '" + busStops.get(b - 1) + "'" +
								"and d.date = '" + date + "'";
						try {
							ResultSet delaySet = statement.executeQuery(askForDelay);
							while(delaySet.next()){
								possibleDelay = delaySet.getInt("delay");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					row.add(new BusStopScheduleRow(buses.get(a), times.get(a), possibleDelay));
				}
			}
		}
	}
}
