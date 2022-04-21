import java.io.*;
import java.util.*;

public class trieMotsWordle {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        String nomDuFichierALire = "dictionnaire.txt";
        PrintWriter writer = new PrintWriter("dicoOrdered.txt", "UTF-8");

        // Lecture du fichier et creation du texte en memoire:
        Texte leTexte = new Texte(nomDuFichierALire);

        // Le texte est ensuite decoupe en groupes de lettres
        String[] tableauGroupesLettres = leTexte.decoupe();

        List<String> list = Arrays.asList(tableauGroupesLettres);

        // trie la liste et ajoute le mot dans le fichier

        Collections.sort(list);
        for (String a : list) {
			if(a.length() == 5){
				boolean yesLife = true;
				Character[] listeMerde = new Character[10];
				listeMerde[0] = 'ƒ';
				for(int i = 0; i<5 ;  i++){
					if(a.charAt(i) == listeMerde[0]){
						yesLife = false;
					} 
				}
				if(yesLife){
					writer.println(a);
				}
			}
        }
        writer.close();
    }
}
