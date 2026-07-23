class Solution {
    public int countSubarrays(int[] nums) {
        int left=0;
        int right=1;
        int count=0;
        for(int i=0; i<nums.length; i++){
                 if(right == nums.length-1){
                    break;
                }
            if( 2*(nums[left]+nums[right+1]) == nums[right]){
              
                count++;
                left++;
                right++; 
            }
            else{
                left++;
                right++;
            }
        }
        return count;
        
    }
}