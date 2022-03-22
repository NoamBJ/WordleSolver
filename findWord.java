import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class findWord {

    public static void main(String[] args) throws Exception {

        // reading text file into List in Java 7
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get("wordListOrdered.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
