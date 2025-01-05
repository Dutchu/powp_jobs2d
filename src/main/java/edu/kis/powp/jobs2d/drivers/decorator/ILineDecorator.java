package edu.kis.powp.jobs2d.drivers.decorator;

import edu.kis.legacy.drawer.shape.ILine;

import java.awt.*;

public class ILineDecorator implements ILine {

    private final Color color;
    private final float thickness;
    private final boolean isDotted;
    private final ILine iLine;

    private ILineDecorator(Builder builder) {
        this.iLine = builder.iLine;
        this.color = builder.color;
        this.thickness = builder.thickness;
        this.isDotted = builder.isDotted;
    }

    public static class Builder {
        private final ILine iLine;
        private Color color = Color.BLACK;
        private float thickness = 1.0f;
        private boolean isDotted = false;

        public Builder(ILine iLine) {
            this.iLine = iLine;
        }

        public Builder withColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder withThickness(float thickness) {
            this.thickness = thickness;
            return this;
        }

        public Builder withDotted(boolean isDotted) {
            this.isDotted = isDotted;
            return this;
        }

        public ILineDecorator build() {
            return new ILineDecorator(this);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new ILineDecorator.Builder((ILine) this.iLine.clone())
                .withColor(new Color(this.color.getRGB()))
                .withThickness(this.thickness)
                .withDotted(this.isDotted)
                .build();
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public float getThickness() {
        return this.thickness;
    }

    @Override
    public boolean isDotted() {
        return this.isDotted;
    }

    @Override
    public int getStartCoordinateX() {
        return iLine.getStartCoordinateX();
    }

    @Override
    public int getEndCoordinateX() {
        return iLine.getEndCoordinateX();
    }

    @Override
    public int getStartCoordinateY() {
        return iLine.getStartCoordinateY();
    }

    @Override
    public int getEndCoordinateY() {
        return iLine.getEndCoordinateY();
    }

    @Override
    public void setStartCoordinates(int i, int j) {
        iLine.setStartCoordinates(i, j);
    }

    @Override
    public void setEndCoordinates(int i, int j) {
        iLine.setEndCoordinates(i, j);
    }
}
