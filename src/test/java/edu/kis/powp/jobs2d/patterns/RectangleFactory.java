package edu.kis.powp.jobs2d.patterns;

import edu.kis.powp.jobs2d.drivers.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.command.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.command.SetPositionCommand;

public class RectangleFactory implements ShapesFactory {
    final int width, height;

    public RectangleFactory(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public ComplexCommand  create() {
        ComplexCommand rectangle = new ComplexCommand();
        rectangle.addCommand(new SetPositionCommand(0, 0));
        rectangle.addCommand(new OperateToCommand(width, 0));
        rectangle.addCommand(new OperateToCommand(width, height));
        rectangle.addCommand(new OperateToCommand(0, height));
        rectangle.addCommand(new OperateToCommand(0, 0));
        return rectangle;
    }
}
