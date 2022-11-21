import java.util.Arrays;

public class FirstAndLastPosition {
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6, 6, 7, 7, 7, 7, 7, 8 };
        int target = 7;
        int[] ans = searchRange(A, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };

        int start = FindIndex(nums, target, true);
        int end = FindIndex(nums, target, false);
        ans[0] = start;
        ans[1] = end;

        return ans;
    }

    static int FindIndex(int[] nums, int target, boolean isStart) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = start + 1;
            } else if (target < nums[mid]) {
                end = end - 1;
            } else {
                ans = mid;
                if (isStart) {
                    end = end - 1;
                } else {
                    start = start + 1;
                }
            }
        }
        return ans;

    }

}
