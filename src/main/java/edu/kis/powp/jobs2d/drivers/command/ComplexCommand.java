package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.drivers.adapter.ExtendedAbstractDrawingDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {

    final List<DriverCommand> commandList = new ArrayList<>();

    public void addCommand(DriverCommand command) {
        commandList.add(command);
    }

    @Override
    public void execute(ExtendedAbstractDrawingDriver driver) {
        commandList.forEach(command -> command.execute(driver));
    }
}
