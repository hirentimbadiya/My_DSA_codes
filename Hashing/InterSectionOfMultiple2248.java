import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class InterSectionOfMultiple2248 {
    static List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums[0].length; j++) {
            list.add(nums[0][j]);
        }
        for (int i = 1; i < nums.length; i++) {
            List<Integer> list1 = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) {
                if (list.contains(nums[i][j])) {
                    list1.add(nums[i][j]);
                }
            }
            list = list1;
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        int[][] nums = { { 3, 1, 2, 4, 5 }, { 1, 2, 3, 4 }, { 3, 4, 5, 6 } };
        System.out.println(intersection(nums));
    }
}
