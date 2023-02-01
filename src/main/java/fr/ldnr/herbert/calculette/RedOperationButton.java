package fr.ldnr.herbert.calculette;

import java.awt.Color;

@SuppressWarnings("serial")
public class RedOperationButton extends OperationButton {

    public RedOperationButton(String operation) {
        super(operation);
        setUp();
    }

    private void setUp() {
        setBackground(Color.red);
    }
}
