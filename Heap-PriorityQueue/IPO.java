import java.util.*;

public class IPO {
    public static void main(String[] args) {
        int[] profits = { 1, 2, 3 };
        int[] capital = { 0, 1, 1 };
        int k = 2;
        int w = 0;
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    // Time Complexity: O(nlogn + klogn) for sorting and k times for finding max
    // profit and adding it to w and removing it from priority queue
    // Space Complexity: O(n) for priority queue and array of size n
    static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        while (k-- > 0) {
            while (i < n && arr[i][0] <= w) {
                pq.add(arr[i++][1]);
            }
            if (pq.isEmpty())
                break;
            w += pq.poll();
        }
        return w;
    }
}
