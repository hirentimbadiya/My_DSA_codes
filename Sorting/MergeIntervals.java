import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 4 }, { 2, 5 }, { 7, 9 } };
        int[][] ans = merge(intervals);
        for (int[] interval : ans) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[] { L, R });
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
