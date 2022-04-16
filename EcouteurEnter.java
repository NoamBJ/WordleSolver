import java.awt.Color;
import java.awt.event.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;

import javax.swing.*;

public class EcouteurEnter implements ActionListener {
	private fenetre fen;
	private JButton[][] txt;
	private JButton[] clavier;
	private HashMap<String, Integer> m;
	private JTextArea areaTriche;

	String nomDuFichierALire = "dicoOrdered.txt";

	public EcouteurEnter(fenetre fen, JButton[][] txt, JButton[] clavier, HashMap<String, Integer> m,
			JTextArea areaTriche) {
		this.fen = fen;
		this.txt = txt;
		this.clavier = clavier;
		this.m = m;
		this.areaTriche = areaTriche;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = fen.getMot();
		String word = fen.getReponse();
		System.out.println(word);

		if (fen.verifieMot(input)) {

			StringBuilder quintuple = fen.robot.compareGuess(word, input);
			fen.changementLigne();
			if (fen.getX() == 6 && !kelawin(word, input)) {
				JOptionPane.showMessageDialog(fen, "T'es trop un looser. Le bon mot etait " + word, "Looser", 1);
			} else if (kelawin(word, input)) {

			} else {
				couleur(quintuple, input);
				// System.out.println(fen.robot.joue(fen.robot.stringToQuintuple(quintuple),
				// input));
				areaTriche.setText(fen.robot.joue(fen.robot.stringToQuintuple(quintuple), input));
			}
		}
	}

	public void execute() {
		String input = fen.getMot();
		String word = fen.getReponse();
		System.out.println(word);

		if (fen.verifieMot(input)) {

			StringBuilder quintuple = fen.robot.compareGuess(word, input);
			fen.changementLigne();
			if (fen.getX() == 6 && !kelawin(word, input)) {
				JOptionPane.showMessageDialog(fen, "T'es trop un looser. Le bon mot etait " + word, "Looser", 1);
			} else if (kelawin(word, input)) {

			} else {
				couleur(quintuple, input);
				// System.out.println(fen.robot.joue(q, input));
				// areaTriche.setText(fen.robot.joue(q, input));
			}
		}
	}

	public void couleur(StringBuilder str, String input) {
		for (int i = 0; i < str.length(); i++) {
			char c = input.charAt(i);
			int value = m.get(String.valueOf(c).toUpperCase());
			if (str.charAt(i) == '0') {
				clavier[value].setForeground(Color.gray);
				txt[fen.getX() - 1][i].setForeground(Color.gray);
			} else if (str.charAt(i) == '1') {
				clavier[value].setForeground(Color.orange);
				txt[fen.getX() - 1][i].setForeground(Color.orange);
			} else {
				clavier[value].setForeground(Color.green);
				txt[fen.getX() - 1][i].setForeground(Color.green);
			}

		}

	}

	public boolean kelawin(String word, String input) {
		boolean gagner = false;
		if (word.equals(input)) {
			gagner = true;
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				int value = m.get(String.valueOf(c).toUpperCase());

				txt[fen.getX() - 1][i].setForeground(Color.green);
				clavier[value].setForeground(Color.green);

			}
			JOptionPane.showMessageDialog(fen, "T'es trop un crack.", "Congrats", 1);

		}
		return gagner;
	}
}
