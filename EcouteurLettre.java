import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EcouteurLettre implements ActionListener {
    private fenetre fen;
    private String lettre;
    private JButton[][] txt;
    private int x;

    public EcouteurLettre(fenetre fen, String lettre, JButton[][] txt, int x) {
        this.fen = fen;
        this.lettre = lettre;
        this.txt = txt;
        this.x = x;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int y = fen.caseVide();
        try {
            if (y < txt[x].length) {
                txt[fen.getX()][fen.caseVide()].setText(lettre);
                txt[fen.getX()][fen.caseVide()].setForeground(Color.white);
                txt[fen.getX()][fen.caseVide()].setFont(new Font("Arial", Font.BOLD, 42));
            }
        } catch (Exception ex) {

        }

    }

    public void effectuer() {
        int y = fen.caseVide();
        try {
            if (y < txt[x].length) {
                txt[fen.getX()][fen.caseVide()].setText(lettre);
                txt[fen.getX()][fen.caseVide()].setForeground(Color.white);
                txt[fen.getX()][fen.caseVide()].setFont(new Font("Arial", Font.BOLD, 42));
            }
        } catch (Exception ex) {

        }

    }
}
