package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.drivers.adapter.ExtendedAbstractDrawingDriver;

public class SetPositionCommand implements DriverCommand {
    final int x, y;

    public SetPositionCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(ExtendedAbstractDrawingDriver driver) {
        driver.setPositionTo(this.x, this.y);
    }
}
