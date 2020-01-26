package busStopClient.model;

import java.sql.Time;
import java.util.ArrayList;

import data.BusStopScheduleRow;

	/**
	** @author Krzysztof Majcher
	*/

public class BusStop {

	private ServerCommunication communication;
	
	public BusStop(){
		communication = new ServerCommunication();
	}
	
	public Object[][] getRows(String busStop, String day){
		communication = new ServerCommunication();
		ArrayList<BusStopScheduleRow> rowsA = communication.login(busStop, day);
		Object[][] rows = new Object[rowsA.size()][3];
		for(int a = 0; a < rowsA.size(); a++){
			rows[a][0] = rowsA.get(a).getBus();
			rows[a][1] = rowsA.get(a).getTime().toString();
			rows[a][2] = delayToString(rowsA.get(a).getPossibleDelay());
		}
		return rows;
	}
	
	private String delayToString(int delay){
		if(delay == 0){
			return "00:00:00";
		}
		boolean minus = delay < 0;
		if(minus){
			delay *= -1;
		}
		Time time = new Time(delay * 1000);
		if(minus){
			return time.toString();
		}
		return "- " + time.toString();
	}
}
