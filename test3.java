// Given a string s of lowercase alphabets. The task is to find the maximum occurring character in the string s. If more than one character occurs the maximum number of times then print the lexicographically smaller character.

// Examples:

// Input: s = "testsample"
// Output: 'e'
// Explanation: 'e' is the character which is having the highest frequency.
// Input: s = "output"
// Output: 't'
// Explanation: 't' and 'u' are the characters with the same frequency, but 't' is lexicographically smaller.
// Constraints:
// 1 ≤ |s| ≤ 100

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)
class Solution {
    public char getMaxOccuringChar(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int maxFreq = 0;
        char ans = 'a';

        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                ans = (char) (i + 'a');
            }
        }

        return ans;
    }
}
