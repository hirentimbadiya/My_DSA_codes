import java.util.*;

public class DetectCycle {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        System.out.println(isCycle(V, adj));
    }

    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            // if not visited then go for dfs
            if (visited[i] == false) {
                if (dfs(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        // if dfs doesn't return true then false
        return false;
    }

    static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited, int parent) {
        // mark v as visited
        visited[v] = true;
        // go for the neighbours of v
        for (Integer neighbour : adj.get(v)) {
            // if neighbours are not visited then run dfs
            if (visited[neighbour] == false) {
                if (dfs(neighbour, adj, visited, v)) {
                    return true;
                }
            }
            // if neighbour is visited then check parent != neighbour
            else if (parent != neighbour) {
                return true;
            }
        }
        // if we don't get true then return false
        return false;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }
}
