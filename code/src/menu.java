// menu.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JPanel {
    private FXskel parentFrame;

    public menu(FXskel parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.GRAY);

        addMenuButton("Play", e -> System.out.println("Play clicked"));
        addMenuButton("My Character", e -> System.out.println("My Character clicked"));
        addMenuButton("Achievements", e -> System.out.println("Achievements clicked"));
        // Modify the action listener for the "Help" button
        addMenuButton("Help", e -> parentFrame.showHelpContent());
        addMenuButton("Credits", e -> System.out.println("Credits clicked"));
        addMenuButton("Quit", e -> System.exit(0));
    }

    private void addMenuButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setBackground(Color.RED);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(actionListener);
        add(button);
    }
}

