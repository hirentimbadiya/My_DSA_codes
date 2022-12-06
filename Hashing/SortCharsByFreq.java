import java.util.HashMap;
import java.util.Map;

public class SortCharsByFreq {
    static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            int max = findMaxVal(map);
            char c = maxChar(map);
            while (max > 0) {
                sb.append(c);
                max--;
            }
            map.remove(c);
        }
        return sb.toString();
    }

    static int findMaxVal(HashMap<Character, Integer> map) {
        int val = 0;
        for (Map.Entry<Character, Integer> kEntry : map.entrySet()) {
            if (val < kEntry.getValue()) {
                val = kEntry.getValue();
            }
        }
        return val;
    }

    static char maxChar(HashMap<Character, Integer> map) {
        int max = 0;
        char val = 0;
        for (Map.Entry<Character, Integer> kEntry : map.entrySet()) {
            if (max < kEntry.getValue()) {
                val = kEntry.getKey();
                max = kEntry.getValue();
            }
        }
        return val;
    }

    public static void main(String[] args) {
        String s = "ccaaa";
        System.out.println(frequencySort(s));
    }
}
