package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.drivers.adapter.ExtendedAbstractDrawingDriver;

public class OperateToCommand implements  DriverCommand {
    final int x, y;

    public OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(ExtendedAbstractDrawingDriver driver) {
        driver.operateTo(this.x, this.y);
    }
}
