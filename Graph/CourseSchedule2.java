import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {
        int v = 4;
        int[][] arr = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[] res = findOrder(v, arr);
        System.out.println(Arrays.toString(res));
    }

    static int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = createGraph(V, prerequisites);

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (dfs(i, adj, visited, st, recStack)) {
                    return new int[] {};
                }
            }
        }
        int[] res = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            res[i++] = st.pop();
        }
        return res;
    }

    static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited, Stack<Integer> st, boolean[] recStack) {
        visited[v] = true;
        recStack[v] = true;
        for (Integer neighbour : adj.get(v)) {
            if (visited[neighbour] == false) {
                if (dfs(neighbour, adj, visited, st, recStack)) {
                    return true;
                }
            } else if (recStack[neighbour]) {
                return true;
            }
        }
        st.push(v);
        recStack[v] = false;
        return false;
    }

    static ArrayList<ArrayList<Integer>> createGraph(int V, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] nums : arr) {
            int v = nums[0];
            int u = nums[1];

            adj.get(u).add(v);
        }
        return adj;
    }
}
