import java.util.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        findWord robot = new findWord(liste_mots, liste_reponse, possibility);
        // robot.joue();

        // ArrayList<Double> valeur_moyenne_mots = new ArrayList<>();
        // HashMap<Double, String> map_reponse = new HashMap<>();

        // long start = System.currentTimeMillis();
        // for (int i = 0; i < liste_mots.size(); i++) {
        // double valeur = calculMoyenne(possibility, liste_mots.get(i), liste_reponse);
        // valeur_moyenne_mots.add(valeur);
        // map_reponse.put(valeur, liste_mots.get(i));
        // }
        // Collections.sort(valeur_moyenne_mots, Collections.reverseOrder());
        // long finish = System.currentTimeMillis();
        // long time = finish - start;

        // System.out.println("temps ecoule " + time);
        // System.out.println("valeur moyenne = " + valeur_moyenne_mots.get(0));
        // System.out.println("meilleur mot = " +
        // map_reponse.get(valeur_moyenne_mots.get(0)));

        // Test mots slane salet crane
        // .
        // .
        // .
        // double valeur = calculMoyenne(possibility, "crane", liste_reponse);
        // System.out.println("valeur moyenne = " + valeur);

        // jouer au jeu avec 10 essais.
        // .
        // .
        // .

        // StringBuilder mot = new StringBuilder("20010");
        // System.out.println(stringToQuintuple(mot).printSequence());

        // System.out.println(compareGuess("fuzzy", "zhuzh"));

        // reponse , guess
        // StringBuilder str = compareGuess("shalt", "slane");
        // System.out.println(str);
        // Quintuple q = stringToQuintuple(str);
        // System.out.println(q.printSequence());
        // donne 01000

        // le faire jouer tout seul
        // .
        // .
        // .

        // System.out.println(calculMoyenne(possibility, "salet", liste_reponse));
        // System.out.println(calculMoyenne(possibility, "crane", liste_reponse));

        // double moyenne = 0;
        // int compteur = 1;
        // long start = System.currentTimeMillis();
        // for (int i = 0; i < 100; i++) {
        // int tour = 1;
        // System.out.println(compteur);
        // compteur++;
        // int indice_aleatoire = (int) (Math.random() * liste_reponse.size());
        // String mot_reponse = liste_reponse.get(indice_aleatoire);
        // String guess = "slane";
        // ArrayList<String> temp_mots = new ArrayList<>(liste_mots);
        // ArrayList<String> temp_reponse = new ArrayList<>(liste_reponse);
        // System.out.println("reponse = " + mot_reponse);
        // while (!mot_reponse.equals(guess)) {
        // System.out.println("guess = " + guess);
        // // System.out.println("hey");
        // ArrayList<Double> valeur_moyenne_mots = new ArrayList<>();
        // HashMap<Double, String> map_reponse = new HashMap<>();
        // temp_mots.remove(guess);
        // // System.out.println(stringToQuintuple(compareGuess(mot_reponse,
        // // guess)).printSequence());
        // temp_reponse = retireMot(stringToQuintuple(compareGuess(mot_reponse, guess)),
        // guess, temp_reponse);
        // // for (String s : temp_reponse) {
        // // System.out.print(s + " ");
        // // }
        // // System.out.println(temp_reponse.size());

        // for (int j = 0; j < temp_mots.size(); j++) {
        // double valeur = calculMoyenne(possibility, temp_mots.get(j), temp_reponse);
        // valeur_moyenne_mots.add(valeur);
        // map_reponse.put(valeur, temp_mots.get(j));
        // }
        // // System.out.println("YO FIANL");
        // Collections.sort(valeur_moyenne_mots, Collections.reverseOrder());
        // guess = map_reponse.get(valeur_moyenne_mots.get(0));
        // tour++;
        // }
        // // System.out.println("reponse = " + mot_reponse);
        // // System.out.println("guess = " + guess);
        // moyenne += tour;
        // }
        // moyenne /= 100;
        // long finish = System.currentTimeMillis();
        // long time = finish - start;
        // System.out.println("temps ecoule " + time);
        // System.out.println("en moyenne je trouve le bon resultat en " + moyenne + "
        // essais");

        // String mot_reponse = "shalt";
        // String guess = "slane";
        // ArrayList<String> temp_mots = new ArrayList<>(liste_mots);
        // ArrayList<String> temp_reponse = new ArrayList<>(liste_reponse);
        // System.out.println("reponse = " + mot_reponse);
        // int tour = 1;
        // while (!mot_reponse.equals(guess)) {
        // System.out.println("guess = " + guess);
        // // System.out.println("hey");
        // ArrayList<Double> valeur_moyenne_mots = new ArrayList<>();
        // HashMap<Double, String> map_reponse = new HashMap<>();
        // temp_mots.remove(guess);
        // System.out.println(stringToQuintuple(compareGuess(mot_reponse,
        // guess)).printSequence());
        // temp_reponse = retireMot(stringToQuintuple(compareGuess(mot_reponse, guess)),
        // guess, temp_reponse);
        // // for (String s : temp_reponse) {
        // // System.out.print(s + " ");
        // // }
        // // System.out.println(temp_reponse.size());

        // for (int j = 0; j < temp_mots.size(); j++) {
        // double valeur = calculMoyenne(possibility, temp_mots.get(j), temp_reponse);
        // valeur_moyenne_mots.add(valeur);
        // map_reponse.put(valeur, temp_mots.get(j));
        // }

        // Collections.sort(valeur_moyenne_mots, Collections.reverseOrder());
        // guess = map_reponse.get(valeur_moyenne_mots.get(0));
        // tour++;
        // }
        // System.out.println("essais = " + tour);
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

    public static StringBuilder compareGuess(String reponse, String guess) {

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
            // char_in_word.remove(g0);
            char_in_word.removeFirstOccurrence(g0);
            // System.out.println("A");
        }
        if (g1 == r1) {
            str.setCharAt(1, '2');
            // char_in_word.remove(g1);
            char_in_word.removeFirstOccurrence(g1);
            // System.out.println("B");
        }
        if (g2 == r2) {
            str.setCharAt(2, '2');
            // char_in_word.remove(g2);
            char_in_word.removeFirstOccurrence(g2);
            // System.out.println("C");
        }
        if (g3 == r3) {
            str.setCharAt(3, '2');
            // char_in_word.remove(g3);
            char_in_word.removeFirstOccurrence(g3);
            // System.out.println("D");
        }
        if (g4 == r4) {
            str.setCharAt(4, '2');
            // char_in_word.remove(g4);
            char_in_word.removeFirstOccurrence(g4);
            // System.out.println("E");
        }

        // si char present dans le mot
        if (reponse.contains(String.valueOf(g0)) && char_in_word.contains(g0)) {
            str.setCharAt(0, '1');
            char_in_word.removeFirstOccurrence(g0);
            // System.out.println("F");
        }
        if (reponse.contains(String.valueOf(g1)) && char_in_word.contains(g1)) {
            str.setCharAt(1, '1');
            // char_in_word.remove(g1);
            char_in_word.removeFirstOccurrence(g1);
            // System.out.println("G");
        }
        if (reponse.contains(String.valueOf(g2)) && char_in_word.contains(g2)) {
            str.setCharAt(2, '1');
            // char_in_word.remove(g2);
            char_in_word.removeFirstOccurrence(g2);
            // System.out.println("H");
        }
        if (reponse.contains(String.valueOf(g3)) && char_in_word.contains(g3)) {
            str.setCharAt(3, '1');
            // char_in_word.remove(g3);
            char_in_word.removeFirstOccurrence(g3);
            // System.out.println("I");
        }
        if (reponse.contains(String.valueOf(g4)) && char_in_word.contains(g4)) {
            str.setCharAt(4, '1');
            // char_in_word.remove(g4);
            char_in_word.removeFirstOccurrence(g4);
            // System.out.println("J");
        }
        // System.out.println(char_in_word);
        return str;
    }

    // joue pour trouver un mot avec le quintuple donné par l'utilisateur
    public String joue(Quintuple quintuple_rep, String word) {
        // Scanner read_quintuple = new Scanner(System.in);

        // String word = "slane";
        // for (int i = 0; i < 10; i++) {
        ArrayList<Double> valeur_moyenne_mots = new ArrayList<>();
        HashMap<Double, String> map_reponse = new HashMap<>();
        // System.out.println("mots dans la liste entiere = " + liste_mots.size());
        // System.out.println("entrez votre quintuple : ");
        // String input = read_quintuple.nextLine();
        // Quintuple quintuple_rep = new Quintuple(input.charAt(0), input.charAt(1),
        // input.charAt(2), input.charAt(3),
        // input.charAt(4));
        // long start = System.currentTimeMillis();
        this.liste_mots.remove(word);
        this.liste_reponse = retireMot(quintuple_rep, word, this.liste_reponse);
        for (int j = 0; j < this.liste_mots.size(); j++) {
            double valeur = calculMoyenne(this.possibility, this.liste_mots.get(j), this.liste_reponse);
            valeur_moyenne_mots.add(valeur);
            map_reponse.put(valeur, this.liste_mots.get(j));
        }
        // for (String s : this.liste_reponse) {
        // System.out.print(s + " ");
        // }

        Collections.sort(valeur_moyenne_mots, Collections.reverseOrder());

        // long finish = System.currentTimeMillis();
        // long time = finish - start;
        // System.out.println("\n temps ecoule " + time);
        // System.out.println("la liste de mot réponse fait mainteant " +
        // this.liste_reponse.size() + " mots");
        // System.out.println("valeur moyenne = " + valeur_moyenne_mots.get(0));
        word = map_reponse.get(valeur_moyenne_mots.get(0));
        // System.out.println("meilleur mot = " + word);
        // }
        return "meilleur mot = " + word;
    }
}
