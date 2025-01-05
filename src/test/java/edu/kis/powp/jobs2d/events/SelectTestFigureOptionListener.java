package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.ExtendedAbstractDrawingDriver;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final FigureDrawingStrategy drawingStrategy;

	public SelectTestFigureOptionListener(DriverManager driverManager, FigureDrawingStrategy drawingStrategy) {
		this.driverManager = driverManager;
		this.drawingStrategy = drawingStrategy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ExtendedAbstractDrawingDriver driver = new ExtendedAbstractDrawingDriver(driverManager.getCurrentDriver());
		drawingStrategy.drawFigure(driver);
	}
}
