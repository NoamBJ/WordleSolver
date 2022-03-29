import java.util.*;

/**
 * \class SimpleGraph
 * \description : définit les structures de données utiles pour manipuler des
 * graphes
 * les noeuds y sont représentés par des numeros, et chaque numéro peut-être
 * associés à une chaîne de caractères
 */
class SimpleGraph {

    // <! matrice d'adjacence, associant à tout noeud un tableau booléen
    // correspondant aux arcs vers d'autres noeuds
    private int[][] edges;

    // <! tableau associant à chaque numéro de noeud une chaîne de caractère
    // représentant par exemple le nom du noeud.
    private String[] names;

    // <! entier représentant le nombre de noeuds du graphe
    private int vertices = 0;

    /**
     * \fn constructeur de graphes
     * \param int[][] edges : matrice d'ajacence NxN, où N est le nombre de noeuds
     * du graphe,
     * et où chaque cellule prend une valeur booléenne: 1 si les noeuds
     * correspondants sont reliés par un arc; 0 sinon.
     * \param String[] names : tableau des noms des noeuds.
     * \return SimpleGraph
     */
    public SimpleGraph(int[][] edges, String[] names) {
        this.edges = edges;
        this.names = names;
        this.vertices = names.length;
    }

    /**
     * \fn constructeur de graphes à partir uniquement du nombre de noeuds, les
     * autres informations doivent être complétées
     * par la suite en faisant appel aux méthodes de SimpleGraph.
     * \param int vertices : définit le nombre de noeuds dans le graphe.
     * \return SimpleGraph
     */
    public SimpleGraph(int vertices) {
        this.vertices = vertices;
        this.edges = new int[vertices][vertices];
        this.names = new String[vertices];
        for (int i = 0; i < vertices; ++i) {
            this.names[i] = "" + i + "";
        }
    }

    /**
     * \fn int[] getNeighbors(int vertex)
     * \description: retourne le tableau de booléens, correspondant au voisinage du
     * noeud "vertex" en entrée
     * \param int vertex : noeud donné
     * \return int[] : tableau de voisins du noeud "vertex"
     */
    public int[] getNeighbors(int vertex) {
        return this.edges[vertex];
    }

    /**
     * \fn void addNeighbor(int source, int destination)
     * \description: crée un arc entre le noeud "source" et le noeud "destination"
     * \param int source : noeud source
     * \param int destination : noeud destination
     */
    public void addNeighbor(int source, int destination) {
        this.edges[source][destination] = 1;
        this.edges[destination][source] = 1;
    }

    /**
     * \fn String toString()
     * \description : retourne une chaîne de caractères décrivant le graphe.
     * \return String: chaîne de caractères
     */
    @Override
    public String toString() {
        String show = "<graph vertices=\"" + this.vertices + "\">\n";
        for (int i = 0; i < this.vertices; ++i)
            for (int j = 0; j < vertices; ++j) {
                if (edges[i][j] == 1) {
                    show += "\t<arc source=\"" + this.names[i] + "\" destination=\"" + this.names[j] + "\">\n";
                }
            }
        show += "</graph>";
        return show;
    }

    public static void main(String[] args) {
        int[][] edges = new int[5][5];
        String[] names = { "A", "B", "C", "D", "E" };
        SimpleGraph graph = new SimpleGraph(edges, names);
        graph.addNeighbor(0, 1);
        graph.addNeighbor(2, 3);
        graph.addNeighbor(4, 2);
        graph.addNeighbor(2, 0);
        graph.addNeighbor(3, 1);
        graph.addNeighbor(1, 4);

        System.out.println(graph.toString());
    }
}
