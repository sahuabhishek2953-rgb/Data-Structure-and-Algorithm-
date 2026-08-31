class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int position = 1;
        int firstCritical = -1;
        int lastCritical = -1;
        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {
            int nextValue = curr.next.val;

            boolean isCritical =
                (curr.val > prev.val && curr.val > nextValue) ||
                (curr.val < prev.val && curr.val < nextValue);

            if (isCritical) {
                if (firstCritical == -1) {
                    firstCritical = position;
                } else {
                    minDistance = Math.min(minDistance, position - lastCritical);
                }

                lastCritical = position;
            }

            prev = curr;
            curr = curr.next;
            position++;
        }

        if (firstCritical == lastCritical) {
            return ans;
        }

        return new int[]{minDistance, lastCritical - firstCritical};
    }
}