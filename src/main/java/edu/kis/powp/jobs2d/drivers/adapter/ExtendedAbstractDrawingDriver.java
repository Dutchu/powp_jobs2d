package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;

public class ExtendedAbstractDrawingDriver extends AbstractDriver implements Job2dDriver {

    private final Job2dDriver adapter;

    public ExtendedAbstractDrawingDriver(
            Job2dDriver adapter) {
        super(0, 0);
        this.adapter = adapter;
    }

    @Override
    public void operateTo(int x, int y) {
            adapter.operateTo(x, y);
    }

    public void setPositionTo(int x, int y) {
            adapter.setPosition(x, y);
    }
}
