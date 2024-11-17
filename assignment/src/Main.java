import Four.EdgeDiffForDirectedGraph;
import Four.EdgeDiffForUndirectedGraphs;
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

//    public static void main(String[] args) {
//        // Create an undirected graph
//        int vertices = 6; // Total vertices in the graph
//        EdgeDiffForUndirectedGraphs graph = new EdgeDiffForUndirectedGraphs(vertices);
//
//        // Add edges to the graph
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 4);
//        graph.addEdge(1, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(4, 2);
//        graph.addEdge(2, 5);
//
//        // Start DFS traversal from vertex 0
//        Map<String, Set<int[]>> edgeClassification = graph.classifyEdges(0);
//
//        // Print out the classified edges
//        System.out.println("Tree Edges:");
//        for (int[] edge : edgeClassification.get("Tree Edge Set")) {
//            System.out.println(Arrays.toString(edge));
//        }
//
//        System.out.println("\nForward Edges:");
//        for (int[] edge : edgeClassification.get("Forward Edge Set")) {
//            System.out.println(Arrays.toString(edge));
//
//        }
//
//        System.out.println("\nBack Edges:");
//        for (int[] edge : edgeClassification.get("Back Edge Set")) {
//            System.out.println(Arrays.toString(edge));
//
//        }
//
//        System.out.println("\nCross Edges:");
//        for (int[] edge : edgeClassification.get("Cross Edge Set")) {
//            System.out.println(Arrays.toString(edge));
//
//        }
//    }

//    public static void main(String[] args) {
//        // Create an undirected graph with 6 vertices
//        int vertices = 6; // Total vertices in the graph
//        EdgeDiffForDirectedGraph graph = new EdgeDiffForDirectedGraph(vertices);
//
//        // Add edges to the graph
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 4);
//        graph.addEdge(1, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(4, 2);
//        graph.addEdge(2, 5);
//
//        // Start DFS traversal from vertex 0
//        Map<String, Set<int[]>> edgeClassification = graph.classifyEdges(0);
//
//        // Print the classified edges
//        System.out.println("Tree Edges:");
//        for (int[] edge : edgeClassification.get("Tree Edge Set")) {
//            System.out.println(Arrays.toString(edge));
//        }
//
//        System.out.println("\nBack Edges:");
//        for (int[] edge : edgeClassification.get("Back Edge Set")) {
//            System.out.println(Arrays.toString(edge));
//        }
//
//        // If additional edge types are classified, print them
//        if (edgeClassification.containsKey("Forward Edge Set")) {
//            System.out.println("\nForward Edges:");
//            for (int[] edge : edgeClassification.get("Forward Edge Set")) {
//                System.out.println(Arrays.toString(edge));
//            }
//        }
//
//        if (edgeClassification.containsKey("Cross Edge Set")) {
//            System.out.println("\nCross Edges:");
//            for (int[] edge : edgeClassification.get("Cross Edge Set")) {
//                System.out.println(Arrays.toString(edge));
//            }
//        }
//    }

    public static void main(String[] args) {
        // Create a directed graph with 6 vertices
        int vertices = 6;
        EdgeDiffForDirectedGraph graph = new EdgeDiffForDirectedGraph(vertices);

        // Add directed edges to create all edge types
        /*
         * Graph Structure (Directed):
         * 0 → 1 → 2
         * ↑    ↘  ↓
         * |     3 → 4
         * +-------->5
         */
        graph.addEdge(0, 1); // Tree edge
        graph.addEdge(1, 2); // Tree edge
        graph.addEdge(1, 3); // Tree edge
        graph.addEdge(3, 4); // Tree edge
        graph.addEdge(2, 5); // Tree edge
        graph.addEdge(4, 5); // Forward edge
        graph.addEdge(5, 0); // Back edge
        graph.addEdge(3, 0); // Back edge
        graph.addEdge(0, 2); // Cross edge

        // Start DFS traversal from vertex 0
        Map<String, Set<int[]>> edgeClassification = graph.classifyEdges();

        // Print the classified edges
        System.out.println("Tree Edges:");
        for (int[] edge : edgeClassification.get("Tree Edge Set")) {
            System.out.println(Arrays.toString(edge));
        }

        System.out.println("\nForward Edges:");
        for (int[] edge : edgeClassification.get("Forward Edge Set")) {
            System.out.println(Arrays.toString(edge));
        }

        System.out.println("\nBack Edges:");
        for (int[] edge : edgeClassification.get("Back Edge Set")) {
            System.out.println(Arrays.toString(edge));
        }

        System.out.println("\nCross Edges:");
        for (int[] edge : edgeClassification.get("Cross Edge Set")) {
            System.out.println(Arrays.toString(edge));
        }
    }



}