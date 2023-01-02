import java.util.ArrayList;
import java.util.List;

public class Return_SubSequences_Of_String {
    public static void main(String[] args) {
        // List<String> list = new ArrayList<>();
        // list = subSeqRet("", "abc");
        // System.out.println(list);
        // subSeq("", "abc");
        System.out.println(longestIdealString("pvjcci", 4));
    }

    static int longestIdealString(String s, int k) {
        List<String> res = subSeqRet("", s);
        System.out.println(res);
        int length = 0;
        for (int i = 0; i < res.size(); i++) {
            if (valid(res.get(i), k)) {
                length = Math.max(length, res.get(i).length());
            }
        }
        return length;
    }

    static boolean valid(String s, int k) {
        for (int i = 1; i < s.length();) {
            if (s.charAt(i) - s.charAt(i - 1) <= k) {
                i++;
            } else {
                return false;
            }

        }
        return true;
    }

    static void subSeq(String s, String p) {
        if (p.isEmpty()) {
            System.out.println(s);
            return;
        }
        char c = p.charAt(0);
        subSeq(s + c, p.substring(1));
        subSeq(s, p.substring(1));
    }

    static List<String> subSeqRet(String s, String p) {
        if (p.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }
        List<String> left = subSeqRet(s + p.charAt(0), p.substring(1));
        List<String> right = subSeqRet(s, p.substring(1));
        left.addAll(right);
        return left;
    }
}
