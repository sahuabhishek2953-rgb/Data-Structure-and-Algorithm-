class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node temp1 = head;

        while (temp1 != null) {
            Node newNode = new Node(temp1.val);
            newNode.next = temp1.next;
            temp1.next = newNode;
            temp1 = newNode.next;
        }

        temp1 = head;

        while (temp1 != null) {
            if (temp1.random != null) {
                temp1.next.random = temp1.random.next;
            }
            temp1 = temp1.next.next;
        }

        Node head2 = head.next;
        temp1 = head;
        Node temp2 = head2;

        while (temp1 != null) {
            temp1.next = temp1.next.next;

            if (temp2.next != null) {
                temp2.next = temp2.next.next;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return head2;
    }
}