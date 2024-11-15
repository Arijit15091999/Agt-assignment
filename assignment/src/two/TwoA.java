package two;

public class TwoA {
    public static class UndirectedUnweightedGraph {
        private final int[][] incidenceMatrix;
        private final int vertices;
        private int edges;

        // Constructor to initialize the graph with the number of vertices
        public UndirectedUnweightedGraph(int vertices) {
            this.vertices = vertices;
            this.edges = 0;  // Initially, no edges are added
            incidenceMatrix = new int[vertices][100];  // Start with 100 edges capacity
        }

        public UndirectedUnweightedGraph(int vertices, int edges) {
            this.incidenceMatrix = new int[vertices][edges];
            this.vertices = vertices;
            this.edges = edges;
        }

        // Method to add an edge between vertices u and v
        public void addEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0 || u == v) {
                System.out.println("Invalid vertices or self-loop not allowed!");
                return;
            }

            // Add the edge by incrementing the edge count
            incidenceMatrix[u][edges] = 1;
            incidenceMatrix[v][edges] = 1;
            edges++;
        }

        // Method to remove an edge between vertices u and v
        public void removeEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertices!");
                return;
            }

            // Find the edge in the matrix and remove it by setting the respective entries to 0
            for (int i = 0; i < edges; i++) {
                if (incidenceMatrix[u][i] == 1 && incidenceMatrix[v][i] == 1) {
                    incidenceMatrix[u][i] = 0;
                    incidenceMatrix[v][i] = 0;
                    break;
                }
            }
        }

        // Method to display the incidence matrix
        public void displayGraph() {
            System.out.println("Incidence Matrix:");
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < edges; j++) {
                    System.out.print(incidenceMatrix[i][j] + " ");
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
            System.out.println("\nAfter removing edge (1,3):");
            g.displayGraph();
        }
    }

}
