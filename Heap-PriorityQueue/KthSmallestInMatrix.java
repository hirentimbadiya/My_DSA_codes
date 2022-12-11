import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestInMatrix {
    static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        // unlike the kth max element we are creating max heap here of size k
        // in kth maximum we have created a min heap of size k
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }
}
