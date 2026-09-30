class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;

        ListNode dummy = new ListNode(0);
        ListNode temp1 = dummy;

        while (temp != null) {
            ListNode node=new ListNode(temp.val);
            node.next=dummy.next;
            dummy.next=node;
            temp=temp.next;

        }

        temp = head;
        temp1 = dummy.next;

        while (temp != null) {
            if (temp.val != temp1.val) {
                return false;
            }

            temp = temp.next;
            temp1 = temp1.next;
        }

        return true;
    }
}