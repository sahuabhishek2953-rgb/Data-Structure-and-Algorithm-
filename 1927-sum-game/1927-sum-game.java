class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int mid = n / 2;

        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;

        for (int i = 0; i < mid; i++) {
            char ch = num.charAt(i);
            if (ch == '?') {
                leftQ++;
            } else {
                leftSum += ch - '0';
            }
        }

        for (int i = mid; i < n; i++) {
            char ch = num.charAt(i);
            if (ch == '?') {
                rightQ++;
            } else {
                rightSum += ch - '0';
            }
        }

        return 2 * (leftSum - rightSum) != 9 * (rightQ - leftQ);
    }
}