import java.awt.*;
import java.util.Random;

public class Controls {
	
	// Initialize
	private static final int startTime = 1000; 
	private static final int scoreTimeBonus = 5;
	private static final int scoreBonus = 100;
	private static final double difficulty = 1.1;
	private double multiplier;
	private int timeBonusCountdown;
	private int score;
	private int round;
	private int remainingTime;
	private int lives;
	public boolean playing;
	Color pastelRed = new Color(240, 128, 128);

	Controls() {
        playing = false;
        multiplier = 1.0;
        timeBonusCountdown = 0;
        score = 0;
        round = 1;
        remainingTime = startTime;
        lives = 3;
    }

	// Move on to the next round
	public void nextRound(boolean getBonus) {
		round++;

		if (getBonus)
			awardBonus();

		resetTimer();
		Game.resetBallAndPaddle();
		Game.resetOb();
		Game.playing = false;
		countdown();
	}

	// Draw timer
	public void drawRound(Graphics g, int canvasWidth) {
		g.drawString("Round: " + round, canvasWidth - 80, 40);
	}

	// Countdown timer
	public void countdown() {
		if (playing) {
			remainingTime--;
			timeBonusCountdown++;

			// Countdown for each second
			if (timeBonusCountdown >= 100) {
				//awardTimeBonus();
				timeBonusCountdown = 0;
				// If you survive the full time, move on to the next round
			}
			if (remainingTime == 0) {
				nextRound(true);
				resetTimer();
			}
		}
	}

	// Reset timer method
	private void resetTimer() {
		multiplier *= difficulty;
		remainingTime = (int) Math.round(startTime * multiplier);
	}

	// Stop the game
	public void stopGame() {
		playing = false;
	}

	// Start the game
	public void startGame() {
		playing = true;
	}

	// Draw the timer
	void drawTimer(Graphics g, int canvasWidth) {
		String formattedTime = "" + (remainingTime / 100.0);
		g.drawString("Remaining Time: " + formattedTime, canvasWidth - 180, 20);
	}

	// Give the user bonus points
	private void awardBonus() {
		score += (int) Math.round(scoreBonus * Math.pow(difficulty, round - 1)); // Increases after each round
	}

	void hitBonus() {
		score += 5;
	}

	// Draw the timer
	void drawScore(Graphics g) {
		g.drawString("Score: " + score, 20, 20);
	}

	// Check if we have extra lives
	boolean hasLives() {
		return lives > 0;
	}

	// Decreases number of lives when player fails
	void loseLife() {
		lives--;
	}

	// Award extra life to user
	void gainLife() {
		lives++;
	}

	// Draw the dots for lives
	void drawLives(Graphics g) {
		for (int i = 1; i <= lives; i++) {
			g.setColor(pastelRed);
			g.fillOval(20 * i, 40, 10, 10);
		}
	}
}