class Solution {
    static boolean possible(int[] bloomDay,int day,int m,int n){
        int counter=0;
        int noOfBuket=0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= day){
                counter++;
            }
            else{
                 noOfBuket+=counter/n;
                counter=0;
            }
        }
        noOfBuket+=counter/n;
        if(noOfBuket >= m) return true;
        return false;
        
    }
    public int minDays(int[] bloomDay, int m, int k) {
         if (bloomDay.length < (long)m * k) {
             return -1;
            }
            
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : bloomDay){
              min = Math.min(min, num);
             max = Math.max(max, num);
        }
     
        while(min <= max){
            int mid=min+(max-min)/2;
            if(possible(bloomDay,mid,m,k)){
                max=mid-1;
                }
            
            else{
                 min=mid+1;
                 }

            
        }

        return  min;
        
    }
}