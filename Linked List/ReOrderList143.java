public class ReOrderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = middle(head);
        ListNode hs = reverse(mid);
        ListNode hf = head;

        // reaarange
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        if (hf != null) {
            hf.next = null;
        }
    }

    public ListNode reverse(ListNode head) {
        // take 3 pointers prev , pres , next
        ListNode prev = null;
        ListNode pres = head;
        ListNode Next = pres.next;

        while (pres != null) {
            // for revesing pres.next to prev , then move prev , pres and next.
            pres.next = prev;
            prev = pres;
            pres = Next;
            if (Next != null) {
                // check the null pointer exception
                Next = Next.next;
            }
        }
        // at the end make head to prev
        head = prev;
        // return head
        return head;
    }

    public ListNode middle(ListNode head) {
        // here midPrev is starting from null
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            // at first we will assign midPrev to head and then with every loop midPrev.next
            midPrev = (midPrev != null) ? midPrev.next : head;
            head = head.next.next;
        }

        // now making mid = midPrev.next
        ListNode mid = midPrev.next;
        // now cutting from midPrev
        midPrev.next = null;

        return mid;
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
