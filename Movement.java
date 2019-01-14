import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class Movement implements MouseMotionListener, KeyListener {
	
	// Initialize
    private Game engine;

    // Constructor
    Movement(Game engine) {
        this.engine = engine;
    }

    // Key Listener methods
    @Override
    public void keyTyped(KeyEvent e) {}

    // Move the paddle with the arrow keys
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                engine.startRound();
                break;
            case KeyEvent.VK_LEFT:
                engine.updatePaddleViaKey(false);
                break;
            case KeyEvent.VK_RIGHT:
                engine.updatePaddleViaKey(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    // Mouse Motion Listener Methods
    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        // Get the position of the mouse
        engine.updatePaddleViaMouse(e.getX());
    }
}