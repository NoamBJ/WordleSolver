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
            if (word.charAt(4) == 'e' && word.charAt(3) == 'e' && word.contains("r") && !word.contains("s")
                    && !word.contains("a") && !word.contains("l") && !word.contains("t") && !word.contains("c")
                    && !word.contains("h") && !word.contains("d") && !word.contains("o")) {
                System.out.println(word);
            }
        }

    }
}
