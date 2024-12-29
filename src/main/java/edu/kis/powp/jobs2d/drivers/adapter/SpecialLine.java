package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.line.AbstractLine;

import java.awt.*;

public class SpecialLine extends AbstractLine {
    public SpecialLine(Color color, float thickness, boolean ifDotted) {
        this.color = color;
        this.thickness = thickness;
        this.dotted = ifDotted;
    }
}
