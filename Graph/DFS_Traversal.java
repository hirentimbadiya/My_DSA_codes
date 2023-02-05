import java.util.*;

public class DFS_Traversal {
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

        ArrayList<Integer> dfs_ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfs_Traversal(i, adj, visited, dfs_ans);
            }
        }
        // print the graph
        display(adj);
        System.out.println(dfs_ans);
    }

    static void dfs_Traversal(int v, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited, ArrayList<Integer> res) {
        // mark v as visited and add it in the result
        visited[v] = true;
        res.add(v);
        // go for the adjacent of v
        for (Integer neighbour : adj.get(v)) {
            // if adjacent is not visited then go for recursive traversal for that adjacent
            if (visited[neighbour] == false) {
                dfs_Traversal(neighbour, adj, visited, res);
            }
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }

    static void display(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i);
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print("->" + list.get(i).get(j));
            }
            System.out.println();
        }
    }
}
