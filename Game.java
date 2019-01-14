import javax.swing.Timer;
import java.awt.Graphics;
import java.util.Random;

class Game {
    public static Panel panel;
    private Controls manager;
    private Formula math;
    private Timer timerTwo;
    static boolean playing;
    private static Ball ball;
    private static Paddle paddle;
    private static Obstacles ob;

    Game() {
        // Game Managers
        panel = new Panel(this);
        manager = new Controls();
        math = new Formula(this);
    }

    // Start a game
    void startGame() {
        // Game Components
    	
        int middle = (int) Math.round(panel.getWidth() / 2.0);
        ball = new Ball(middle, panel.getHeight() - 100);
        paddle = new Paddle(middle, panel.getHeight() - 30);
        //details for obstacle
        ob = new Obstacles();
        playing = false;

        // Animation Timer (using lambda expression)
        timerTwo = new Timer(10, e -> {
            // If round is over, go to the next one.
                if (playing) {
                    manager.countdown();
                    ball.updatePosition(math, panel.getWidth(), panel.getHeight());
                }
            panel.repaint();
        });

        timerTwo.start();
    }

    Panel getPanel() {
        return panel;
    }

    // Check if ball is bouncing on paddle
    boolean isAtPaddlePosition(int x) {
        return paddle.isColliding(x);
    }

    // allow user to move the paddle either via left-right keys or mouse cursor
    void updatePaddleViaKey(boolean direction) {
        if (playing) {
            paddle.updatePosition(direction, panel.getWidth());
        }
    }
    void updatePaddleViaMouse(int x) {
        if (playing) {
            paddle.updatePosition(x, panel.getWidth());
        }
    }

    // Lose a life
    void loseLife() {
        manager.loseLife();

        if(manager.hasLives()) {
            resetBallAndPaddle();
        }

        manager.stopGame();
        playing = false;
    }

    void addPoints() {
        manager.hitBonus();
    }

    // Start round
    void startRound() {
        playing = true;
        manager.startGame();
    }

    // Reset positions for beginning of round
    public static void resetBallAndPaddle() {
        paddle.resetPosition();
        ball.resetPosition();
    }
    
    public static void resetOb() {
    	ob.resetPosition();
    }

    // Draw stuff
    void drawBall(Graphics g) {
        ball.draw(g);
    }
    void drawPaddle(Graphics g) {
        paddle.draw(g);
    }
    void drawObstacles(Graphics g) {
    	ob.draw(g);
    }

    // GUI
    void drawTimer(Graphics g) {
        manager.drawTimer(g, panel.getWidth());
    }
    void drawRound(Graphics g) {
        manager.drawRound(g, panel.getWidth());
    }
    void drawScore(Graphics g) {
        manager.drawScore(g);
    }
    void drawLives(Graphics g) {
        manager.drawLives(g);
    }
}