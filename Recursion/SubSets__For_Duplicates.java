import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets__For_Duplicates {
    static List<List<Integer>> subsetsDuplicate(int[] nums) {
        // sort
        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        // first adding the empty array list in outer list
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            // iterating for all elements in array
            if (i > 0 && nums[i] == nums[i - 1]) {
                // start to end + 1 if duplicates
                start = end + 1;
            } else {
                // if not then start = 0
                start = 0;
            }
            end = outer.size() - 1;
            int n = outer.size();
            // we need to create the copy of the elements which are in outer list
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                // this creates the copy of the outer list
                // now adding element of array in copied internal list
                internal.add(nums[i]);
                // adding internal list in outer list
                outer.add(internal);
            }
        }

        return outer;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2 };
        System.out.println(subsetsDuplicate(nums));
    }
}
