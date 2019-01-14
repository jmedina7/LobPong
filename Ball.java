import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private static final int diameter = 20;

    //Initialize
    private int startingY;
    private int startingX;
    private int x;
    private int y;
    Color pastelPurple = new Color(132, 112, 255);

    // Constructor
    Ball(int x, int y) {
        startingX = x;
        this.x = startingX;
        startingY = y;
        this.y = startingY;
    }

    // Moving the ball using its computed x and y components
    void updatePosition(Formula physics, int canvasWidth, int canvasHeight) {
    		// Remain within horizontal boundary
        x = Math.max(0, Math.min(canvasWidth - diameter, physics.getXPosition(x)));
        // Remain within vertical boundary
        y = Math.max(0, physics.getYPosition(y));

        physics.checkCollision(x, y, canvasWidth, canvasHeight, diameter, null);
    }

    // Re-center the ball at the start
    void resetPosition() {
        x = startingX;
        y = startingY;
    }

    // Draw the ball onto canvas
    void draw(Graphics g) {
        g.setColor(pastelPurple);
        g.fillOval(x, y, diameter, diameter);
    }
}
