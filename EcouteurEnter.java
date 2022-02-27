import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class EcouteurEnter implements ActionListener {
    private fenetre fen;
    private JButton[][] txt;

    String nomDuFichierALire = "wordListOrdered.txt";

    public EcouteurEnter(fenetre fen, JButton[][] txt) {
        this.fen = fen;
        this.txt = txt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fen.changementLigne();
        // System.out.println(getMot()); marche pas
        verifieMot(getMot());
    }

    public String getMot() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < txt[fen.getX()].length; i++) {
            sb.append(txt[fen.getX()][i]);
        }
        return sb.toString();
    }

    public void verifieMot(String s) {
        Texte leTexte = new Texte(nomDuFichierALire);

        String[] tableauGroupesLettres = leTexte.decoupe();

        List<String> list = Arrays.asList(tableauGroupesLettres);

        Collections.sort(list);

        if (list.contains(s)) {
            System.out.println("c'est un mot");
        }
    }

}
