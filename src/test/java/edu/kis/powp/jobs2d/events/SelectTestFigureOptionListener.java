package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.FigureDrawingStrategy;
import edu.kis.powp.jobs2d.drivers.adapter.ExtendedAbstractDriver;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private FigureDrawingStrategy drawingStrategy;

	public SelectTestFigureOptionListener(DriverManager driverManager, FigureDrawingStrategy drawingStrategy) {
		this.driverManager = driverManager;
		this.drawingStrategy = drawingStrategy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ExtendedAbstractDriver driver = new ExtendedAbstractDriver(driverManager.getCurrentDriver());
		drawingStrategy.drawFigure(driver);
	}
}
