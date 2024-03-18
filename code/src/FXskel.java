import javax.swing.*;
import java.awt.*;

public class FXskel extends JFrame {

    public FXskel() {
        initialize();
    }

    public void initialize() {
        setTitle("FXskel");

        // Set fullscreen mode
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            setUndecorated(false); // Remove window decorations (e.g., title bar)
            device.setFullScreenWindow(this);
        } else {
            System.err.println("Fullscreen mode not supported");
            setSize(Toolkit.getDefaultToolkit().getScreenSize()); // Set to maximum screen size
            setLocationRelativeTo(null); // Center the window on the screen
        }

        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new menu(this));
        setVisible(true);
    }

    public void showHelpContent() {
        setContentPane(new HelpPanel());
        validate(); // Refresh the layout
        repaint(); // Repaint the frame to show the new content
    }
}


