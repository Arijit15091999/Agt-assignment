package one;

public class OneD {
    public static class DirectedWeightedGraph {
        private final int[][] adjMatrix;
        private final int vertices;

        // Constructor to initialize the graph with the number of vertices
        public DirectedWeightedGraph(int vertices) {
            this.vertices = vertices;
            adjMatrix = new int[vertices][vertices];

            // Initialize all entries to 0 (no edge)
            // You can also use Integer.MAX_VALUE to represent infinity for no edges if desired.
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    adjMatrix[i][j] = 0;
                }
            }
        }

        // Method to add a directed edge from vertex u to vertex v with a given weight
        public void addEdge(int u, int v, int weight) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex!");
                return;
            }
            // Set the matrix entry to the weight for directed edge from u to v
            adjMatrix[u][v] = weight;
        }

        // Method to remove a directed edge from vertex u to vertex v
        public void removeEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex!");
                return;
            }
            // Set the matrix entry to 0 to remove the edge
            adjMatrix[u][v] = 0;
        }

        // Method to display the adjacency matrix
        public void displayGraph() {
            System.out.println("Adjacency Matrix (Directed Weighted Graph):");
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
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

            // Removing a directed edge
            g.removeEdge(1, 3);  // Remove edge from vertex 1 to vertex 3

            // Display the graph after removing an edge
            System.out.println("\nDirected Weighted Graph after removing edge (1 -> 3):");
            g.displayGraph();
        }
    }

}
