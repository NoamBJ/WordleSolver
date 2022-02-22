import java.io.*;
import java.util.*;

public class worldeList {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        String nomDuFichierALire = "wordleList.txt";
        PrintWriter writer = new PrintWriter("wordListOrdered.txt", "UTF-8");

        // Lecture du fichier et creation du texte en memoire:
        Texte leTexte = new Texte(nomDuFichierALire);

        // Le texte est ensuite decoupe en groupes de lettres
        String[] tableauGroupesLettres = leTexte.decoupe();

        HashMap<String, Integer> mapMots = new HashMap<String, Integer>();

        for (int i = 0; i < tableauGroupesLettres.length; i++) {

            String groupeLettres = tableauGroupesLettres[i];

            // System.out.println(groupeLettres);
            if (!mapMots.containsKey(groupeLettres)) {
                mapMots.put(groupeLettres, 0);
            }
            int val = mapMots.get(groupeLettres);
            mapMots.put(groupeLettres, val + 1);
        }

        LinkedList<String> list = new LinkedList<String>();

        // ajoute les mots dans une liste

        for (String key : mapMots.keySet()) {
            list.add(key);
        }

        // trie la liste et ajoute le mot dans le fichier

        Collections.sort(list);
        for (String a : list) {
            writer.println(a);
        }
        writer.close();
    }
}
