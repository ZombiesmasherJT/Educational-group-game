
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class menu extends JPanel {
    public menu() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.GRAY);
        addMenuButton("Play", e -> System.out.println("Play clicked"));
        addMenuButton("My Character", e -> System.out.println("My Character clicked"));
        addMenuButton("Achievements", e -> System.out.println("Achievements clicked"));
        addMenuButton("Help", e -> System.out.println("Help clicked"));
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