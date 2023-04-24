public class FindNthMAgicNo {
    // Amazon Question
    public static void main(String[] args) {
        int n = magicNo(3);
        System.out.println(n);
    }

    static int magicNo(int n) {
        int ans = 0;
        int base = 5;
        // this loop is running number of times binary digits in the ans
        while (n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans = base * last + ans;
            base = base * 5;
        }
        return ans;
    }
}
