package one;

public class OneC {
    public static class DirectedGraph {
        private final int[][] adjMatrix;
        private final int vertices;

        // Constructor to initialize the graph with the number of vertices
        public DirectedGraph(int vertices) {
            this.vertices = vertices;
            adjMatrix = new int[vertices][vertices];

            // Initialize all entries to 0 (no edge)
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    adjMatrix[i][j] = 0;
                }
            }
        }

        // Method to add a directed edge from vertex u to vertex v
        public void addEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertex!");
                return;
            }
            // Set the matrix entry to 1 for directed edge from u to v
            adjMatrix[u][v] = 1;
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
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Main method for testing the DirectedGraph class
        public static void main(String[] args) {
            DirectedGraph g = new DirectedGraph(5); // Create a graph with 5 vertices

            // Adding directed edges
            g.addEdge(0, 1);  // Edge from vertex 0 to vertex 1
            g.addEdge(0, 4);  // Edge from vertex 0 to vertex 4
            g.addEdge(1, 2);  // Edge from vertex 1 to vertex 2
            g.addEdge(1, 3);  // Edge from vertex 1 to vertex 3
            g.addEdge(3, 4);  // Edge from vertex 3 to vertex 4

            // Display the graph
            System.out.println("Directed Graph Adjacency Matrix:");
            g.displayGraph();

            // Removing a directed edge
            g.removeEdge(1, 3);  // Remove edge from vertex 1 to vertex 3

            // Display the graph after removing an edge
            System.out.println("\nDirected Graph Adjacency Matrix after removing edge (1 -> 3):");
            g.displayGraph();
        }
    }

}
