class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] count = freq.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';

                if (count[x] == 0) {
                    possible = false;
                    break;
                }

                count[x]--;
            }

            if (!possible) continue;

            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {
                if (count[c] == 0) continue;

                StringBuilder ans = new StringBuilder();

                for (int j = 0; j < i; j++) {
                    ans.append(target.charAt(j));
                }

                ans.append((char) ('a' + c));
                count[c]--;

                for (int x = 0; x < 26; x++) {
                    while (count[x] > 0) {
                        ans.append((char) ('a' + x));
                        count[x]--;
                    }
                }

                return ans.toString();
            }
        }

        return "";
    }
}