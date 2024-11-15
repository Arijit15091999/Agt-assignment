package Three;
import java.util.*;

public class ThreeA {

    public static class UndirectedUnweightedGraph {
        private final Map<Integer, List<Integer>> adjacencyList; // Stores the adjacency list
        private final int vertices;

        // Constructor to initialize the graph with the number of vertices
        public UndirectedUnweightedGraph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new HashMap<>();

            // Initialize the adjacency list for each vertex
            for (int i = 0; i < vertices; i++) {
                adjacencyList.put(i, new LinkedList<>());
            }
        }

        // Method to add an edge between vertex u and vertex v
        public void addEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex number!");
                return;
            }

            // Add edge u-v and v-u (since the graph is undirected)
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // Method to remove an edge between vertex u and vertex v
        public void removeEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex number!");
                return;
            }

            // Remove edge u-v and v-u (since the graph is undirected)
            adjacencyList.get(u).remove(Integer.valueOf(v));
            adjacencyList.get(v).remove(Integer.valueOf(u));
        }

        // Method to display the graph
        public void displayGraph() {
            System.out.println("Adjacency List (Undirected Unweighted Graph):");
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + ": ");
                for (Integer adj : adjacencyList.get(i)) {
                    System.out.print(adj + " ");
                }
                System.out.println();
            }
        }

        // Main method for testing the UndirectedUnweightedGraph class
        public static void main(String[] args) {
            UndirectedUnweightedGraph g = new UndirectedUnweightedGraph(5); // Create a graph with 5 vertices

            // Adding edges
            g.addEdge(0, 1);  // Edge between vertex 0 and vertex 1
            g.addEdge(0, 4);  // Edge between vertex 0 and vertex 4
            g.addEdge(1, 2);  // Edge between vertex 1 and vertex 2
            g.addEdge(1, 3);  // Edge between vertex 1 and vertex 3
            g.addEdge(3, 4);  // Edge between vertex 3 and vertex 4

            // Display the graph
            g.displayGraph();

            // Removing an edge
            g.removeEdge(1, 3);  // Remove edge between vertex 1 and vertex 3

            // Display the graph after removing an edge
            System.out.println("\nAfter removing edge (1, 3):");
            g.displayGraph();
        }
    }

}
