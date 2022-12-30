import java.util.ArrayList;
import java.util.List;

public class Letter_Combination_Phonepad {
    // Google Question!!
    public static void main(String[] args) {
        // pad("", "12");
        System.out.println(padList("", "12"));
    }

    static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        int digit = up.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    static List<String> padList(String p, String up) {
        List<String> ans = new ArrayList<>();

        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(padList(p + ch, up.substring(1)));
        }
        return ans;
    }
}
