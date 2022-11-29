public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        // rotate the list for the k % length times
        while (k % length > 0) {
            head = rotate(head);
            k--;
        }
        return head;
    }

    public ListNode rotate(ListNode head) {
        ListNode tailprev = null;
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
            tailprev = (tailprev == null) ? head : tailprev.next;
        }
        tail.next = head;
        tailprev.next = null;
        head = tail;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
