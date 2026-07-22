class Solution {
    static long calculateTotalH(int[] piles, int speed){
        long totalH = 0;
        for(int banana : piles){
            totalH += (banana + speed - 1) / speed;
        }
        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(calculateTotalH(piles, mid) <= h){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}