package one;

public class OneB {
    public static class Graph {
        private final int[][] adjMatrix;
        private final int vertices;

        // Constructor to initialize the graph with the number of vertices
        public Graph(int vertices) {
            this.vertices = vertices;
            adjMatrix = new int[vertices][vertices];

            // Initialize all entries to 0 (no edge)
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    adjMatrix[i][j] = 0;
                }
            }
        }

        // Method to add an edge with a specified weight
        public void addEdge(int u, int v, int weight) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex!");
                return;
            }
            // Since the graph is undirected, set the weight in both [u][v] and [v][u]
            adjMatrix[u][v] = weight;
            adjMatrix[v][u] = weight;
        }

        // Method to remove an edge
        public void removeEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex!");
                return;
            }
            adjMatrix[u][v] = 0;
            adjMatrix[v][u] = 0;
        }

        // Method to display the adjacency matrix
        public void displayGraph() {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Main method for testing the Graph class
        public static void main(String[] args) {
            Graph g = new Graph(5); // Create a graph with 5 vertices

            // Adding edges
            g.addEdge(0, 1, 10);  // Edge between vertex 0 and vertex 1 with weight 10
            g.addEdge(0, 4, 5);   // Edge between vertex 0 and vertex 4 with weight 5
            g.addEdge(1, 2, 3);   // Edge between vertex 1 and vertex 2 with weight 3
            g.addEdge(1, 3, 2);   // Edge between vertex 1 and vertex 3 with weight 2
            g.addEdge(3, 4, 8);   // Edge between vertex 3 and vertex 4 with weight 8

            // Display the graph
            System.out.println("Graph Adjacency Matrix:");
            g.displayGraph();

            // Removing an edge
            g.removeEdge(1, 3);  // Remove edge between vertex 1 and vertex 3

            // Display the graph after removing an edge
            System.out.println("\nGraph Adjacency Matrix after removing edge (1,3):");
            g.displayGraph();
        }
    }

}
