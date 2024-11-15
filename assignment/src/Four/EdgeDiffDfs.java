package Four;

import java.util.*;

public class EdgeDiffDfs {
    private int dfsTime = 1;
    private int completionTime = 1;
    private final int[] dfsTimeArray;
    private final int[] dfsCompletionTimeArray;
    private final boolean[] visited;
    private final ArrayList<ArrayList<Integer>> adjList;
    private final int numberOfVertices;

    private final HashSet<Edge> treeEdgeSet = new HashSet<Edge>();
    private final HashSet<Edge> forwardEdgeSet = new HashSet<Edge>();
    private final HashSet<Edge> backEdgeSet = new HashSet<Edge>();

    public HashSet<Edge> getBackEdgeSet() {
        for(Edge edge : treeEdgeSet) {
            backEdgeSet.add(edge.reverseEdge());
        }

        for(Edge edge : forwardEdgeSet) {
            backEdgeSet.add(edge.reverseEdge());
        }

        return backEdgeSet;
    }

    public HashSet<Edge> getTreeEdgeSet() {
        return treeEdgeSet;
    }

    public HashSet<Edge> getForwardEdgeSet() {
        return forwardEdgeSet;
    }

    public EdgeDiffDfs(int numberOfVertices) {
        this.adjList = new ArrayList<>();
        for(int i = 0; i < numberOfVertices; i++) {
            adjList.add(new ArrayList<>());
        }
        this.numberOfVertices = numberOfVertices;
        dfsTimeArray = new int[numberOfVertices];
        dfsCompletionTimeArray = new int[numberOfVertices];
        this.visited = new boolean[numberOfVertices];
    }

    public boolean addEdge(int u, int v) {
        if(u < 0 || v < 0 || u >= numberOfVertices || v >= numberOfVertices) {
            return false;
        }

        adjList.get(u).add(v);
        adjList.get(v).add(u);
        return true;
    }

    public void dfs(int node) {

        visited[node] = true;
        dfsTimeArray[node] = dfsTime++;

        for(Integer i : adjList.get(node)) {
            if(!visited[i]) {
                treeEdgeSet.add(new Edge(node, i));
                dfs(i);
            }
        }

        dfsCompletionTimeArray[node] = completionTime++;
    }

    public Map<String, Set<Edge>> classifyEdges(int start) {
        Arrays.fill(visited, false);
        Map<String, Set<Edge>> map = new HashMap<>();
        dfs(start);
        classifyEdgesHelper(start);

        map.put("Tree Edge Set", getTreeEdgeSet());
        map.put("Forward Edge Set", getForwardEdgeSet());
        map.put("Back Edge Set", getBackEdgeSet());

        return map;
    }

    private void classifyEdgesHelper(int node) {
        if(visited[node]) {
            return;
        }

        visited[node] = true;

        for(Integer i : adjList.get(node)) {
            if(dfsTimeArray[node] < dfsTimeArray[i] && dfsCompletionTimeArray[node] > dfsCompletionTimeArray[i]) {
                forwardEdgeSet.add(new Edge(node, i));
            }
            classifyEdgesHelper(i);
        }

    }
}
