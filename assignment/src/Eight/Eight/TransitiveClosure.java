package Eight;
import java.util.Arrays;

public class TransitiveClosure {
    // Function to compute the transitive closure using Floyd-Warshall
    public static void computeTransitiveClosure(int[][] graph) {
        int n = graph.length;

        // Using Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = graph[i][j] | (graph[i][k] & graph[k][j]);
                }
            }
        }
    }

    // Utility function to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Example graph as an adjacency matrix
        int[][] graph = {
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
        };

        System.out.println("Original Graph:");
        printMatrix(graph);

        computeTransitiveClosure(graph);

        System.out.println("\nTransitive Closure:");
        printMatrix(graph);
    }
}
