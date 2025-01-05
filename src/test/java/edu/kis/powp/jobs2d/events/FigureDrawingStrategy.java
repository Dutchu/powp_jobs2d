package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.adapter.ExtendedAbstractDrawingDriver;

public interface FigureDrawingStrategy {
    void drawFigure(ExtendedAbstractDrawingDriver driver);
}
