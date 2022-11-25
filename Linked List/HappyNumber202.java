public class HappyNumber202 {
    static boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));

        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    static int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans = ans + rem * rem;
            n = n / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
