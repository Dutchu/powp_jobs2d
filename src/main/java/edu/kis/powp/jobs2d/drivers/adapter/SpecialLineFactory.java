package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.legacy.drawer.shape.line.BasicLine;
import edu.kis.legacy.drawer.shape.line.DottedLine;
import edu.kis.powp.jobs2d.drivers.adapter.SpecialLine;

import java.awt.*;

public class SpecialLineFactory extends LineFactory {
    public static ILine getSpecialLine(Color color, float thickness, boolean ifDotted) {
        return new SpecialLine(color, thickness, ifDotted);
    }
}
