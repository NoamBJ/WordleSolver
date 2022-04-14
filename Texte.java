import java.util.*;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.file.Files;

// IL N'EST PAS NECESSAIRE DE COMPRENDRE CE CODE POUR CE TP.
// Les informations utiles sont donnees dans les commentaires
// du programme Main_Mystere.java

public class Texte {

    public List<String> listeLignes;

    public String toString() {

        String texteComplet;
        texteComplet = "";

        for (String ligne : listeLignes) {
            texteComplet = texteComplet + ligne + "\n";
        }
        return texteComplet;
    }

    public String[] decoupe() {
        String texteComplet;
        texteComplet = this.toString();

        String[] tableauGroupesLettres;

        tableauGroupesLettres = texteComplet.split("[.,;:?!' \n]+");
        if (tableauGroupesLettres[0].equals("")) {
            // si le premier mot est le mot vide on le supprime
            for (int i = 0; i < tableauGroupesLettres.length - 1; i++) {
                tableauGroupesLettres[i] = tableauGroupesLettres[i + 1];
            }
        }

        return tableauGroupesLettres;
    }

    public Quintuple[] decoupeToQuintuples(String[] a) {
        Quintuple[] possibility = new Quintuple[a.length];

        for (int i = 0; i < possibility.length; i++) {
            int j = 0;
            possibility[i] = new Quintuple(a[i].charAt(j), a[i].charAt(j + 1),
                    a[i].charAt(j + 2), a[i].charAt(j + 3), a[i].charAt(j + 4));
        }
        return possibility;
    }

    public Texte(String nomFichier) {
        try {
            listeLignes = Files.readAllLines(Paths.get(nomFichier), Charset.defaultCharset());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
