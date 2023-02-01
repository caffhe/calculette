package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
class OperationButton extends JButton {

    private final Font font;

    public OperationButton(String text, Font font) {
        super(text);
        this.font = font;
        setUp();
    }

    private void setUp() {
        setFont(font);
        setBackground(Color.WHITE);
    }

}
