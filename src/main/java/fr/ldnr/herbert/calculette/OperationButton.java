package fr.ldnr.herbert.calculette;

import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
class OperationButton extends JButton {

    public OperationButton(String text) {
        super(text);
        setUp();
    }

    private void setUp() {
        setBackground(Color.WHITE);
    }

}
