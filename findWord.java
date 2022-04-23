import java.util.*;

import java.io.*;

public class findWord {
    private ArrayList<String> liste_mots;
    private ArrayList<String> liste_reponse;
    private Quintuple[] possibility;

    public findWord(ArrayList<String> liste_mots, ArrayList<String> liste_reponse, Quintuple[] possibility) {
        this.liste_mots = liste_mots;
        this.liste_reponse = liste_reponse;
        this.possibility = possibility;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final int nb_mots = 12972;

        File file1 = new File("wordListOrdered.txt");
        File file2 = new File("wordle-guesses.txt");
        File file3 = new File("permutations.txt");

        Scanner in1 = new Scanner(file1);
        Scanner in2 = new Scanner(file2);
        Scanner in3 = new Scanner(file3);

        ArrayList<String> liste_mots = new ArrayList<String>();
        ArrayList<String> liste_reponse = new ArrayList<String>();
        ArrayList<String> perm = new ArrayList<String>();
        while (in1.hasNext()) {
            liste_mots.add(in1.next());
        }

        while (in2.hasNext()) {
            liste_reponse.add(in2.next());
        }

        while (in3.hasNext()) {
            perm.add(in3.next());
        }
        in1.close();
        in2.close();
        in3.close();

        String[] permutations = perm.toArray(new String[perm.size()]);

        // création d'un tableau de quintuple avec toutes les combinaisons possibles

        Quintuple[] possibility = new Quintuple[permutations.length];

        for (int i = 0; i < possibility.length; i++) {
            int j = 0;
            possibility[i] = new Quintuple(permutations[i].charAt(j), permutations[i].charAt(j + 1),
                    permutations[i].charAt(j + 2), permutations[i].charAt(j + 3), permutations[i].charAt(j + 4));
        }
        
    }

    // calcul moyenne
    public static double calculMoyenne(Quintuple[] possibility, String test, ArrayList<String> liste_reponse) {

        double moyenne = 0;

        for (int i = 0; i < possibility.length; i++) {
            ArrayList<String> temp = new ArrayList<>(liste_reponse);
            // supprime les mots qui ont pas la lettre a la bonne place
            // indice 0
            if (possibility[i].get0() == '2') {
                for (String s : liste_reponse) {
                    if (s.charAt(0) != test.charAt(0)) {
                        temp.remove(s);
                    }
                }
            }
            // indice 1
            if (possibility[i].get1() == '2') {
                for (String s : liste_reponse) {
                    if (s.charAt(1) != test.charAt(1)) {
                        temp.remove(s);
                    }
                }
            }
            // indice 2
            if (possibility[i].get2() == '2') {
                for (String s : liste_reponse) {
                    if (s.charAt(2) != test.charAt(2)) {
                        temp.remove(s);
                    }
                }
            }
            // indice 3
            if (possibility[i].get3() == '2') {
                for (String s : liste_reponse) {
                    if (s.charAt(3) != test.charAt(3)) {
                        temp.remove(s);
                    }
                }
            }
            // indice 4
            if (possibility[i].get4() == '2') {
                for (String s : liste_reponse) {
                    if (s.charAt(4) != test.charAt(4)) {
                        temp.remove(s);
                    }
                }
            }

            // supprime si le mot ne contient pas le charactere
            // indice 0
            if (possibility[i].get0() == '1') {
                for (String s : liste_reponse) {
                    if (!s.contains(String.valueOf(test.charAt(0))) || test.charAt(0) != s.charAt(0)) {
                        temp.remove(s);
                    }
                }
            }
            // indice 1
            if (possibility[i].get1() == '1') {
                for (String s : liste_reponse) {
                    if (!s.contains(String.valueOf(test.charAt(1))) || test.charAt(1) != s.charAt(1)) {
                        temp.remove(s);
                    }

                }
            }
            // indice 2
            if (possibility[i].get2() == '1') {
                for (String s : liste_reponse) {
                    if (!s.contains(String.valueOf(test.charAt(2))) || test.charAt(2) != s.charAt(2)) {
                        temp.remove(s);
                    }

                }
            }
            // indice 3
            if (possibility[i].get3() == '1') {
                for (String s : liste_reponse) {
                    if (!s.contains(String.valueOf(test.charAt(3))) || test.charAt(3) != s.charAt(3)) {
                        temp.remove(s);
                    }

                }
            }
            // indice 4
            if (possibility[i].get4() == '1') {
                for (String s : liste_reponse) {
                    if (!s.contains(String.valueOf(test.charAt(4))) || test.charAt(4) != s.charAt(4)) {
                        temp.remove(s);
                    }

                }
            }

            // supprime si le mot ne contient pas la lettre
            // indice 0
            if (possibility[i].get0() == '0') {
                for (String s : liste_reponse) {
                    if (s.contains(String.valueOf(test.charAt(0)))) {
                        temp.remove(s);
                    }
                }
            }
            // indice 1
            if (possibility[i].get1() == '0') {
                for (String s : liste_reponse) {
                    if (s.contains(String.valueOf(test.charAt(1)))) {
                        temp.remove(s);
                    }
                }
            }
            // indice 2
            if (possibility[i].get2() == '0') {
                for (String s : liste_reponse) {
                    if (s.contains(String.valueOf(test.charAt(2)))) {
                        temp.remove(s);
                    }
                }
            }
            // indice 3
            if (possibility[i].get3() == '0') {
                for (String s : liste_reponse) {
                    if (s.contains(String.valueOf(test.charAt(3)))) {
                        temp.remove(s);
                    }
                }
            }
            // indice 4
            if (possibility[i].get4() == '0') {
                for (String s : liste_reponse) {
                    if (s.contains(String.valueOf(test.charAt(4)))) {
                        temp.remove(s);
                    }
                }
            }
            moyenne += temp.size();
            // System.out.print(temp.size() + " ");
        }

        return moyenne / possibility.length;
        // double sum = moyenne / tab_moyenne.length;
        // System.out.println("nb de mots " + moyenne);
        // System.out.println("moyenne = " + sum);
    }

