import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

public class Pong extends JFrame {
	// Initialize
    Game engine;
    Color pastelBlue = new Color(135, 206, 250);
    
    // Constructor that creates the frame
    private Pong() {
        setTitle("LOB PONG!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(pastelBlue);

        engine = new Game();
        add(engine.getPanel(), BorderLayout.CENTER);

        pack();

        engine.startGame();
    }

    public static void main(String[] args) {
        new Pong().setVisible(true);
    }
}