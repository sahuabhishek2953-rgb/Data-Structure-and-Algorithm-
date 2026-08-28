class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
        }

        char[] left = new char[halfLen];

        for (int i = 0; i < halfLen; i++) {
            left[i] = target.charAt(i);

            int x = left[i] - 'a';
            half[x]--;

            if (half[x] < 0) {
                break;
            }
        }

        boolean validPrefix = true;

        int[] temp = new int[26];

        for (int i = 0; i < 26; i++) {
            temp[i] = cnt[i] / 2;
        }

        for (int i = 0; i < halfLen; i++) {
            temp[left[i] - 'a']--;

            if (temp[left[i] - 'a'] < 0) {
                validPrefix = false;
                break;
            }
        }

        if (validPrefix) {
            String candidate = build(left, mid, temp);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        for (int i = halfLen - 1; i >= 0; i--) {

            int[] remaining = new int[26];

            for (int j = 0; j < 26; j++) {
                remaining[j] = cnt[j] / 2;
            }

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                remaining[left[j] - 'a']--;

                if (remaining[left[j] - 'a'] < 0) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {

                if (remaining[c] == 0) {
                    continue;
                }

                remaining[c]--;

                char[] newLeft = new char[halfLen];

                for (int j = 0; j < i; j++) {
                    newLeft[j] = target.charAt(j);
                }

                newLeft[i] = (char) ('a' + c);

                int pos = i + 1;

                for (int x = 0; x < 26; x++) {
                    while (remaining[x] > 0) {
                        newLeft[pos++] = (char) ('a' + x);
                        remaining[x]--;
                    }
                }

                String ans = build(newLeft, mid, new int[26]);

                if (ans.compareTo(target) > 0) {
                    return ans;
                }

                remaining[c]++;
            }
        }

        return "";
    }

    private String build(char[] left, char mid, int[] unused) {
        StringBuilder sb = new StringBuilder();

        for (char c : left) {
            sb.append(c);
        }

        if (mid != 0) {
            sb.append(mid);
        }

        for (int i = left.length - 1; i >= 0; i--) {
            sb.append(left[i]);
        }

        return sb.toString();
    }
}