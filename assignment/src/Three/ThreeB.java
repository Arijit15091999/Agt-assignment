package Three;
import java.util.*;

public class ThreeB {

    public static class UndirectedWeightedGraph {
        // Using a Map to represent adjacency list, where the key is a vertex and the value is a List of pairs (adjacent vertex and weight)
        private final Map<Integer, List<Edge>> adjacencyList;
        private final int vertices;

        // Inner class to represent an edge with weight
        private class Edge {
            int vertex;
            int weight;

            public Edge(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }
        }

        // Constructor to initialize the graph with the number of vertices
        public UndirectedWeightedGraph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new HashMap<>();

            // Initialize the adjacency list for each vertex
            for (int i = 0; i < vertices; i++) {
                adjacencyList.put(i, new LinkedList<>());
            }
        }

        // Method to add an edge between vertex u and vertex v with weight w
        public void addEdge(int u, int v, int weight) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex number!");
                return;
            }

            // Add edge u-v with weight w and v-u with weight w (since the graph is undirected)
            adjacencyList.get(u).add(new Edge(v, weight));
            adjacencyList.get(v).add(new Edge(u, weight));
        }

        // Method to remove an edge between vertex u and vertex v
        public void removeEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex number!");
                return;
            }

            // Remove edge u-v and v-u (since the graph is undirected)
            adjacencyList.get(u).removeIf(edge -> edge.vertex == v);
            adjacencyList.get(v).removeIf(edge -> edge.vertex == u);
        }

        // Method to display the graph
        public void displayGraph() {
            System.out.println("Adjacency List (Undirected Weighted Graph):");
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + ": ");
                for (Edge edge : adjacencyList.get(i)) {
                    System.out.print("(" + edge.vertex + ", " + edge.weight + ") ");
                }
                System.out.println();
            }
        }

        // Main method for testing the UndirectedWeightedGraph class
        public static void main(String[] args) {
            UndirectedWeightedGraph g = new UndirectedWeightedGraph(5); // Create a graph with 5 vertices

            // Adding edges with weights
            g.addEdge(0, 1, 10);  // Edge between vertex 0 and vertex 1 with weight 10
            g.addEdge(0, 4, 5);   // Edge between vertex 0 and vertex 4 with weight 5
            g.addEdge(1, 2, 3);   // Edge between vertex 1 and vertex 2 with weight 3
            g.addEdge(1, 3, 2);   // Edge between vertex 1 and vertex 3 with weight 2
            g.addEdge(3, 4, 8);   // Edge between vertex 3 and vertex 4 with weight 8

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
