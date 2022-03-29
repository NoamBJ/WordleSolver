import java.util.*;

import com.tree.TreeNode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class findWord {

    public static void main(String[] args) throws FileNotFoundException {
        final int nb_mots = 12972;
        File file = new File("wordListOrdered.txt");

        Scanner in = new Scanner(file);

        ArrayList<String> liste = new ArrayList<String>();
        while (in.hasNext()) {
            liste.add(in.next());
        }
        String[] mots = liste.toArray(new String[liste.size()]);

        TreeNode<String> tree = new TreeNode<String>("root");
        TreeNode<String> node0 = tree.addChild("node0");
        TreeNode<String> node1 = tree.addChild("node1");

        System.out.println(tree.toString());
        System.out.println(node0.toString());

    }
}
