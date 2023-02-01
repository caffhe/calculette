package fr.ldnr.herbert.calculette;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Herbert Caffarel
 */
@SuppressWarnings("serial")
public class MyCalc extends JFrame {

    private CalcScreen screen;
    private DigitsPanel digits;
    private OpPanel op;

    public MyCalc() {
        this("Ma calculette");
    }

    public MyCalc(String title) throws HeadlessException {
        super(title);
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
        setLayout(new BorderLayout(10, 10));

        digits = new DigitsPanel();
        op = new OpPanel();
        screen = new CalcScreen("0");
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
