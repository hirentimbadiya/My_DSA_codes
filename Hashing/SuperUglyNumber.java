import java.util.PriorityQueue;

public class SuperUglyNumber {
    public static void main(String[] args) {
        int n = 12;
        int[] primes = { 2, 7, 13, 19 };
        System.out.println(nthSuperUglyNumber(n, primes));
    }

    static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int k = primes.length;

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(primes[i], 1, primes[i]));
        }

        for (int i = 2; i <= n;) {
            Pair min = pq.poll();

            if (dp[i - 1] != min.value) {
                dp[i] = min.value;
                i++;
            }
            pq.add(new Pair(min.prime, min.pointer + 1, min.prime * dp[min.pointer + 1]));
        }
        return dp[n];
    }

    static class Pair implements Comparable<Pair> {
        int prime;
        int pointer;
        int value;

        public Pair(int prime, int pointer, int value) {
            this.prime = prime;
            this.pointer = pointer;
            this.value = value;
        }

        public int compareTo(Pair that) {
            return this.value - that.value;
        }
    }
}
