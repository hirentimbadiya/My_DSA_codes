public class MaximumSubArray643 {
    static double findMaxAverage(int[] nums, int k) {
        long currentSum = 0;
        if (nums.length == 1)
            return (double) nums[0] / 1.0 / k;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        long maxsum = currentSum;
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[i - k];
            maxsum = Math.max(maxsum, currentSum);
        }

        return (double) maxsum / 1.0 / k;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
