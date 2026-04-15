package game;

import java.awt.Color;

public class Enemy extends Entity {

    private static final double MIN_X = 0.0;
    private static final double MAX_X = 1.0;
    private static final double MIN_Y = 0.15;
    private static final double MAX_Y = 1.0;
    private static final long FIRE_COOLDOWN = 1000;

     private double xSpeed;
    private double ySpeed;
    private long lastFired;


    public Enemy() {
        super(Math.random() * 0.9, Math.random() * 0.8 + MIN_Y, 0.03, Color.RED);
        xSpeed = Math.random() * 0.05;
        ySpeed = Math.random() * 0.05;
        lastFired = System.currentTimeMillis();
    }

    public void move() {
        bounceOffWall();
        setXPosition(this.getXPosition() + xSpeed);
        setYPosition(this.getYPosition() + ySpeed);
    }

    private void bounceOffWall() {
    if (getXPosition() < MIN_X || getXPosition() > MAX_X) {
        xSpeed = -xSpeed;
    }

    if (getYPosition() > MAX_Y || getYPosition() < MIN_Y) {
        ySpeed = -ySpeed;
    }
}

    public boolean isFiring() {
        long now = System.currentTimeMillis();
        if (now - lastFired > FIRE_COOLDOWN) {
    lastFired = now;
    return true;
}
return false;
        }
    }
