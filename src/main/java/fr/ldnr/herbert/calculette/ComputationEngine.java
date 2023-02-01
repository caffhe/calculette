package fr.ldnr.herbert.calculette;

import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.text.ParsePosition;
import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 *
 * @author Herbert Caffarel
 */
@SuppressWarnings("serial")
public class ComputationEngine extends AbstractAction {

    private final MyCalc calc;
    private char nextOperation;
    private double currentValue;
    private final NumberFormat formatter;
    private boolean newValue;

    public ComputationEngine(MyCalc calc) {
        this.calc = calc;
        this.nextOperation = ' ';
        this.currentValue = 0d;
        this.formatter = NumberFormat.getInstance();
        this.newValue = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Le bouton source de l'événement
        JButton button = (JButton) e.getSource();
        // Sa valeur faciale
        String buttonValue = button.getText();
        // L'écran de la calculette
        CalcScreen screen = calc.getScreen();

        // Gestion de l'événement selon le bouton cliqué
        switch (buttonValue) {
            case "C":
                // bouton C => réinitialisation de la valeur
                screen.setText("0");
                newValue = true;
                break;
            case "CE":
                // bouton CE => réinitialisation du calcul
                screen.setText("0");
                currentValue = 0d;
                newValue = true;
                break;
            case "+":
                // somme => effectuer le calcul et préparer le calcul suivant
                compute('+');
                break;
            case "-":
                // soustraction => effectuer le calcul et préparer le calcul suivant
                compute('-');
                break;
            case "x":
                // multiplication => effectuer le calcul et préparer au calcul suivant
                compute('*');
                break;
            case "/":
                // division => effectuer le calcul et préparer au calcul suivant
                compute('/');
                break;
            case "=":
                // total => effectuer le calcul
                compute('=');
                break;
            case ".":
                // ajout de la virgule si aucune virgule et si pas erreur
                if (!screen.getText().contains(",") && !screen.getText().equals("?")) { // uniquement si n'existe pas déjà !
                    screen.append(",");
                }
                break;
            default:
                // c'est un bouton chiffre
                if (newValue) {
                    screen.setText(buttonValue);
                    newValue = false;
                } else {
                    screen.append(buttonValue);
                }
        }
    }

    /**
     * Effectue le calcul et affiche le résultat sur l'écran de la calculette.
     */
    private void compute(char op) {
        // La valeur affichée à l'écran
        String screenContent = calc.getScreen().getText();
        double screenValue = "".equals(screenContent)
                ? 0d
                : formatter
                        .parse(screenContent, new ParsePosition(0))
                        .doubleValue();
        try {
            if (0 == currentValue) {
                currentValue = screenValue;
            } else {
                switch (nextOperation) {
                    case '+':
                        currentValue += screenValue;
                        break;
                    case '-':
                        currentValue -= screenValue;
                        break;
                    case '*':
                        currentValue *= screenValue;
                        break;
                    case '/':
                        if (0 != screenValue) {
                            currentValue /= screenValue;
                        } else {
                            throw new ArithmeticException("Division par zéro !");
                        }
                        break;
                }

            }
            nextOperation = op;
            calc.getScreen().setText(formatter.format(currentValue));
        } catch (ArithmeticException ae) {
            // Affiche une erreur sous forme de point d'interrogation
            calc.getScreen().setText("?");
        }
        newValue = true;
    }

}
