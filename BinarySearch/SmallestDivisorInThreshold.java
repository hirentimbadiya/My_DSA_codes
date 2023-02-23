  public class SmallestDivisorInThreshold {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 9 };
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }

    static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i : nums) {
            high = Math.max(high, i);
        }
        int res = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int th = 0;
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                th += x / mid;
                if (x % mid != 0) {
                    th++;
                }
            }
            if (th <= threshold) {
                res = Math.min(res, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
