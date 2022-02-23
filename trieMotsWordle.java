import java.io.*;
import java.util.*;

public class trieMotsWordle {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        String nomDuFichierALire = "wordleList.txt";
        PrintWriter writer = new PrintWriter("wordListOrdered.txt", "UTF-8");

        // Lecture du fichier et creation du texte en memoire:
        Texte leTexte = new Texte(nomDuFichierALire);

        // Le texte est ensuite decoupe en groupes de lettres
        String[] tableauGroupesLettres = leTexte.decoupe();

        List<String> list = Arrays.asList(tableauGroupesLettres);

        // trie la liste et ajoute le mot dans le fichier

        Collections.sort(list);
        for (String a : list) {
            writer.println(a);
        }
        writer.close();
    }
}
