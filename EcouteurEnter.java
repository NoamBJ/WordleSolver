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
			if (fen.getX() == 6 && !kelawin(word, input)) {
				JOptionPane.showMessageDialog(fen, "T'es trop un looser. Le bon mot etait " + word, "Looser", 1);
			} else if (kelawin(word, input)) {
				kelawin(word, input);
			} else {
				vert(word, input);
				containChar(word, input);
				quintuple();
				System.out.println(quintuple());
			}

		}
	}

	public void execute() {
		String input = fen.getMot();
		String word = fen.getReponse();
		System.out.println(word);

		if (fen.verifieMot(input)) {

			fen.changementLigne();
			if (fen.getX() == 6) {
				JOptionPane.showMessageDialog(fen, "T'es trop un looser. Le bon mot etait " + word, "Looser", 1);
			} else if (kelawin(word, input)) {
				kelawin(word, input);
			} else {
				vert(word, input);
				containChar(word, input);

			}
			// fen.robot.joue();
		}
	}

	public void vert(String word, String input) {
		ArrayList<Character> l = new ArrayList<>();
		ArrayList<Character> in = new ArrayList<>();

		for (int i = 0; i < word.length(); i++) {
			l.add(word.charAt(i));
			in.add(input.charAt(i));

		}

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			int value = m.get(String.valueOf(c).toUpperCase());
			if (word.equals(input)) {
				clavier[value].setForeground(Color.green);

			} else if (word.charAt(i) == input.charAt(i)) {
				txt[fen.getX() - 1][i].setForeground(Color.green);
				clavier[value].setForeground(Color.green);

			}

		}
	}

	public void containChar(String word, String input) {

		boolean b = true;
		ArrayList<Character> l = new ArrayList<>();
		ArrayList<Character> in = new ArrayList<>();

		for (int i = 0; i < word.length(); i++) {
			l.add(word.charAt(i));
			in.add(input.charAt(i));

		}
		for (int j = 0; j < word.length(); j++) {
			if (txt[fen.getX() - 1][j].getForeground() == Color.green) {
				char c = input.charAt(j);
				int value = m.get(String.valueOf(c).toUpperCase());
				System.out.println("est vert " + l.get(j));
				l.set(j, null);
				txt[fen.getX() - 1][j].setForeground(Color.green);
				clavier[value].setForeground(Color.green);
			}
		}

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			int value = m.get(String.valueOf(c).toUpperCase());

			System.out.println(" lettre avant orange " + i + "   " + l.get(i));
			System.out.println(clavier[value].getForeground());

			if (l.contains(in.get(i)) && txt[fen.getX() - 1][i].getForeground() != Color.green) {

				System.out.println(l.indexOf(in.get(i)));

				txt[fen.getX() - 1][i].setForeground(Color.orange);
				clavier[value].setForeground(Color.orange);
				// System.out.println(in.get(i)+" "+ +i);
				l.set(l.indexOf(in.get(i)), null);
				System.out.println("lettre après orange " + i + "   " + l.get(i));

			} else if (l.get(i) == null && txt[fen.getX() - 1][i].getForeground() == Color.green
					&& clavier[value].getForeground() == Color.green) {

			} else {
				if (clavier[value].getForeground() == Color.orange) {
					clavier[value].setForeground(Color.orange);
					txt[fen.getX() - 1][i].setForeground(Color.gray);

				} else {
					txt[fen.getX() - 1][i].setForeground(Color.gray);

					clavier[value].setForeground(Color.gray);
				}

				// fen.setTimeout(fen.changeBackground(colo, fen.getX()-1, i), 1000);
			}
		}
	}

	public StringBuilder quintuple() {
		StringBuilder s = new StringBuilder("00000");
		for (int i = 0; i < 5; i++) {
			if (txt[fen.getX() - 1][i].getForeground() == Color.green) {
				s.setCharAt(i, '2');
			}

			else if (txt[fen.getX() - 1][i].getForeground() == Color.orange) {

				s.setCharAt(i, '1');
			}

		}
		return s;
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
