package busStopClient.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import busStopClient.model.BusStop;
import busStopClient.view.TablePanel;
import busStopClient.view.monitorClientMainFrame;

	/**
	** @author Krzysztof Majcher
	*/

public class ViewControler {

	private monitorClientMainFrame clientMainFrame;
	private TablePanel tablePanel;
	private ActionListener listiner;

	public ViewControler() {
		clientMainFrame = new monitorClientMainFrame();
		tablePanel = new TablePanel();
		createActionListener();
		addActionListener();
		clientMainFrame.setVisible(true);
	}

	private void createActionListener() {
		listiner = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(clientMainFrame.getButton())) {
					String busStopN = clientMainFrame.getTextField().getText();
					String day = clientMainFrame.getComboBox().getSelectedItem().toString();
					tablePanel.getLblBusStop().setText(busStopN);
					clientMainFrame.setContentPane(tablePanel.getContentPane());
					clientMainFrame.pack();
					clientMainFrame.setSize(450, 300);
					Thread ref = new Thread(new Refresher(tablePanel.getTable(), busStopN, day));
					ref.start();
				}
			}
		};
	}
	
	private void addActionListener(){
		clientMainFrame.getButton().addActionListener(listiner);
	}
}
