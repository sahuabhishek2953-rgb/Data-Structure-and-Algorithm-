class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode slow2 = reverse(slow);

        ListNode slow1 = head;

        while (slow2 != null) {
            if (slow1.val != slow2.val) {
                return false;
            }

            slow1 = slow1.next;
            slow2 = slow2.next;
        }

        return true;
    }
}