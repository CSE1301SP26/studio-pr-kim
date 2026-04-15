package game;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    // constants (magic number 제거)
    private static final double MOVE_SPEED = 0.01;
    private static final long FIRE_COOLDOWN = 500;

    private long lastFired;

    public Player() {
        super(0.5, 0.05, 0.03, Color.BLACK);
        lastFired = System.currentTimeMillis();
    }

    public void move() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            setXPosition(getXPosition() - MOVE_SPEED);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            setXPosition(getXPosition() + MOVE_SPEED);
        }
    }

    public boolean isFiring() {
        long now = System.currentTimeMillis();

        boolean canFire = now - lastFired > FIRE_COOLDOWN;
        boolean spacePressed = StdDraw.isKeyPressed(KeyEvent.VK_SPACE);

        if (canFire && spacePressed) {
            lastFired = now;
            return true;
        }

        return false;
    }
}