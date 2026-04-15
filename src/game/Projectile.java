package game;

import java.awt.Color;

public class Projectile extends Entity {

    private static final double SIZE = 0.01;
    private static final double SPEED = 0.01;
    private static final double MIN_Y = 0.0;
    private static final double MAX_Y = 1.0;

    public Projectile(double x, double y, Color color) {
        super(x, y, SIZE, color);
    }

    public void moveUp() {
        setYPosition(this.getYPosition() + SPEED);
    }

    public void moveDown() {
        setYPosition(this.getYPosition() - SPEED);
    }

    public boolean isOutOfBounds() {
        return getYPosition() > MAX_Y || getYPosition() < MIN_Y;
        }
    }
