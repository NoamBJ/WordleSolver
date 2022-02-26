import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EcouteurLettre implements ActionListener {
    private fenetre fen;
    private String lettre;
    private JButton[] txt;

    public EcouteurLettre(fenetre fen, String lettre, JButton[] txt) {
        this.fen = fen;
        this.lettre = lettre;
        this.txt = txt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        txt[fen.caseVide()].setText(lettre);
        txt[fen.caseVide()].setForeground(Color.white);
        txt[fen.caseVide()].setFont(new Font("Arial", Font.BOLD, 42));
    }
}
