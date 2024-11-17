package Seven;
import java.util.*;
public class Seven {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        int[] topoSort = new int[V];

        for(int i = 0; i < V; i++) {
            for(Integer it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int index = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topoSort[index++] = node;

            for(Integer it : adj.get(node)){
                indegree[it]--;

                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        return !(V == index);
    }


}
