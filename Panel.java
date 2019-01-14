import javax.swing.JComponent;
import java.awt.*;

public class Panel extends JComponent{
    private Game engine;
    private Movement input;
	Color pastelGreen = new Color(152, 251, 152);

    Panel(Game engine) {
        this.engine = engine;
        this.input = new Movement(engine);
        addMouseMotionListener(input);
        addKeyListener(input);
        setFocusable(true);
        setPreferredSize(new Dimension(850, 500));

    }

    public void paintComponent(Graphics g) {
        // Scene Elements
        engine.drawBall(g);
        engine.drawPaddle(g);
        engine.drawObstacles(g);

        // GUI
        g.setColor(pastelGreen);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        engine.drawTimer(g);
        engine.drawRound(g);
        engine.drawScore(g);
        engine.drawLives(g);
    }
}