import java.util.HashMap;

public class SubStringSize1876 {
    static int countGoodSubstrings(String s) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (map.size() == 3)
            count++;
        for (int i = 3; i < s.length(); i++) {
            if (map.get(s.charAt(i - 3)) == 1) {
                map.remove(s.charAt(i - 3));
            } else {
                map.put(s.charAt(i - 3), map.get(s.charAt(i - 3)) - 1);
            }
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.size() == 3) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String s = "xyzzaz";
        System.out.println(countGoodSubstrings(s));
    }
}
