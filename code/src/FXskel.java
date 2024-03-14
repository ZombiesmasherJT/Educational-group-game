import javax.swing.*;
import java.awt.*;

public class FXskel extends JFrame {
    public void initialize() {
        setTitle("FXskel");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Replace the button with the Menu panel
        setContentPane(new menu());

        setVisible(true);
    }
}



