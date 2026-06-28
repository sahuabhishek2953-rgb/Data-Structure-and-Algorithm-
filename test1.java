/*
Question:Reverse Words
Platform: geeksforgeeks
Approach: String,DataStructure
Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public String reverseWords(String s) {
        // Code here

        String[] words=s.split("\\.");
        StringBuilder ans= new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            if(!words[i].isEmpty()){
                if(ans.length()>0){
                    ans.append(".");
                }
                ans.append(words[i]);
            }
        }
        return  ans.toString();
        
    }
}

