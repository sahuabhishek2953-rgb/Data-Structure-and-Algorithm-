class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int cntcurr=0;
        int longest=1;
        int lastsmaller=Integer.MIN_VALUE;
        if(nums.length==0) return 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1 == lastsmaller){
                cntcurr++;
                lastsmaller=nums[i];
            }
            else if(nums[i] !=lastsmaller){
                cntcurr=1;
                lastsmaller=nums[i];
            }
            longest=Math.max(longest,cntcurr);

        }
return longest;

        
    }
}