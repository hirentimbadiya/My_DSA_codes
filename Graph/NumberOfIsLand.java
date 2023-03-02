import java.util.*;

public class NumberOfIsLand {
    static final int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }

    static void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(i, j));

        while (!que.isEmpty()) {
            Pair curr = que.poll();

            for (int[] nums : directions) {
                // go for all 4 directional neighbours
                int row = curr.r + nums[0];
                int col = curr.c + nums[1];

                if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col] || grid[row][col] == '0') {
                    continue;
                }
                visited[row][col] = true;
                que.add(new Pair(row, col));
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1' },
                { '0', '1', '0' },
                { '0', '1', '0' }
        };
        System.out.println(numIslands(grid));
    }

    static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
