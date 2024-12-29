package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

import java.awt.*;

/**
 * driver adapter to drawer with several bugs.
 */
public class Job2dDriverAdapter extends DrawPanelController implements Job2dDriver {
    private int startX = 0, startY = 0;
    ILine line;

    public Job2dDriverAdapter() {
        super();
        this.line = LineFactory.getBasicLine();
    }

    public Job2dDriverAdapter(Color color, float thickness, boolean ifDotted) {
        super();
        this.line = SpecialLineFactory.getSpecialLine(color, thickness, ifDotted);
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = this.line;
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        this.setPosition(x, y);

        DrawPanelController drawer = DrawerFeature.getDrawerController();
        drawer.drawLine(line);
    }

    @Override
    public String toString() {
        return "Drawer Adapter";
    }
}
