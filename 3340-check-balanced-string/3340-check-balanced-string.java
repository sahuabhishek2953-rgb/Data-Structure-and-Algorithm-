class Solution {
    public boolean isBalanced(String num) {
        char[] ch=num.toCharArray();
        int sum1=0;
        int sum2=0;
        for(int i=0;i<ch.length;i+=2){
            sum1+=ch[i]-'0';
        }
        for(int i=1;i<ch.length;i+=2){
            sum2+=ch[i]-'0';
        }
        return sum1==sum2;
    }
}