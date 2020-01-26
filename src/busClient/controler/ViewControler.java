package busClient.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import busClient.model.Bus;
import busClient.view.ScheduleP;
import busClient.view.logIn;

	/**
	** @author Krzysztof Majcher
	*/

public class ViewControler {

	private logIn login;
	private ScheduleP scheduleP;
	private Bus bus;
	private ActionListener action;
	
	public ViewControler(){
		login = new logIn();
		scheduleP = new ScheduleP();
		bus = new Bus();
		actionListener();
		addListeners();
		login.setVisible(true);
	}
	
	private void actionListener(){
		action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == login.getBtnLogin()){
					bus.login(login.getTextField().getText(),
							(String) login.getComboBox().getSelectedItem());
					scheduleP.getLblNextBusStop_1().setText(bus.getBusStops());
					scheduleP.getLblScheduledTime_1().setText(bus.getTimeStops());
					login.setContentPane(scheduleP);
					login.pack();
					login.setSize(450, 300);
				}
				else if(e.getSource() == scheduleP.getBtnNewButton()){
					if(bus.isMoreThenLast()){
						
					}
					else{
						bus.createRow();
						if(bus.isLast()){
							scheduleP.getLblNextBusStop_1().setText("END OF SCHEDULE");
							scheduleP.getLblScheduledTime_1().setText("END OF SCHEDULE");
						}
						else{
							scheduleP.getLblNextBusStop_1().setText(bus.getBusStops());
							scheduleP.getLblScheduledTime_1().setText(bus.getTimeStops());
						}
					}
				}
			}
		};
	}
	
	private void addListeners(){
		login.getBtnLogin().addActionListener(action);
		scheduleP.getBtnNewButton().addActionListener(action);
	}
}
