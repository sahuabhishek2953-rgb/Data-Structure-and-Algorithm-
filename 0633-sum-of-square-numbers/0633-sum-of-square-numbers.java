class Solution {
    static  int sqrt(int c){
        int low=1;
        int high=c;
        while(low <= high){
            int mid=low+(high-low)/2;
            if((long)mid*mid <= c){
                low=mid+1;

            }
            else{
                high=mid-1;
            }
        
        }
        return high;
    


    }
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right =sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;

            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}