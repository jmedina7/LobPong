import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	 private static final int speed = 50;
	    private static final int steps = 10;
	    private static final int stepSize = speed / steps;
	    private static final int height = 10;
	    private static final int startingWidth = 140;
	    private static final double difficulty = 0.75;
	    private int startingX;
	    private int width;
	    private int y;
	    private int x;
	    private int bufferedX;
	    Color Orange = new Color(255, 160, 122);

	    // Constructor
	    Paddle(int x, int y) {
	        this.x = bufferedX = startingX = x;
	        this.y = y;
	        width = startingWidth;
	    }

	    // Update the paddle's position based on it's direction
	    void updatePosition(boolean direction, int canvasWidth) {
	    		// New x position (horizontal position) of the paddle based on which way the user chooses to move it
	        int newX = x + (speed * (direction ? 1 : -1));
	        updatePosition(newX, canvasWidth);
	    }

	    // Reposition the paddle
	    void updatePosition(int newX, int canvasWidth) {
	        // Constrain to within frame
	        x = Math.max(width / 2, Math.min(canvasWidth - (width / 2), newX));
	    }

	    // Reset the paddle back at the center
	    void resetPosition() {
	        x = bufferedX = startingX;
	    }

	    // Check for collision
	    boolean isColliding(int x) {
	        return (x >= this.x - (width / 2) && x <= this.x + (width / 2));
	    }

	    // Draw paddle onto the canvas
	    void draw(Graphics g) {
	        g.setColor(Orange);
	        g.fillRect(bufferedX - (width / 2), y, width, height);

	        // Animate the paddle based on its x position
	        if (bufferedX < x - stepSize) {
	            bufferedX += stepSize;
	        } else if (bufferedX > x + stepSize) {
	            bufferedX -= stepSize;
	        }
	    }
}
