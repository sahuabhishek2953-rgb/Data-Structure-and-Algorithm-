
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        if(head.next==null) return null;
        while(fast.next.next !=null && fast.next.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;

        }
        slow.next=slow.next.next;
        return head;
        
    }
}