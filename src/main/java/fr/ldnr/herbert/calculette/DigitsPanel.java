package fr.ldnr.herbert.calculette;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class DigitsPanel extends JPanel {

    private ArrayList<DigitButton> digits;
    private Font font;

    public DigitsPanel(Font font) {
        digits = new ArrayList<>(12);
        this.font = font;
        setUp();
    }

    private void setUp() {
        setFont(font);
        setLayout(new GridLayout(4, 0, 5, 5));
        String[] digitValues = {"7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0", ".", "="
        };
        for (String digit : digitValues) {
            // Création du bouton
            DigitButton db = new DigitButton(digit, font);
            // Ajout à la liste des boutons à exporter
            digits.add(db);
            // Ajout au panel
            add(db);
        }
    }

    public ArrayList<DigitButton> getDigits() {
        return digits;
    }

}
