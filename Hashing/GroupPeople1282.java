import java.util.*;

public class GroupPeople1282 {
    public static void main(String[] args) {
        int[] groupSizes = { 3, 3, 3, 3, 3, 1, 3 };
        System.out.println(groupThePeople(groupSizes));
    }

    static List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int val : groupSizes) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (int key : map.keySet()) {
            int group = map.get(key);
            int noOfGroup = group / key;
            for (int i = 0; i < noOfGroup; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < groupSizes.length && temp.size() < key; j++) {
                    if (groupSizes[j] == key && !set.contains(j)) {
                        set.add(j);
                        temp.add(j);
                    }
                }
                res.add(new ArrayList<>(temp));
            }
        }
        return res;
    }
}
