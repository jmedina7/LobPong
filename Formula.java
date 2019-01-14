
public class Formula {
	    
		// Initialize
		private Game engine;
	    private int signX = 1;
	    private int signY = 1;
	    private int angle = 55;
	    private double velocity = 3;

	    Formula(Game engine) {
	        this.engine = engine;
	    }

	    // Parabolic equations for projectile motion
	    int getXPosition(int x) {
	        return x + signX * (int) Math.round(velocity * Math.cos(Math.toRadians(angle)));
	    }
	    int getYPosition(int y) {
	        return y - signY * (int) Math.round(velocity * Math.sin(Math.toRadians(angle)));
	    }

	    // Check for collision
	    void checkCollision(int currentX, int currentY, int canvasWidth, int canvasHeight, int diameter, Obstacles[] obs) {
	        // Ball collides with left boundary
	        if (currentX <= 0) {
	            bounce(true);
	        }

	        // Ball collides with right boundary
	        if (currentX >= canvasWidth - diameter) {
	            bounce(true);
	        }

	        // Ball collides with top boundary
	        if (currentY <= 0) {
	            bounce(false);
	        }

	        // Ball collides with paddle/misses paddle
	        if (currentY >= canvasHeight - 25 - diameter) {
	            if (engine.isAtPaddlePosition(currentX)) {
	                bounce(false);
	                engine.addPoints();
	                velocity += 0.3;
	            } else {
	                engine.loseLife();
	            }
	        }

	        //bounces off right and left side of obstacle
	        if(Obstacles.isColliding(currentX, currentY, diameter)) {
	        	bounce(true);
	        }
	    }

	    // Bounce off a surface 
	    private void bounce(boolean vertical) {
	        if (vertical) {
	            this.signX *= -1;
	        } else {
	            this.signY *= -1;
	        }
	    }
	}

