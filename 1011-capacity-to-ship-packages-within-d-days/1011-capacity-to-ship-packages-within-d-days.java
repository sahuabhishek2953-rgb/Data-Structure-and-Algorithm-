class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int w:weights){
            low=Math.max(low,w);
            high+=w;
        }
      while(low<=high){
        int mid=low+(high-low)/2;
        int ans=0;
            if(canShip(weights,days, mid)){
                ans=mid;
                high=mid-1;
                }
            else{
                low=mid+1;
            }
        }
     
      return  low;  
    }

    static boolean canShip(int[] weights,int days,int cap){
    int currdays=1;
    int currweight=0;
    for(int w:weights){
    if(currweight+w > cap){
        currdays++;
        currweight=w;

    }
    else{
        currweight+=w;
    }
    
    }
    return currdays<=days;
    }

}