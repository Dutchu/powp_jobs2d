package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class SelectDriverMenuOptionListener implements ActionListener {
	private final DriverManager driverManager;
	private final Job2dDriver driver;

	public SelectDriverMenuOptionListener(Job2dDriver driver, DriverManager driverManager) {
		this.driverManager = driverManager;
		this.driver = driver;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		driverManager.setCurrentDriver(driver);
		DriverFeature.updateDriverInfo();
	}
}