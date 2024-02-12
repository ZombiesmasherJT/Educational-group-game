import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FXskel extends JFrame {

    public void initialize() {
        setTitle("FXskel");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set background color to grey
        getContentPane().setBackground(Color.GRAY);

        // Create a button
        JButton myButton = new JButton("Click me");
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button Clicked!");
            }
        });

        // Set layout manager (you can choose a different layout if needed)
        setLayout(new FlowLayout());

        // Add the button to the JFrame
        add(myButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FXskel fxskel = new FXskel();
            fxskel.initialize();
        });
    }
}


