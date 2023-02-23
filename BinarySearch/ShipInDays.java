public class ShipInDays {
    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int D = 5;
        System.out.println(shipWithinDays(weights, D));
    }

    static int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int i = 0; i < weights.length; i++) {
            if (low < weights[i]) {
                low = weights[i];
            }
            high += weights[i];
        }

        int res = high;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canShip(mid, weights, days)) {
                res = Math.min(res, mid);
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    static boolean canShip(int cap, int[] arr, int days) {
        int day = 1;
        int currCap = 0;
        for (int w : arr) {
            if (currCap + w > cap) {
                day += 1;
                currCap = 0;
            }
            currCap += w;
        }

        return day <= days;
    }
}
