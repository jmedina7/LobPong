import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

public class Obstacles {
    public static int width = 50;
    public static int height = 50;
    Random rand = new Random();
    public static int x;
	public static int y;

    Obstacles() {
    	
        this.x = rand.nextInt(Game.panel.getWidth()-50)+1;
        this.y = rand.nextInt(Game.panel.getHeight()- 190)+1;
        this.width = width;
        this.height = height;
    }

    // Check if the ball is colliding with this
    public static boolean isColliding(int ballX, int ballY, int diameter) {
        // if the ball's coordinates are within the bounds, it should collide
        return (ballX <= x + width // right side
                && ballX + diameter >= x // left side
                && ballY <= y + height // bottom
                && ballY + diameter >= y); // top
    }
    
    void draw(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(x, y, width, height);
    }
    
    //resets x and y after each round
    void resetPosition() {
        x = rand.nextInt(Game.panel.getWidth()-50)+1;
        y = rand.nextInt(Game.panel.getHeight()- 190)+1;
    }
}