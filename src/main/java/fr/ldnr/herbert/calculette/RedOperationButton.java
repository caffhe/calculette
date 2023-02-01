package fr.ldnr.herbert.calculette;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class RedOperationButton extends OperationButton {

    public RedOperationButton(String operation, Font font) {
        super(operation, font);
        setUp();
    }

    private void setUp() {
        setBackground(Color.red);
    }
}
