import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubArrayWith_kSum {
    static List<Integer> subArraySum(int[] nums, int k) {
        int curSum = 0;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum == k) {
                res.add(0);
                res.add(i);
                break;
            }
            if (map.containsKey(curSum - k)) {
                res.add(map.get(curSum - k) + 1);
                res.add(i);
                break;
            }
            map.put(curSum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 15, -5, 15, -10, 5 };
        int k = 5;
        System.out.println(subArraySum(nums, k));
    }
}
