// FXskel.java

import javax.swing.*;
import java.awt.*;

public class FXskel extends JFrame {

    public FXskel() {
        initialize();
    }

    public void initialize() {
        setTitle("FXskel");
        setSize(500, 600);
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



