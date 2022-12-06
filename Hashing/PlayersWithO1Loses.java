import java.util.*;

public class PlayersWithO1Loses {
    public static void main(String[] args) {
        int[][] matches = { { 1, 5 }, { 2, 5 }, { 2, 8 }, { 2, 9 }, { 3, 8 }, { 4, 7 }, { 4, 9 }, { 5, 7 }, { 6, 8 } };

        System.out.println(findWinners(matches));
    }

    static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        int[] won = new int[100001];
        int[] lost = new int[100001];

        for (int[] match : matches) {
            won[match[0]]++;
            lost[match[1]]++;
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < lost.length; i++) {
            if (won[i] > 0 && lost[i] == 0) {
                list1.add(i);
            }
            if (lost[i] == 1) {
                list2.add(i);
            }
        }
        res.add(list1);
        res.add(list2);
        return res;
    }
}
