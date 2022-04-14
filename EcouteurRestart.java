import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EcouteurRestart implements ActionListener {
    private fenetre fen;
    private JButton[][] txt;
    private JButton[] clavier;

    public EcouteurRestart(fenetre fen, JButton[][] txt, JButton[] clavier) {
        this.fen = fen;
        this.txt = txt;
        this.clavier = clavier;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < txt.length; i++) {
            for (int j = 0; j < txt[i].length; j++) {
                txt[i][j].setText("");
                txt[i][j].setForeground(Color.white);
            }
        }
        for (int i = 0; i < 26; i++) {
            clavier[i].setForeground(Color.white);
        }
        fen.setX(0);
        fen.nouvRep();

    }
}
