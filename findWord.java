import java.io.*;
import java.util.*;

public class findWord {

    public static void main(String[] args) {

        String nomDuFichierALire = "wordListOrdered.txt";

        // Lecture du fichier et creation du texte en memoire:
        Texte leTexte = new Texte(nomDuFichierALire);

        // Le texte est ensuite decoupe en groupes de lettres
        String[] tableauGroupesLettres = leTexte.decoupe();

        List<String> list = Arrays.asList(tableauGroupesLettres);
        for (String word : list) {
            if (word.charAt(4) == 'e') {
                System.out.println(word);
            }
        }

    }
}
