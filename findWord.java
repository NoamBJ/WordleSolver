import java.util.*;
import java.io.*;

public class findWord {

    Texte leTexte = new Texte("dicoOrdered.txt");

    String[] tableauGroupesLettres = leTexte.decoupe();
    List<String> list = Arrays.asList(tableauGroupesLettres);

    public static void main(String[] args) {

        String mot = "DROLE";

    }

    public void litMots(String s) {

        // s = DROLE01210 par exemple
        int faux = 0;
        int moyen = 1;
        int bon = 2;

        int j = 0;

        String guess;
        // que une seule lettre
        HashSet<Character> hsFaux = new HashSet<>();
        LinkedList<Character> listeMoyen = new LinkedList<>();
        // couple lettre et position
        HashMap<Character, Integer> hmBon = new HashMap<>();

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i + 5) == '0') {
                hsFaux.add(s.charAt(i));
            } else if (s.charAt(i + 5) == '1') {
                listeMoyen.add(s.charAt(i));
            } else {
                hmBon.put(s.charAt(i), i);
            }
        }

        // parcourir faux moyen et bon pour ajouter en conditons dans le if

        for (String mots : list) {
            // if ()

            System.out.println(mots);

        }
    }
}
