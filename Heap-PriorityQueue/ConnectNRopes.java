import java.util.PriorityQueue;

public class ConnectNRopes {
    // Amazon
    static int findMinCost(int[] arr) {
        // time complexity : O(NlogN)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int a1 = pq.poll();
            int a2 = pq.poll();
            int sum = a1 + a2;
            cost = cost + sum;

            // add the sum to the priority queue.
            pq.add(sum);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 4, 8, 6, 9 };
        System.out.println(findMinCost(arr));
    }
}
