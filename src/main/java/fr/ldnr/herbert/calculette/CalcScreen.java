package fr.ldnr.herbert.calculette;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
class CalcScreen extends JLabel {

    private Font font;

    public CalcScreen(String text, Font font) {
        super(text, JLabel.TRAILING);
        this.font = font;
        setUp();
    }

    private void setUp() {
        setFont(font);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(8, 3, 3, 8))
        );
    }

}
