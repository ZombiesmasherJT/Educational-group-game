// HelpPanel.java

import javax.swing.*;
import java.awt.*;

public class HelpPanel extends JPanel {
    public HelpPanel() {
        setBackground(Color.GRAY); // Set the background color to match your app theme
        setLayout(new BorderLayout());

        JTextArea helpText = new JTextArea("jordan what infomation do we need to put");
        helpText.setWrapStyleWord(true);
        helpText.setLineWrap(true);
        helpText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(helpText);
        add(scrollPane, BorderLayout.CENTER);
    }
}
