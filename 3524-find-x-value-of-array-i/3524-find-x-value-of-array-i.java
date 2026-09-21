class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int mod = num % k;
            long[] next = new long[k];

            next[mod]++;

            for (int r = 0; r < k; r++) {
                int newR = (r * mod) % k;
                next[newR] += dp[r];
            }

            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}