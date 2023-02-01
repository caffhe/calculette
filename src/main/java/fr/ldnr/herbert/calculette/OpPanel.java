package fr.ldnr.herbert.calculette;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class OpPanel extends JPanel {

    private ArrayList<OperationButton> ops;

    public OpPanel() {
        ops = new ArrayList<>(6);
        setUp();
    }

    private void setUp() {
        setLayout(new GridLayout(3, 0, 5, 5));
        String[] opValues = {"C", "CE",
            "+", "-",
            "x", "/"
        };
        for (String operation : opValues) {
            // Création du bouton
            OperationButton ob;
            if (operation.equals("CE")) {
                ob = new RedOperationButton(operation);
            } else {
                ob = new OperationButton(operation);
            }
            // Ajout à la liste des boutons à exporter
            ops.add(ob);
            // Ajout au panel
            add(ob);
        }
    }

    public ArrayList<OperationButton> getOps() {
        return ops;
    }

}
