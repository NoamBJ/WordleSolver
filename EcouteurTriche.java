import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EcouteurTriche implements ActionListener {
    private fenetre fen;
    private JTextArea areaTriche;

    public EcouteurTriche(fenetre fen, JTextArea areaTriche) {
        this.fen = fen;
        this.areaTriche = areaTriche;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        areaTriche.setForeground(Color.black);
        areaTriche.setBackground(Color.black);
        areaTriche.setText("");
        areaTriche.setBorder(null);
        areaTriche.setEditable(false);

    }
}