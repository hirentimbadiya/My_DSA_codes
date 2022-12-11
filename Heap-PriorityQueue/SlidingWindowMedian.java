import java.util.*;

public class SlidingWindowMedian {
    static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // create the res array of size n-k+1
        double[] res = new double[n - k + 1];
        int h = 0;
        // create 2 Priority-Queue MaxHeap and MeanHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // insert k elements in the heaps
        for (int i = 0; i < k; i++) {
            insert(nums[i], maxHeap, minHeap);
        }
        // find the first median
        res[h] = findMedian(maxHeap, minHeap);
        h++;
        for (int i = k; i < n; i++) {
            // remove the element from heap which is out of the wondow now
            if (maxHeap.contains(nums[i - k]))
                maxHeap.remove(nums[i - k]);
            else
                minHeap.remove(nums[i - k]);

            // insert the current element which is the part of window now
            insert(nums[i], maxHeap, minHeap);
            // find median and add it in res
            res[h] = findMedian(maxHeap, minHeap);
            h++;
            // repeat this loop till n.
        }

        return res;
    }

    static double findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        // if both heap size are same then take both the peek and add it after /2.
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // else out maxHeap 's peek is median
        return maxHeap.peek();
    }

    static void insert(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        // if maxHeap isEmpty or maxHeap's peek is greater than num then insert it
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            // else add it in minHeap
            minHeap.add(num);

        // maintain the size of maxHeap like maxHeap.size() >= minHeap.size()
        // maxHeap's size can be at max minHeap's size + 1
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public static void main(String[] args) {
        int[] nums = { 2147483647, 2147483647 };
        int k = 2;
        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }
}