    public static ArrayList<String> retireMot(Quintuple quintuple, String test, ArrayList<String> liste_reponse) {

        ArrayList<String> temp = new ArrayList<>(liste_reponse);
        temp.remove(test);
        HashSet<Character> contains_char = new HashSet<>();
        // supprime les mots qui ont pas la lettre a la bonne place
        // indice 0
        if (quintuple.get0() == '2') {
            contains_char.add(test.charAt(0));
            for (String s : liste_reponse) {
                if (s.charAt(0) != test.charAt(0)) {
                    temp.remove(s);
                }
            }
        }
        // indice 1
        if (quintuple.get1() == '2') {
            contains_char.add(test.charAt(1));
            for (String s : liste_reponse) {
                if (s.charAt(1) != test.charAt(1)) {
                    temp.remove(s);
                }
            }
        }
        // indice 2
        if (quintuple.get2() == '2') {
            contains_char.add(test.charAt(2));
            for (String s : liste_reponse) {
                if (s.charAt(2) != test.charAt(2)) {
                    temp.remove(s);
                }
            }
        }
        // indice 3
        if (quintuple.get3() == '2') {
            contains_char.add(test.charAt(3));
            for (String s : liste_reponse) {
                if (s.charAt(3) != test.charAt(3)) {
                    temp.remove(s);
                }
            }
        }
        // indice 4
        if (quintuple.get4() == '2') {
            contains_char.add(test.charAt(4));
            for (String s : liste_reponse) {
                if (s.charAt(4) != test.charAt(4)) {
                    temp.remove(s);
                }
            }
        }

        // supprime si le mot ne contient pas le charactere
        // indice 0
        if (quintuple.get0() == '1') {
            contains_char.add(test.charAt(0));
            for (String s : liste_reponse) {
                if (!s.contains(String.valueOf(test.charAt(0))) || test.charAt(0) == s.charAt(0)) {
                    temp.remove(s);
                }
            }
        }
        // indice 1
        if (quintuple.get1() == '1') {
            contains_char.add(test.charAt(1));
            for (String s : liste_reponse) {
                if (!s.contains(String.valueOf(test.charAt(1))) || test.charAt(1) == s.charAt(1)) {
                    temp.remove(s);
                }
            }
        }
        // indice 2
        if (quintuple.get2() == '1') {
            contains_char.add(test.charAt(2));
            for (String s : liste_reponse) {
                if (!s.contains(String.valueOf(test.charAt(2))) || test.charAt(2) == s.charAt(2)) {
                    temp.remove(s);
                }
            }
        }
        // indice 3
        if (quintuple.get3() == '1') {
            contains_char.add(test.charAt(3));
            for (String s : liste_reponse) {
                if (!s.contains(String.valueOf(test.charAt(3))) || test.charAt(3) == s.charAt(3)) {
                    temp.remove(s);
                }
            }
        }
        // indice 4
        if (quintuple.get4() == '1') {
            contains_char.add(test.charAt(4));
            for (String s : liste_reponse) {
                if (!s.contains(String.valueOf(test.charAt(4))) || test.charAt(4) == s.charAt(4)) {
                    temp.remove(s);
                }
            }
        }

        // supprime si le mot ne contient pas la lettre
        // indice 0
        if (quintuple.get0() == '0' && !contains_char.contains(test.charAt(0))) {
            for (String s : liste_reponse) {
                if (s.contains(String.valueOf(test.charAt(0)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 1
        if (quintuple.get1() == '0' && !contains_char.contains(test.charAt(1))) {
            for (String s : liste_reponse) {
                if (s.contains(String.valueOf(test.charAt(1)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 2
        if (quintuple.get2() == '0' && !contains_char.contains(test.charAt(2))) {
            for (String s : liste_reponse) {
                if (s.contains(String.valueOf(test.charAt(2)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 3
        if (quintuple.get3() == '0' && !contains_char.contains(test.charAt(3))) {
            for (String s : liste_reponse) {
                if (s.contains(String.valueOf(test.charAt(3)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 4
        if (quintuple.get4() == '0' && !contains_char.contains(test.charAt(4))) {
            for (String s : liste_reponse) {
                if (s.contains(String.valueOf(test.charAt(4)))) {
                    temp.remove(s);
                }
            }
        }
        liste_reponse = new ArrayList<>(temp);
        return liste_reponse;
    }

    public static void test_RetireMot(Quintuple quintuple, String test, ArrayList<String> liste_reponse) {

        ArrayList<String> temp = new ArrayList<>(liste_reponse);

        // supprime les mots qui ont pas la lettre a la bonne place
        // indice 0
        if (quintuple.get0() == '2') {
            for (String s : liste_reponse) {
                if (s.charAt(0) != test.charAt(0)) {
                    temp.remove(s);
                }
            }
        }
        // indice 1
        if (quintuple.get1() == '2') {
            for (String s : liste_reponse) {
                if (s.charAt(1) != test.charAt(1)) {
                    temp.remove(s);
                }
            }
        }
        // indice 2
        if (quintuple.get2() == '2') {
            for (String s : liste_reponse) {
                if (s.charAt(2) != test.charAt(2)) {
                    temp.remove(s);
                }
            }
        }
        // indice 3
        if (quintuple.get3() == '2') {
            for (String s : liste_reponse) {
                if (s.charAt(3) != test.charAt(3)) {
                    temp.remove(s);
                }
            }
        }
        // indice 4
        if (quintuple.get4() == '2') {
            for (String s : liste_reponse) {
                if (s.charAt(4) != test.charAt(4)) {
                    temp.remove(s);
                }
            }
        }

        // supprime si le mot ne contient pas le charactere
        // indice 0
        if (quintuple.get0() == '1') {
            for (String s : liste_reponse) {
                if (!s.contains(String.valueOf(test.charAt(0)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 1
        if (quintuple.get1() == '1') {
            for (String s : liste_reponse) {
                if (!s.contains(String.valueOf(test.charAt(1)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 2
        if (quintuple.get2() == '1') {
            for (String s : liste_reponse) {
                if (!s.contains(String.valueOf(test.charAt(2)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 3
        if (quintuple.get3() == '1') {
            for (String s : liste_reponse) {
                if (!s.contains(String.valueOf(test.charAt(3)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 4
        if (quintuple.get4() == '1') {
            for (String s : liste_reponse) {
                if (!s.contains(String.valueOf(test.charAt(4)))) {
                    temp.remove(s);
                }
            }
        }

        // supprime si le mot ne contient pas la lettre
        // indice 0
        if (quintuple.get0() == '0') {
            for (String s : liste_reponse) {
                if (s.contains(String.valueOf(test.charAt(0)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 1
        if (quintuple.get1() == '0') {
            for (String s : liste_reponse) {
                if (s.contains(String.valueOf(test.charAt(1)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 2
        if (quintuple.get2() == '0') {
            for (String s : liste_reponse) {
                if (s.contains(String.valueOf(test.charAt(2)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 3
        if (quintuple.get3() == '0') {
            for (String s : liste_reponse) {
                if (s.contains(String.valueOf(test.charAt(3)))) {
                    temp.remove(s);
                }
            }
        }
        // indice 4
        if (quintuple.get4() == '0') {
            for (String s : liste_reponse) {
                if (s.contains(String.valueOf(test.charAt(4)))) {
                    temp.remove(s);
                }
            }
        }
        System.out.println("temp size = " + temp.size());
        // Collections.copy(liste_reponse, temp);
        liste_reponse = new ArrayList<>(temp);
        for (String s : liste_reponse) {
            System.out.println(s + " ");
        }
    }

    public Quintuple stringToQuintuple(StringBuilder mot) {
        return new Quintuple(mot.charAt(0), mot.charAt(1), mot.charAt(2), mot.charAt(3), mot.charAt(4));
    }

    public StringBuilder compareGuess(String reponse, String guess) {

        StringBuilder str = new StringBuilder("00000");

        char r0 = reponse.charAt(0);
        char r1 = reponse.charAt(1);
        char r2 = reponse.charAt(2);
        char r3 = reponse.charAt(3);
        char r4 = reponse.charAt(4);

        char g0 = guess.charAt(0);
        char g1 = guess.charAt(1);
        char g2 = guess.charAt(2);
        char g3 = guess.charAt(3);
        char g4 = guess.charAt(4);

        LinkedList<Character> char_in_word = new LinkedList<>();
        char_in_word.add(g0);
        char_in_word.add(g1);
        char_in_word.add(g2);
        char_in_word.add(g3);
        char_in_word.add(g4);

        // si char a la bonne place
        if (g0 == r0) {
            str.setCharAt(0, '2');
            char_in_word.removeFirstOccurrence(g0);
        }
        if (g1 == r1) {
            str.setCharAt(1, '2');
            char_in_word.removeFirstOccurrence(g1);
        }
        if (g2 == r2) {
            str.setCharAt(2, '2');
            char_in_word.removeFirstOccurrence(g2);
        }
        if (g3 == r3) {
            str.setCharAt(3, '2');
            char_in_word.removeFirstOccurrence(g3);
        }
        if (g4 == r4) {
            str.setCharAt(4, '2');
            char_in_word.removeFirstOccurrence(g4);
        }

        // si char present dans le mot
        if (reponse.contains(String.valueOf(g0)) && char_in_word.contains(g0)) {
            str.setCharAt(0, '1');
            char_in_word.removeFirstOccurrence(g0);
        }
        if (reponse.contains(String.valueOf(g1)) && char_in_word.contains(g1)) {
            str.setCharAt(1, '1');
            char_in_word.removeFirstOccurrence(g1);
        }
        if (reponse.contains(String.valueOf(g2)) && char_in_word.contains(g2)) {
            str.setCharAt(2, '1');
            char_in_word.removeFirstOccurrence(g2);
        }
        if (reponse.contains(String.valueOf(g3)) && char_in_word.contains(g3)) {
            str.setCharAt(3, '1');
            char_in_word.removeFirstOccurrence(g3);
            
        }
        if (reponse.contains(String.valueOf(g4)) && char_in_word.contains(g4)) {
            str.setCharAt(4, '1');
            char_in_word.removeFirstOccurrence(g4);
            
        }
        
        return str;
    }

    // joue pour trouver un mot avec le quintuple donné par l'utilisateur
    public String joue(Quintuple quintuple_rep, String word) {
        
        ArrayList<Double> valeur_moyenne_mots = new ArrayList<>();
        HashMap<Double, String> map_reponse = new HashMap<>();
       
        this.liste_mots.remove(word);
        this.liste_reponse = retireMot(quintuple_rep, word, this.liste_reponse);
        for (int j = 0; j < this.liste_mots.size(); j++) {
            double valeur = calculMoyenne(this.possibility, this.liste_mots.get(j), this.liste_reponse);
            valeur_moyenne_mots.add(valeur);
            map_reponse.put(valeur, this.liste_mots.get(j));
        }
       

        Collections.sort(valeur_moyenne_mots, Collections.reverseOrder());

       
        word = map_reponse.get(valeur_moyenne_mots.get(0));
        
        return "meilleur mot = \n" + word;
    }
}
