class Solution {
    static int maxElement(int[][] mat, int n, int m, int mid) {
        int row = 0;
        for (int i = 1; i < n; i++) {
            if (mat[i][mid] > mat[row][mid]) {
                row = i;
            }
        }
        return row;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = maxElement(mat, n, m, mid);

            int left = (mid - 1 >= 0) ? mat[row][mid - 1] : -1;
            int right = (mid + 1 < m) ? mat[row][mid + 1] : -1;

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[] { row, mid };
            }

            if (mat[row][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[] { -1, -1 };
    }
}