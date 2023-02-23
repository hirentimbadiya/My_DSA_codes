public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int H = 8;
        System.out.println(minEatingSpeed(piles, H));
    }

    static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int p : piles) {
            high = Math.max(high, p);
        }
        int res = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            double hours = 0;
            for (int i = 0; i < piles.length; i++) {
                int x = piles[i];
                hours += x / mid;
                if (x % mid != 0) {
                    hours++;
                }
            }

            if (hours <= h) {
                res = Math.min(res, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
