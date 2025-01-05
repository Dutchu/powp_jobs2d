package edu.kis.powp.jobs2d.patterns;

import edu.kis.powp.jobs2d.drivers.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.command.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.command.SetPositionCommand;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CircleFactory implements ShapesFactory {
    private final int radius;
    private final static int numberOfPoints = 360;
    private final static int initX = 0, initY = 0;

    public CircleFactory(int radius) {
        this.radius = radius;
    }

    @Override
    public ComplexCommand create() {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(initX + radius, initY));
        List<OperateToCommand> circlePoints = IntStream.range(0, numberOfPoints)
                .mapToDouble(Math::toRadians)
                .mapToObj(angle -> new OperateToCommand(
                        new Double(Math.round(radius * Math.cos(angle))).intValue(),
                        new Double(Math.round(radius * Math.sin(angle))).intValue()
                ))
                .collect(Collectors.toList());
        circlePoints.forEach(command::addCommand);
        return command;
    }
}
