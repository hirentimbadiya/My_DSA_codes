public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;

        // this also reverses the remaining k elements so we have to modify it
        while (true) {
            ListNode last = prev;
            ListNode newEnd = present;
            ListNode Next = present.next;
            // reverse between left and right
            for (int i = 0; present != null && i < k; i++) {
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
            if (present == null) {
                break;
            }
            prev = newEnd;
        }

        return head;
    }

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

    public static void main(String[] args) {

    }
}
