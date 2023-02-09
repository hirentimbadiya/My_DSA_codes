import java.util.*;

public class TopologicalSortDFS {

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Adding edges one by one
        addEdge(adj, 0, 3);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 1);
        addEdge(adj, 3, 1);
        addEdge(adj, 5, 1);
        addEdge(adj, 5, 4);
        addEdge(adj, 1, 4);

        int[] res = topoSort(V, adj);
        System.out.println(Arrays.toString(res));
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfs(i, adj, visited, st);
            }
        }
        int[] res = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            res[i++] = st.pop();
        }
        return res;
    }

    static void dfs(int v, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited, Stack<Integer> st) {
        visited[v] = true;

        for (Integer neighbour : adj.get(v)) {
            if (visited[neighbour] == false) {
                dfs(neighbour, adj, visited, st);
            }
        }
        st.push(v);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {
        // for directed graph
        list.get(u).add(v);
    }
}
