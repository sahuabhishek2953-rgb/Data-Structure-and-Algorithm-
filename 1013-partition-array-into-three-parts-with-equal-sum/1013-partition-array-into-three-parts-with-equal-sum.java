class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum=0;
        for(int num:arr){
            totalSum+=num;
        }
        if(totalSum % 3 !=0){
            return false;
        }

        int currsum=0;
        int target=totalSum/3;
        int count=0;

        for(int i=0; i<arr.length;i++){
            currsum+=arr[i];
            if(currsum == target){
                count++;
                currsum=0;
            }

        }

        
        return count>=3;
    }
   
}