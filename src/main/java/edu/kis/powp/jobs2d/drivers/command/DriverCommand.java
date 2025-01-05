package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.drivers.adapter.ExtendedAbstractDrawingDriver;

public interface DriverCommand {
    void execute(ExtendedAbstractDrawingDriver driver);
}
