package fr.ldnr.herbert.calculette;

import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
class DigitButton extends JButton {

    private final Font font;

    public DigitButton(String text, Font font) {
        super(text);
        this.font = font;
        setUp();
    }

    private void setUp() {
        setFont(font);
    }

}
