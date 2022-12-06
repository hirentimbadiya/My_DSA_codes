import java.util.HashMap;

public class ReorderedPow2 {
    static boolean reorderedPowerOf2(int n) {
        if (n == 1)
            return true;
        int t = n;
        int pow = 0;
        while (t > 0) {
            pow++;
            t /= 2;
        }
        pow *= 2;
        while (pow > 0) {
            if (isAnagram(n, (int) Math.pow(2, pow)))
                return true;
            pow--;
        }
        return false;
    }

    static boolean isAnagram(int n1, int n2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int temp1 = n1;
        int temp2 = n2;
        int x = n1;
        while (temp1 > 0) {
            int rem = temp1 % 10;
            map1.put(rem, map1.getOrDefault(rem, 0) + 1);
            temp1 /= 10;
        }
        while (temp2 > 0) {
            int rem = temp2 % 10;
            map2.put(rem, map2.getOrDefault(rem, 0) + 1);
            temp2 /= 10;
        }
        if (map1.size() != map2.size()) {
            return false;
        }
        while (x > 0) {
            int rem = x % 10;
            if (map1.get(rem) != map2.get(rem))
                return false;

            x = x / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(24));
    }
}
