import java.util.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class findWord {

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

        String[] mots = liste_reponse.toArray(new String[liste_reponse.size()]);

        while (in2.hasNext()) {
            liste_reponse.add(in2.next());
        }
        String[] reponse = liste_reponse.toArray(new String[liste_reponse.size()]);

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
        // double moyenne = calculMoyenne(possibility, "zebra", liste_reponse);
        // System.out.println("le mot retire en moyenne " + moyenne + " mots.");

        ArrayList<Double> valeur_moyenne_mots = new ArrayList<>();
        System.out.println(liste_reponse.size());
        long start = System.currentTimeMillis();
        // for (String s : liste_reponse) {
        // valeur_moyenne_mots.add(calculMoyenne(possibility, s, liste_reponse));
        // }
        for (int i = 0; i < liste_reponse.size(); i++) {
            valeur_moyenne_mots.add(calculMoyenne(possibility, liste_reponse.get(i), liste_reponse));
        }
        Collections.sort(valeur_moyenne_mots, Collections.reverseOrder());
        long finish = System.currentTimeMillis();
        long time = finish - start;

        System.out.println("temps ecoule " + time);
        System.out.println("valeur moyenne = " + valeur_moyenne_mots.get(0));

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
                    if (!s.contains(String.valueOf(test.charAt(0)))) {
                        temp.remove(s);
                    }
                }
            }
            // indice 1
            if (possibility[i].get1() == '1') {
                for (String s : liste_reponse) {
                    if (!s.contains(String.valueOf(test.charAt(1)))) {
                        temp.remove(s);
                    }
                }
            }
            // indice 2
            if (possibility[i].get2() == '1') {
                for (String s : liste_reponse) {
                    if (!s.contains(String.valueOf(test.charAt(2)))) {
                        temp.remove(s);
                    }
                }
            }
            // indice 3
            if (possibility[i].get3() == '1') {
                for (String s : liste_reponse) {
                    if (!s.contains(String.valueOf(test.charAt(3)))) {
                        temp.remove(s);
                    }
                }
            }
            // indice 4
            if (possibility[i].get4() == '1') {
                for (String s : liste_reponse) {
                    if (!s.contains(String.valueOf(test.charAt(4)))) {
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
}
