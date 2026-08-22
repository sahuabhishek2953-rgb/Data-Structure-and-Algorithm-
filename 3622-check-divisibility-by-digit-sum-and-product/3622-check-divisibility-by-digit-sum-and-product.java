class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int pod=1;
        int x=n;
        while(x>0){
            int digit=x%10;
            sum+=digit;
            pod*=digit;
            x/=10;
        }
        return n%(sum+pod)==0;
    }
}