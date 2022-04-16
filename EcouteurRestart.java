import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EcouteurRestart implements ActionListener {
    private fenetre fen;

    public EcouteurRestart(fenetre fen) {
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fen.dispose();
        new fenetre();
    }
}
