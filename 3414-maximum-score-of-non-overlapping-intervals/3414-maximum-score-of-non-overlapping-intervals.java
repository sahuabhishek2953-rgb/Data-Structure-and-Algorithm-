import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        Arrays.sort(a, (x, y) -> {
            if (x[1] != y[1]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[0], y[0]);
        });

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] best = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                best[i][k] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = dp[i - 1][k];
                best[i][k] = new ArrayList<>(best[i - 1][k]);
            }

            int p = findPrevious(a, i - 1);

            for (int k = 1; k <= 4; k++) {
                long value = dp[p][k - 1] + a[i - 1][2];

                List<Integer> candidate = new ArrayList<>(best[p][k - 1]);
                candidate.add(a[i - 1][3]);
                Collections.sort(candidate);

                if (value > dp[i][k] ||
                    (value == dp[i][k] && lexicographicallySmaller(candidate, best[i][k]))) {
                    dp[i][k] = value;
                    best[i][k] = candidate;
                }
            }
        }

        List<Integer> ans = best[n][4];
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private int findPrevious(int[][] a, int index) {
        int l = 0, r = index;

        while (l < r) {
            int m = (l + r) >>> 1;

            if (a[m][1] < a[index][0]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    private boolean lexicographicallySmaller(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}