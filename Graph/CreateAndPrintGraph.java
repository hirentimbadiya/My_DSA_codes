import java.util.*;

class CreateAndPrintGraph {
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

        // print the graph
        display(adj);
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
