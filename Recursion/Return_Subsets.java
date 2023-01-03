import java.util.ArrayList;
import java.util.List;

public class Return_Subsets {
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        // first adding the empty array list in outer list
        outer.add(new ArrayList<>());
        for (int num : nums) {
            // iterating for all elements in array
            int n = outer.size();
            // we need to create the copy of the elements which are in outer list
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                // this creates the copy of the outer list
                // now adding element of array in copied internal list
                internal.add(num);
                // adding internal list in outer list
                outer.add(internal);
            }
        }

        return outer;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsets(nums));
    }
}
