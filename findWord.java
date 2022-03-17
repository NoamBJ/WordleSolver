import java.util.*;
import java.io.*;

public class findWord {

    public static void main(String[] args) {
        Texte leTexte = new Texte("dicoOrdered.txt");

        String[] tableauGroupesLettres = leTexte.decoupe();
        List<String> list = Arrays.asList(tableauGroupesLettres);

        Scanner sc = new Scanner(System.in);
        String reponse = "DROLE";
        System.out.println("La reponse est " + reponse);

        for (int i = 0; i < 10; i++) {
            System.out.println("Entrez votre mot ");
            String input = sc.nextLine();
            litMots(input, list);
        }

    }

    public static void litMots(String s, List list) {

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
                // supprime les mots ne contenant pas la lettre
                // for (String mots : list) {
                // if (mots.contains(String.valueOf(s.charAt(i)))) {
                // list.remove(mots);
                // }
                // }

            } else if (s.charAt(i + 5) == '1') {
                listeMoyen.add(s.charAt(i));
            } else {
                hmBon.put(s.charAt(i), i);
            }
        }

        // parcourir faux moyen et bon pour ajouter en conditons dans le if

        for (String mots : list) {
            System.out.println(mots);
        }
    }
}
