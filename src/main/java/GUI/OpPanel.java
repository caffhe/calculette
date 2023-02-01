package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class OpPanel extends JPanel {

    private final ArrayList<OperationButton> ops;
    private final Font font;

    public OpPanel(Font font) {
        ops = new ArrayList<>(6);
        this.font = font;
        setUp();
    }

    private void setUp() {
        setFont(font);
        setLayout(new GridLayout(3, 0, 5, 5));
        String[] opValues = {"C", "CE",
            "+", "-",
            "x", "/"
        };
        for (String operation : opValues) {
            // Création du bouton
            OperationButton ob;
            if (operation.equals("CE")) {
                ob = new RedOperationButton(operation, font);
            } else {
                ob = new OperationButton(operation, font);
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
