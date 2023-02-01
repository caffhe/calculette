package fr.ldnr.herbert.calculette;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Herbert Caffarel
 */
@SuppressWarnings("serial")
public class MyCalc extends JFrame {

    private int fontSize;
    private Font font;
    private CalcScreen screen;
    private DigitsPanel digits;
    private OpPanel op;
    private ComputationEngine computer;

    public MyCalc() {
        this("Ma calculette", 12);
    }

    public MyCalc(int fontSize) {
        this("Ma calculette", fontSize);
    }

    public MyCalc(String title) throws HeadlessException {
        this(title, 12);
    }

    public MyCalc(String title, int fontSize) {
        super(title);
        this.fontSize = fontSize;
        this.computer = new ComputationEngine(this);
        setUpAndDisplay();
    }

    public CalcScreen getScreen() {
        return screen;
    }

    public DigitsPanel getDigits() {
        return digits;
    }

    public OpPanel getOp() {
        return op;
    }

    private void setUpAndDisplay() {
        font = new FontUIResource("Arial", Font.PLAIN, fontSize);

        setLayout(new BorderLayout(7, 7));

        digits = new DigitsPanel(font);
        digits.getDigits().forEach((digit) -> {
            digit.addActionListener(computer);
        });
        op = new OpPanel(font);
        op.getOps().forEach((op) -> {
            op.addActionListener(computer);
        });
        screen = new CalcScreen("0", font);

        // Ajout des panneaux de contenu
        add(screen, BorderLayout.NORTH);
        add(digits, BorderLayout.WEST);
        add(op, BorderLayout.EAST);
        // Redimensionnement optimal
        pack();
        // Gestion de la fermeture
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Positionnement au centre de l'écran
        setLocationRelativeTo(null);
        // Affichage
        setVisible(true);
    }

}
