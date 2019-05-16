import Objects.ListNode;

public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = cur.next;
        prev.next = null;

        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }
        return prev;
    }
}
