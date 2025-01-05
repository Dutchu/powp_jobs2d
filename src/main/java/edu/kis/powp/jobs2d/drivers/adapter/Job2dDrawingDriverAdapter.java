package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.decorator.ILineDecorator;

import java.awt.*;

/**
 * driver adapter to drawer with several bugs.
 */
public class Job2dDrawingDriverAdapter implements Job2dDriver {
    private int startX = 0, startY = 0;
    private final Color color;
    private final float thickness;
    private final boolean isDotted;
    private final DrawPanelController controller;
    private static final ILine basicLine = LineFactory.getBasicLine();

    public Job2dDrawingDriverAdapter(DrawPanelController controller) {
        this.controller = controller;
        this.color = basicLine.getColor();
        this.thickness = basicLine.getThickness();
        this.isDotted = basicLine.isDotted();
    }
    public Job2dDrawingDriverAdapter(Color color, DrawPanelController controller) {
        this.controller = controller;
        this.color = color;
        this.thickness = basicLine.getThickness();
        this.isDotted = basicLine.isDotted();
    }
    public Job2dDrawingDriverAdapter(Color color, float thickness, DrawPanelController controller) {
        this.controller = controller;
        this.color = color;
        this.thickness = thickness;
        this.isDotted = basicLine.isDotted();
    }
    public Job2dDrawingDriverAdapter(Color color, float thickness, boolean isDotted, DrawPanelController controller) {
        this.controller = controller;
        this.color = color;
        this.thickness = thickness;
        this.isDotted = isDotted;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = new ILineDecorator.Builder(basicLine)
                .withColor(color)
                .withThickness(thickness)
                .withDotted(isDotted)
                .build();

        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        controller.drawLine(line);
        this.setPosition(x, y);
    }

    @Override
    public String toString() {
        return "Drawer Adapter";
    }
}
