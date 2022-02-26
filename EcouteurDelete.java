import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EcouteurDelete implements ActionListener {
    private fenetre fen;
    private JButton[] txt;

    public EcouteurDelete(fenetre fen, JButton[] txt) {
        this.fen = fen;
        this.txt = txt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int min = fen.caseVide();
        if (min > 0) {
            txt[min - 1].setText("");
        }

    }
}
