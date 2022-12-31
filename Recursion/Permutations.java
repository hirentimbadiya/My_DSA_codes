import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        // permutations("", "abcd");
        ArrayList<String> ans = permutationsList("", "abc");
        System.out.println(ans);
    }

    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            // running loop till <= p.length().
            // 0 till i substring of p.
            String f = p.substring(0, i);
            // i till p.length() substring of p.
            String s = p.substring(i, p.length());

            permutations(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> permutationsList(String p, String up) {
        ArrayList<String> ans = new ArrayList<>();
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            // running loop till <= p.length().
            // 0 till i substring of p.
            String f = p.substring(0, i);
            // i till p.length() substring of p.
            String s = p.substring(i, p.length());

            // adding all possible answers to our ans list
            ans.addAll(permutationsList(f + ch + s, up.substring(1)));

        }
        return ans;
    }
}
