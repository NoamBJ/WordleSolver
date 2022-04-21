import java.awt.event.*;
import javax.swing.*;

public class EcouteurDelete implements ActionListener {
    private fenetre fen;
    private JButton[][] txt;
    private int x;

    public EcouteurDelete(fenetre fen, JButton[][] txt, int x) {
        this.fen = fen;
        this.txt = txt;
        this.x = x;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int min = fen.caseVide();
        if (min > 0) {
            txt[fen.getX()][min - 1].setText("");
        }
    }

}
