package Ten;

import java.util.*;

public class BiconnectedComponents {
    private int time = 0; // Timer to track discovery times
    private List<List<String>> bccs = new ArrayList<>(); // List to store BCCs
    private Stack<String> stack = new Stack<>(); // Stack to store edges of the current component

    // Function to perform DFS and find BCCs
    private void dfs(String u, Map<String, List<String>> graph, Map<String, Integer> disc,
                     Map<String, Integer> low, Map<String, String> parent) {
        // Initialize discovery and low values
        disc.put(u, time);
        low.put(u, time);
        time++;
        int children = 0; // Count children in DFS tree

        for (String v : graph.get(u)) {
            // If v is not visited
            if (!disc.containsKey(v)) {
                children++;
                parent.put(v, u);
                stack.push(u + "-" + v); // Push edge to the stack

                // Recursive DFS call
                dfs(v, graph, disc, low, parent);

                // Update low value of u based on v
                low.put(u, Math.min(low.get(u), low.get(v)));

                // If u is an articulation point, pop all edges of the BCC
                if ((parent.get(u) == null && children > 1) ||
                    (parent.get(u) != null && low.get(v) >= disc.get(u))) {
                    List<String> bcc = new ArrayList<>();
                    String edge;
                    do {
                        edge = stack.pop();
                        bcc.add(edge);
                    } while (!edge.equals(u + "-" + v));
                    bccs.add(bcc);
                }
            } else if (!v.equals(parent.get(u))) {
                // Back edge case
                low.put(u, Math.min(low.get(u), disc.get(v)));
                if (disc.get(v) < disc.get(u)) {
                    stack.push(u + "-" + v); // Push back edge to stack
                }
            }
        }
    }

    // Main function to find BCCs
    public List<List<String>> findBCCs(Map<String, List<String>> graph) {
        Map<String, Integer> disc = new HashMap<>();
        Map<String, Integer> low = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        // Perform DFS for each component
        for (String vertex : graph.keySet()) {
            if (!disc.containsKey(vertex)) {
                dfs(vertex, graph, disc, low, parent);
                // Pop remaining edges in stack for a BCC
                List<String> bcc = new ArrayList<>();
                while (!stack.isEmpty()) {
                    bcc.add(stack.pop());
                }
                if (!bcc.isEmpty()) {
                    bccs.add(bcc);
                }
            }
        }
        return bccs;
    }

    // Example usage
    public static void main(String[] args) {
        // Example graph as adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "C", "D"));
        graph.put("C", Arrays.asList("A", "B", "D"));
        graph.put("D", Arrays.asList("B", "C", "E"));
        graph.put("E", Arrays.asList("D", "F"));
        graph.put("F", Arrays.asList("E"));

        BiconnectedComponents bccFinder = new BiconnectedComponents();
        List<List<String>> bccs = bccFinder.findBCCs(graph);

        // Print the BCCs
        System.out.println("Bi-Connected Components:");
        for (List<String> bcc : bccs) {
            System.out.println(bcc);
        }
    }
}

