import java.awt.Color;
import java.awt.event.*;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.*;

public class EcouteurEnter implements ActionListener {
    private fenetre fen;
    private JButton[][] txt;
    private JButton[] clavier;
    private HashMap<String, Integer> m;

    String nomDuFichierALire = "dicoOrdered.txt";

    public EcouteurEnter(fenetre fen, JButton[][] txt, JButton[] clavier, HashMap<String, Integer> m) {
        this.fen = fen;
        this.txt = txt;
        this.clavier = clavier;
        this.m = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = fen.getMot();
        String word = fen.getReponse();
        System.out.println(word);

        if (fen.verifieMot(input)) {

            fen.changementLigne();
            if (fen.getX() == 6) {
                JOptionPane.showMessageDialog(fen, "T'es trop un looser. Le bon mot etait " + word, "Looser", 1);
            } else {
                containChar(word, input);
                kelawin(word, input);
            }

        }
    }

    public void containChar(String word, String input) {

        boolean b = true;
        LinkedList<Character> l = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            l.add(word.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int value = m.get(String.valueOf(c).toUpperCase());

            if (word.equals(input)) {
                txt[fen.getX() - 1][i].setForeground(Color.green);
                clavier[value].setForeground(Color.green);
            }

            else if (word.charAt(i) == input.charAt(i)) {
                txt[fen.getX() - 1][i].setForeground(Color.green);
                clavier[value].setForeground(Color.green);
                b = false;
            }

            else if (l.contains(input.charAt(i)) && b == true) {
                txt[fen.getX() - 1][i].setForeground(Color.orange);
                clavier[value].setForeground(Color.orange);
            } else {
                txt[fen.getX() - 1][i].setForeground(Color.gray);
                clavier[value].setForeground(Color.gray);
            }

        }
    }

    public void kelawin(String word, String input) {
        if (word.equals(input)) {
            JOptionPane.showMessageDialog(fen, "T'es trop un crack.", "Congrats", 1);
        }
    }

}
