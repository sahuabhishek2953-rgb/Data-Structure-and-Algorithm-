class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        if (maxDiff == 0) {
            return 0;
        }

        int[] count = new int[maxDiff + 1];
        for (int d : diff) {
            count[d]++;
        }

        long k = (long) k1 + k2;

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (count[d] == 0) {
                continue;
            }

            if (k >= count[d]) {
                count[d - 1] += count[d];
                k -= count[d];
                count[d] = 0;
            } else {
                count[d - 1] += (int) k;
                count[d] -= (int) k;
                k = 0;
            }
        }

        long result = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                result += (long) count[d] * d * d;
            }
        }

        return result;
    }
}