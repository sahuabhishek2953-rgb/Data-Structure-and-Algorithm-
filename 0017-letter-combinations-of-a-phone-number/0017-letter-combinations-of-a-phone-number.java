class Solution {
    static void solve(String digits, int index, String[] mapping, List<String> result, StringBuilder output){
        if(index >= digits.length()){
            result.add(output.toString());
            return ;

        }
        int value=digits.charAt(index)-'0';
        String mapped= mapping[value];
        for(int i=0; i<mapped.length(); i++){
            output.append(mapped.charAt(i));
            solve(digits,index+1,mapping,result,output );
            output.deleteCharAt(output.length()-1);

        }
 }
    public List<String> letterCombinations(String digits) {
        String[] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int index=0;
        List<String> result=new ArrayList<>();
        StringBuilder output = new StringBuilder();
        solve(digits,index, mapping, result,output);
        return result;
        
        
    }
}