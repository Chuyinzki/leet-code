import Objects.ListNode;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode first = head;
        ListNode second = head;
        while(true) {
            if(second.next == null || second.next.next == null) return false;
            second = second.next.next;
            first = first.next;
            if(second == first) return true;
        }
    }
}
