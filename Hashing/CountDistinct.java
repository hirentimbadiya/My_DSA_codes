import java.util.HashSet;
import java.util.Set;

public class CountDistinct {
    static int countDisNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 8, 4, 4, 3, 0, 3 };
        System.out.println(countDisNums(nums));
    }
}
