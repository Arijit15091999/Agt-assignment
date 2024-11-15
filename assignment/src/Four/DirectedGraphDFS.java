package Four;
import java.util.*;

public class DirectedGraphDFS {
    private Map<Integer, List<Integer>> adjacencyList;
    private Set<Integer> visited;
    private Map<Integer, Integer> parent; // To store the parent of each vertex in the DFS tree

    public DirectedGraphDFS(int vertices) {
        adjacencyList = new HashMap<>();
        visited = new HashSet<>();
        parent = new HashMap<>();

        // Initialize the adjacency list for each vertex
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    // Method to add a directed edge between vertex u and vertex v
    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v); // Only u -> v since the graph is directed
    }

    // DFS function to traverse the graph and build the DFS tree
    public void dfs(int vertex) {
        visited.add(vertex);

        // Explore all adjacent vertices
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                parent.put(neighbor, vertex); // Set parent of the neighbor
                dfs(neighbor); // Recursively visit the neighbor
            }
        }
    }

    // Method to display the DFS tree
    public void displayDFSTree(int startVertex) {
        dfs(startVertex);

        System.out.println("DFS Tree starting from vertex " + startVertex + ":");
        for (int vertex : parent.keySet()) {
            System.out.println("Vertex " + vertex + " -> Parent " + parent.get(vertex));
        }
    }

    // Method to display the adjacency list of the graph
    public void displayGraph() {
        System.out.println("Adjacency List (Directed Graph):");
        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + ": ");
            for (Integer adj : adjacencyList.get(vertex)) {
                System.out.print(adj + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DirectedGraphDFS graph = new DirectedGraphDFS(5); // Create a graph with 5 vertices

        // Add directed edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        // Display the graph
        graph.displayGraph();

        // Display the DFS tree starting from vertex 0
        graph.displayDFSTree(0);
    }
}
