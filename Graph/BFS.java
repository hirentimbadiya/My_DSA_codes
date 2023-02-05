import java.util.*;

public class BFS {
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

        ArrayList<Integer> bfs_ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                bfs_Traversal(i, adj, visited, bfs_ans);
            }
        }
        // print the graph
        display(adj);
        System.out.println(bfs_ans);
    }

    static void bfs_Traversal(int v, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited, ArrayList<Integer> res) {
        Queue<Integer> que = new LinkedList<>();
        // add the vertex in queue
        que.add(v);
        // mark v as visited
        visited[v] = true;
        while (!que.isEmpty()) {
            // poll from queue
            int h = que.poll();
            // add in the result
            res.add(h);
            // go for the adjacent nodes of the h.
            for (Integer neighbour : adj.get(h)) {
                // if adjacents are not visited then make them visited and add it in queue
                if (visited[neighbour] == false) {
                    visited[neighbour] = true;
                    que.add(neighbour);
                }
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
