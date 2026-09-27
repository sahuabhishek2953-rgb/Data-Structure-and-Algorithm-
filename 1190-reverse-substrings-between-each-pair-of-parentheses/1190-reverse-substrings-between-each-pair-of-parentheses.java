class Solution {
    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                int j = stack.pop();
                reverse(arr, j + 1, i - 1);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (char c : arr) {
            if (c != '(' && c != ')') {
                ans.append(c);
            }
        }

        return ans.toString();
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}