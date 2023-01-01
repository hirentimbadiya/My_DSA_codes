public class Remove {
    public static void main(String[] args) {
        skip("", "bckafcasavada");
        System.out.println(skip("bckafcasavada"));
        System.out.println(skipString("hirukavadapav"));
    }

    static void skip(String s, String p) {
        if (p.isEmpty()) {
            System.out.println(s);
            return;
        }
        char c = p.charAt(0);
        if (c == 'a') {
            skip(s, p.substring(1));
        } else {
            skip(s + c, p.substring(1));
        }
    }

    static String skip(String p) {
        if (p.isEmpty()) {
            return "";
        }
        char ch = p.charAt(0);
        if (ch == 'a') {
            return skip(p.substring(1));
        } else {
            return ch + skip(p.substring(1));
        }
    }

    static String skipString(String p) {
        if (p.isEmpty()) {
            return "";
        }
        String s = "vada";
        if (p.startsWith(s)) {
            return skipString(p.substring(4));
        } else {
            return p.charAt(0) + skipString(p.substring(1));
        }
    }
}
