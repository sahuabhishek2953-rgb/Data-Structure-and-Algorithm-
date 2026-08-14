class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] fre=new int[26];
        for(char ch:magazine.toCharArray()){
            fre[ch-'a']++;
        }
        for(char ch:ransomNote.toCharArray()){
            if(fre[ch-'a']==0){
                return false;
            }
            fre[ch-'a']--;
        }
        return true;
        
    }
}