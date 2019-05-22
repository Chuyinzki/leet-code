import Objects.ListNode;

public class LinkedListCycleII {

    public ListNode linkedListCycleII(ListNode head) {
        if (head == null || head.next == null) return null;
        //find cycle
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast) {
            slow = slow.next;
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
        }
        while(head == slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
