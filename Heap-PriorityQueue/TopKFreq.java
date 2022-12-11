import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFreq {
    static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int i = 0;
        while (i < k) {
            int max = findMax(map);
            ans[i] = max;
            map.remove(max);
            i++;
        }
        return ans;
    }

    static int findMax(HashMap<Integer, Integer> map) {
        int val = -1;
        int max = 0;
        // iterate over the hashmap , its a important syntax.
        for (Map.Entry<Integer, Integer> key : map.entrySet()) {
            if (max < key.getValue()) {
                val = key.getKey();
                max = key.getValue();
            }
        }

        return val;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }
}
