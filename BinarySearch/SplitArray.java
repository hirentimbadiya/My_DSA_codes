public class SplitArray {
    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int m = 2;
        int x = Split_Array(nums, m);
        System.out.println(x);
    }

    static int Split_Array(int[] nums, int m) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end = end + nums[i];
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int piecese = 1;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] > mid) {
                    sum = nums[i];
                    piecese++;
                } else {
                    sum = sum + nums[i];
                }
            }
            if (piecese > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
