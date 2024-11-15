package Three;
import java.util.*;

public class ThreeD {

    public static class DirectedWeightedGraph {
        // Using a Map to represent adjacency list where each vertex points to a list of Edge objects
        private Map<Integer, List<Edge>> adjacencyList;
        private int vertices;

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
        public DirectedWeightedGraph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new HashMap<>();

            // Initialize the adjacency list for each vertex
            for (int i = 0; i < vertices; i++) {
                adjacencyList.put(i, new LinkedList<>());
            }
        }

        // Method to add a directed edge from vertex u to vertex v with weight w
        public void addEdge(int u, int v, int weight) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex number!");
                return;
            }

            // Add the directed edge u -> v with weight w
            adjacencyList.get(u).add(new Edge(v, weight));
        }

        // Method to remove a directed edge from vertex u to vertex v
        public void removeEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex number!");
                return;
            }

            // Remove the directed edge u -> v
            adjacencyList.get(u).removeIf(edge -> edge.vertex == v);
        }

        // Method to display the graph
        public void displayGraph() {
            System.out.println("Adjacency List (Directed Weighted Graph):");
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + ": ");
                for (Edge edge : adjacencyList.get(i)) {
                    System.out.print("(" + edge.vertex + ", " + edge.weight + ") ");
                }
                System.out.println();
            }
        }

        // Main method for testing the DirectedWeightedGraph class
        public static void main(String[] args) {
            DirectedWeightedGraph g = new DirectedWeightedGraph(5); // Create a graph with 5 vertices

            // Adding directed edges with weights
            g.addEdge(0, 1, 10);  // Edge from vertex 0 to vertex 1 with weight 10
            g.addEdge(0, 4, 5);   // Edge from vertex 0 to vertex 4 with weight 5
            g.addEdge(1, 2, 3);   // Edge from vertex 1 to vertex 2 with weight 3
            g.addEdge(1, 3, 2);   // Edge from vertex 1 to vertex 3 with weight 2
            g.addEdge(3, 4, 8);   // Edge from vertex 3 to vertex 4 with weight 8

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
