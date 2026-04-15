package game;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;

public class Entity {

    // instance variables 
    private double xPosition;
    private double yPosition;
    private double size;
    private Color color;

    // constructor
    public Entity(double x, double y, double size, Color color) {
        this.xPosition = x;
        this.yPosition = y;
        this.size = size;
        this.color = color;
    }

    // methods
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(xPosition, yPosition, size);
    }

    public double getSize() {
        return size;
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }

    public boolean collidesWith(Entity e) {
        double distance = Math.sqrt(
            Math.pow(xPosition - e.getXPosition(), 2) +
            Math.pow(yPosition - e.getYPosition(), 2)
        );

        return distance <= size + e.getSize();
    }

    public void setXPosition(double x) {
        this.xPosition = x;
    }

    public void setYPosition(double y) {
        this.yPosition = y;
    }
    
}