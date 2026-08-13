class Solution {
    public String reverseByType(String s) {
        int l=0;
        int r=s.length()-1;
        char[] ch=s.toCharArray();
        while(l<r){
            if(!Character.isLetter(ch[l])){
                l++;
            }
            else if(!Character.isLetter(ch[r])){
                r--;
            }
            else{
                char temp=ch[l];
                ch[l]=ch[r];
                ch[r]=temp;
                l++;
                r--;
                

            }
        }
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(Character.isLetter(ch[i])){
                i++;
            }
            else if(Character.isLetter(ch[j])){
                j--;
            }
            else{
                char temp=ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;
                

            }
        }
        return new String(ch);
    }
}