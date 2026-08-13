class Solution {

    class Node {
        int leftMax;
        int rightMax;
        int max;

        Node(int leftMax, int rightMax, int max) {
            this.leftMax = leftMax;
            this.rightMax = rightMax;
            this.max = max;
        }
    }

    char[] str;
    Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        str = s.toCharArray();

        int n = str.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);

            str[index] = c;
            update(1, 0, n - 1, index);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(1, 1, 1);
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        merge(node, l, r);
    }

    void update(int node, int l, int r, int index) {
        if (l == r) {
            tree[node] = new Node(1, 1, 1);
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, r, index);
        }

        merge(node, l, r);
    }

    void merge(int node, int l, int r) {
        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];

        int mid = (l + r) / 2;

        int leftLength = mid - l + 1;
        int rightLength = r - mid;

        int leftMax = left.leftMax;
        int rightMax = right.rightMax;

        if (str[mid] == str[mid + 1]) {
            if (left.leftMax == leftLength) {
                leftMax += right.leftMax;
            }

            if (right.rightMax == rightLength) {
                rightMax += left.rightMax;
            }
        }

        int max = Math.max(left.max, right.max);

        if (str[mid] == str[mid + 1]) {
            max = Math.max(max, left.rightMax + right.leftMax);
        }

        tree[node] = new Node(leftMax, rightMax, max);
    }
}