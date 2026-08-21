class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long lo = 1, hi = 100000000000L;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long count = 0;

            for (int mask = 1; mask < (1 << n); mask++) {
                long lcm = 1;
                boolean valid = true;
                int bits = 0;

                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        bits++;
                        long g = gcd(lcm, coins[i]);
                        lcm = lcm / g * coins[i];

                        if (lcm > mid) {
                            valid = false;
                            break;
                        }
                    }
                }

                if (valid) {
                    if ((bits & 1) == 1)
                        count += mid / lcm;
                    else
                        count -= mid / lcm;
                }
            }

            if (count >= k)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}