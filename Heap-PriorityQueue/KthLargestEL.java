import java.util.PriorityQueue;

public class KthLargestEL {
    static int kthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // if size exceeds greater than k then poll.
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 692, 24, 9, -8, 0, 113, 13, 110 };
        int k = 5;
        System.out.println(kthLargestElement(arr, k));
    }
}
