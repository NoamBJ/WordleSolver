// Java code to demonstrate Graph representation
// using ArrayList in Java

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

class Graph {

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer>> adj,
            int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(ArrayList<ArrayList<Integer>> adj, String[] mots) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(mots[i]);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "
                        + mots[adj.get(i).get(j)]);
            }
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) throws FileNotFoundException {

        final int nb_mots = 12972;
        File file = new File("wordListOrdered.txt");

        Scanner in = new Scanner(file);

        ArrayList<String> liste = new ArrayList<String>();
        while (in.hasNext()) {
            liste.add(in.next());
        }
        String[] mots = liste.toArray(new String[liste.size()]);
        // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(nb_mots);

        for (int i = 0; i < nb_mots; i++) {
            adj.add(new ArrayList<Integer>());
            for (int j = 0; j < nb_mots; j++) {
                if (i != j) {
                    addEdge(adj, i, j);
                }
            }
        }

        // Adding edges one by one

        printGraph(adj, mots);
    }
}