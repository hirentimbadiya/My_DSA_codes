public class ReverseLL2_92 {

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

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right)
                return head;

            ListNode present = head;
            ListNode prev = null;

            // skip the first left-1 nodes

            for (int i = 0; present != null && i < left - 1; i++) {
                prev = present;
                present = present.next;
            }

            ListNode last = prev;
            ListNode newEnd = present;
            ListNode Next = present.next;
            // reverse between left and right
            for (int i = 0; present != null && i < right - left + 1; i++) {
                present.next = prev;
                prev = present;
                present = Next;
                if (Next != null)
                    Next = Next.next;
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = present;

            return head;

        }
    }
}
