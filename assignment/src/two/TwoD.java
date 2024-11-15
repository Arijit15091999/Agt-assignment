package two;

public class TwoD {
    public static class DirectedWeightedGraph {
        private int[][] incidenceMatrix;
        private int vertices;
        private int edges;

        // Constructor to initialize the graph with the number of vertices
        public DirectedWeightedGraph(int vertices) {
            this.vertices = vertices;
            this.edges = 0;  // Initially, no edges are added
            incidenceMatrix = new int[vertices][100];  // Start with 100 edges capacity
        }

        public DirectedWeightedGraph(int vertices, int edges) {
            this.vertices = vertices;
            this.edges = edges;
            incidenceMatrix = new int[vertices][edges];
        }

        // Method to add a directed edge from vertex u to vertex v with weight w
        public void addEdge(int u, int v, int weight) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0 || u == v) {
                System.out.println("Invalid vertices or self-loop not allowed!");
                return;
            }

            // Add the edge by incrementing the edge count and setting the weight
            incidenceMatrix[u][edges] = -weight;  // Outgoing edge from u with weight
            incidenceMatrix[v][edges] = weight;   // Incoming edge to v with weight
            edges++;
        }

        // Method to remove a directed edge from vertex u to vertex v
        public void removeEdge(int u, int v) {
            if (u >= vertices || v >= vertices || u < 0 || v < 0) {
                System.out.println("Invalid vertices!");
                return;
            }

            // Find the edge in the matrix and remove it by setting the respective entries to 0
            for (int i = 0; i < edges; i++) {
                if (incidenceMatrix[u][i] < 0 && incidenceMatrix[v][i] > 0) {
                    incidenceMatrix[u][i] = 0;
                    incidenceMatrix[v][i] = 0;
                    break;
                }
            }
        }

        // Method to display the incidence matrix
        public void displayGraph() {
            System.out.println("Incidence Matrix (Directed Weighted Graph):");
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < edges; j++) {
                    System.out.print(incidenceMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Main method for testing the DirectedWeightedGraph class
        public static void main(String[] args) {
            DirectedWeightedGraph g = new DirectedWeightedGraph(5); // Create a graph with 5 vertices

            // Adding edges with weights (directed edges)
            g.addEdge(0, 1, 10);  // Directed edge from vertex 0 to vertex 1 with weight 10
            g.addEdge(0, 4, 5);   // Directed edge from vertex 0 to vertex 4 with weight 5
            g.addEdge(1, 2, 3);   // Directed edge from vertex 1 to vertex 2 with weight 3
            g.addEdge(1, 3, 2);   // Directed edge from vertex 1 to vertex 3 with weight 2
            g.addEdge(3, 4, 8);   // Directed edge from vertex 3 to vertex 4 with weight 8

            // Display the graph
            g.displayGraph();

            // Removing an edge
            g.removeEdge(1, 3);  // Remove directed edge from vertex 1 to vertex 3

            // Display the graph after removing an edge
            System.out.println("\nAfter removing edge (1,3):");
            g.displayGraph();
        }
    }

}
