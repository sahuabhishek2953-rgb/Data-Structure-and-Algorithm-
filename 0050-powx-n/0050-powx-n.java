class Solution {
    static double pow(double x, long n) {
        if (n == 0) return 1;

        double half = pow(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else
            return x * half * half;
    }

    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return pow(x, N);
    }
}