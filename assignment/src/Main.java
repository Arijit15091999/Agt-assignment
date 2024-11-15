import Four.Edge;
import Four.EdgeDiffDfs;
import java.util.*;

public class Main {
//    public static void main(String[] args) {
//        EdgeDiffDfs graph = new EdgeDiffDfs(5);  // Create a graph with 5 vertices
//
//        // Add directed edges
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 4);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(3, 4);
//
//        // Classify edges
//        Map<String, Set<Edge>> result = graph.classifyEdges(0);
//
//        // Display classified edges
//        System.out.println("Tree Edges:");
//        result.get("Tree Edge Set").forEach(System.out::println);
//
//        System.out.println("\nForward Edges:");
//        result.get("Forward Edge Set").forEach(System.out::println);
//
//        System.out.println("\nBack Edges:");
//        result.get("Back Edge Set").forEach(System.out::println);
//    }

    public static void main(String[] args) {
        // Create an undirected graph
        int vertices = 6; // Total vertices in the graph
        EdgeDiffDfs graph = new EdgeDiffDfs(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 5);

        // Start DFS traversal from vertex 0
        Map<String, Set<Edge>> edgeClassification = graph.classifyEdges(0);

        // Print out the classified edges
        System.out.println("Tree Edges:");
        for (Edge edge : edgeClassification.get("Tree Edge Set")) {
            System.out.println(edge);
        }

        System.out.println("\nForward Edges:");
        for (Edge edge : edgeClassification.get("Forward Edge Set")) {
            System.out.println(edge);
        }

        System.out.println("\nBack Edges:");
        for (Edge edge : edgeClassification.get("Back Edge Set")) {
            System.out.println(edge);
        }
    }

}