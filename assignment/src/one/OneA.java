package one;

import java.util.Scanner;

public class OneA {

    public static class Graph {
        private final int[][] adjMatrix;
        private final int numVertices;

        // Constructor to initialize the graph
        public Graph(int numVertices) {
            this.numVertices = numVertices;
            adjMatrix = new int[numVertices][numVertices];
        }

        // Method to add an edge
        public void addEdge(int u, int v) {
            if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1; // Since the graph is undirected
            } else {
                System.out.println("Error: Vertex out of bounds.");
            }
        }

        // Method to remove an edge
        public void removeEdge(int u, int v) {
            if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
                adjMatrix[u][v] = 0;
                adjMatrix[v][u] = 0; // Since the graph is undirected
            } else {
                System.out.println("Error: Vertex out of bounds.");
            }
        }

        // Method to display the adjacency matrix
        public void display() {
            System.out.println("Adjacency Matrix:");
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Method to check if there is an edge
        public boolean hasEdge(int u, int v) {
            if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
                return adjMatrix[u][v] == 1;
            } else {
                System.out.println("Error: Vertex out of bounds.");
            }
            return false;
        }

        // Main method for testing
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of vertices: ");
            int numVertices = scanner.nextInt();

            Graph graph = new Graph(numVertices);

            graph.addEdge(0, 1);
            graph.addEdge(0, 4);
            graph.addEdge(1, 2);
            graph.addEdge(1, 3);
            graph.addEdge(1, 4);
            graph.addEdge(2, 3);

            graph.display();

            System.out.println("Edge between 0 and 1: " + graph.hasEdge(0, 1));
            System.out.println("Edge between 2 and 4: " + graph.hasEdge(2, 4));

            graph.removeEdge(1, 4);
            graph.display();

            scanner.close();
        }
    }

}
