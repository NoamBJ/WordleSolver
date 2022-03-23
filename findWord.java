import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class findWord {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("wordListOrdered.txt");

        Scanner in = new Scanner(file);

        ArrayList<String> liste = new ArrayList<String>();
        while (in.hasNext()) {
            liste.add(in.next());
        }
        String[] mots = liste.toArray(new String[liste.size()]);
        for (String s : mots) {
            System.out.print(s);
        }
    }
}
