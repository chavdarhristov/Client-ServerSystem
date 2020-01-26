package busStopClient.controler;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import busStopClient.model.BusStop;

public class Refresher implements Runnable{

	private JTable table;
	private BusStop busStop;
	private String busStopN;
	private String day;
	
	public Refresher(JTable table, String busStopN, String day) {
		this.table = table;
		this.busStop = new BusStop();
		this.busStopN = busStopN;
		this.day = day;
	}

	public void run() {
		while(true){
			table.setModel(new DefaultTableModel(busStop.getRows(busStopN, day),
					new String[] { "Bus", "Time", "Possible delay"}));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
}
