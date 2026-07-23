class Solution {
    static boolean divisible(int[] nums,int divisor, int threshold){
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=Math.ceil((double)nums[i]/divisor);
             }
        if(sum <= threshold){
                return true;
            }
        return false;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int low=1;
        int high=max;
        while(low <= high){
            int mid=low+(high-low)/2;
            if(divisible(nums,mid,threshold)){
                high=mid-1;

            }
            else{
                low=mid+1;
            }
            
        }
        return low;
        
    }
}