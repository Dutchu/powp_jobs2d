package edu.kis.powp.jobs2d.patterns;

import edu.kis.powp.jobs2d.drivers.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.command.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.command.SetPositionCommand;

public class TriangleFactory implements ShapesFactory {

    private final int height;
    private final int base;
    private final static int initX = 0, initY = 0;

    public TriangleFactory(int height, int base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public ComplexCommand create() {
        int baseX = initX, baseY = initY - 2 * height / 3;
        int x1 = -base / 2, y1 = -2 * height / 3;
        int x2 = 0, y2 = height / 3;
        int x3 = base / 2, y3 = -2 * height / 3;

        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(baseX, baseY));
        command.addCommand(new OperateToCommand(x1, y1));
        command.addCommand(new OperateToCommand(x2, y2));
        command.addCommand(new OperateToCommand(x3, y3));
        command.addCommand(new OperateToCommand(baseX, baseY));
        return command;
    }
}
