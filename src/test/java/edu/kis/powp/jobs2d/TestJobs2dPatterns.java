package edu.kis.powp.jobs2d;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.events.FigureDrawingStrategy;
import edu.kis.powp.jobs2d.drivers.adapter.Job2dDrawingDriverAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import edu.kis.powp.jobs2d.patterns.CircleFactory;
import edu.kis.powp.jobs2d.patterns.RectangleFactory;
import edu.kis.powp.jobs2d.patterns.TriangleFactory;

public class TestJobs2dPatterns {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final static FigureDrawingStrategy joeFigure1 = FiguresJoe::figureScript1;
    private final static FigureDrawingStrategy joeFigure2 = FiguresJoe::figureScript2;
    private final static FigureDrawingStrategy janeFigure1 = FiguresJane::figureScript;
    private final static FigureDrawingStrategy rectangleFigure = (driver) -> new RectangleFactory(
            200, 100)
            .create()
            .execute(driver);
    private final static FigureDrawingStrategy circleFigure = (driver) -> new CircleFactory(
            150)
            .create()
            .execute(driver);
    private final static FigureDrawingStrategy triangleFigure = (driver) -> new TriangleFactory(
            150, 300)
            .create()
            .execute(driver);

    /**
     * Setup test concerning preset figures in context.
     *
     * @param application Application context.
     */
    private static void setupPresetTests(Application application) {
        SelectTestFigureOptionListener listener1 = new SelectTestFigureOptionListener(
                DriverFeature.getDriverManager(),
                joeFigure1);
        SelectTestFigureOptionListener listener2 = new SelectTestFigureOptionListener(
                DriverFeature.getDriverManager(),
                joeFigure2);
        SelectTestFigureOptionListener listener = new SelectTestFigureOptionListener(
                DriverFeature.getDriverManager(),
                janeFigure1
        );
        SelectTestFigureOptionListener rectangleListener = new SelectTestFigureOptionListener(
                DriverFeature.getDriverManager(),
                rectangleFigure
        );
        SelectTestFigureOptionListener circleListener = new SelectTestFigureOptionListener(
                DriverFeature.getDriverManager(),
                circleFigure
        );
        SelectTestFigureOptionListener triangleListener = new SelectTestFigureOptionListener(
                DriverFeature.getDriverManager(),
                triangleFigure
        );

        application.addTest("Figure Joe 1", listener1);
        application.addTest("Figure Joe 2", listener2);
        application.addTest("Figure Jane", listener);
        application.addTest("Rectangle", rectangleListener);
        application.addTest("Circle", circleListener);
        application.addTest("Triangle", triangleListener);
    }


    /**
     * Setup driver manager, and set default driver for application.
     *
     */
    private static void setupDrivers() {
        Job2dDriver loggerDriver = new LoggerDriver();
        DriverFeature.addDriver("Logger Driver", loggerDriver);
        DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);
        DrawPanelController controller = DrawerFeature.getDrawerController();

        Job2dDriver testDriver = new Job2dDrawingDriverAdapter(controller);
        Job2dDriver specialLineDriver1 = new Job2dDrawingDriverAdapter(Color.BLUE, controller);
        Job2dDriver specialLineDriver2 = new Job2dDrawingDriverAdapter(Color.MAGENTA,0.8f, controller);
        Job2dDriver specialLineDriver3 = new Job2dDrawingDriverAdapter(Color.GREEN, 1.5f, true, controller);

        DriverFeature.addDriver("Basic Line", testDriver);
        DriverFeature.addDriver("Color Line", specialLineDriver1);
        DriverFeature.addDriver("Color & Thickness Line ", specialLineDriver2);
        DriverFeature.addDriver("Color, Thickness, Dotted Line", specialLineDriver3);

        DriverFeature.updateDriverInfo();
    }

    /**
     * Auxiliary routines to enable using Buggy Simulator.
     *
     * @param application Application context.
     */
    private static void setupDefaultDrawerVisibilityManagement(Application application) {
        DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
        boolean initVisible = false;
        application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
                new SelectChangeVisibleOptionListener(defaultDrawerWindow), initVisible);
        defaultDrawerWindow.setVisible(initVisible);
    }

    /**
     * Setup menu for adjusting logging settings.
     *
     * @param application Application context.
     */
    private static void setupLogger(Application application) {
        application.addComponentMenu(Logger.class, "Logger", 0);
        application.addComponentMenuElement(Logger.class, "Clear log",
                (ActionEvent e) -> application.flushLoggerOutput());
        application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
        application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
        application.addComponentMenuElement(Logger.class, "Warning level",
                (ActionEvent e) -> logger.setLevel(Level.WARNING));
        application.addComponentMenuElement(Logger.class, "Severe level",
                (ActionEvent e) -> logger.setLevel(Level.SEVERE));
        application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application app = new Application("2d jobs Visio");
            DrawerFeature.setupDrawerPlugin(app);
            setupDefaultDrawerVisibilityManagement(app);

            DriverFeature.setupDriverPlugin(app);
            setupDrivers();
            setupPresetTests(app);
            setupLogger(app);

            app.setVisibility(true);
        });
    }

}
