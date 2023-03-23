import java.util.*;

public class AsFarAsPossible {
    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
        System.out.println(maxDistance(grid));
    }

    static int maxDistance(int[][] grid) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int n = grid.length;
        int m = n;
        Queue<Pair> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    que.add(new Pair(i, j));
                }
            }
        }
        int res = -1;
        if (que.size() == n * n || que.isEmpty()) {
            return -1;
        }
        while (!que.isEmpty()) {
            Pair pos = que.poll();
            int row = pos.r;
            int col = pos.c;
            res = grid[row][col];
            for (int[] arr : directions) {
                int newRow = arr[0] + row;
                int newCol = arr[1] + col;
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 0) {
                    que.add(new Pair(newRow, newCol));
                    grid[newRow][newCol] = grid[row][col] + 1;
                }
            }
        }
        return res - 1;
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
