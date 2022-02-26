import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EcouteurX implements ActionListener {
    private HelpFenetre h;
    private fenetre fen;

    public EcouteurX(HelpFenetre h, fenetre fen) {
        this.h = h;
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        h.setVisible(false);
        fen.setVisible(true);
    }
}
