package fr.ldnr.herbert.calculette;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
class CalcScreen extends JLabel {

    public CalcScreen(String text) {
        super(text, JLabel.TRAILING);
        setUp();
    }

    private void setUp() {
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(8, 3, 3, 8))
        );
    }

}
