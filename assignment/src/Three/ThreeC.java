package Three;
import java.util.*;

public class ThreeC {

    public static class DirectedUnweightedGraph {
        private Map<Integer, List<Integer>> adjacencyList;
        private int vertices;

        // Constructor to initialize the graph with the number of vertices
        public DirectedUnweightedGraph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new HashMap<>();

            // Initialize the adjacency list for each vertex
            for (int i = 0; i < vertices; i++) {
                adjacencyList.put(i, new LinkedList<>());
            }
        }

        // Method to add a directed edge from vertex u to vertex v
        public void addEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex number!");
                return;
            }

            // Add edge u -> v (directed edge)
            adjacencyList.get(u).add(v);
        }

        // Method to remove a directed edge from vertex u to vertex v
        public void removeEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex number!");
                return;
            }

            // Remove edge u -> v (directed edge)
            adjacencyList.get(u).remove(Integer.valueOf(v));
        }

        // Method to display the graph
        public void displayGraph() {
            System.out.println("Adjacency List (Directed Unweighted Graph):");
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + ": ");
                for (Integer adj : adjacencyList.get(i)) {
                    System.out.print(adj + " ");
                }
                System.out.println();
            }
        }

        // Main method for testing the DirectedUnweightedGraph class
        public static void main(String[] args) {
            DirectedUnweightedGraph g = new DirectedUnweightedGraph(5); // Create a graph with 5 vertices

            // Adding directed edges
            g.addEdge(0, 1);  // Edge from vertex 0 to vertex 1
            g.addEdge(0, 4);  // Edge from vertex 0 to vertex 4
            g.addEdge(1, 2);  // Edge from vertex 1 to vertex 2
            g.addEdge(1, 3);  // Edge from vertex 1 to vertex 3
            g.addEdge(3, 4);  // Edge from vertex 3 to vertex 4

            // Display the graph
            g.displayGraph();

            // Removing an edge
            g.removeEdge(1, 3);  // Remove directed edge from vertex 1 to vertex 3

            // Display the graph after removing an edge
            System.out.println("\nAfter removing edge (1, 3):");
            g.displayGraph();
        }
    }

}
