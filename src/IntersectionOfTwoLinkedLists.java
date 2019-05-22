import Objects.ListNode;

public class IntersectionOfTwoLinkedLists {
    /*
    Write a program to find the node at which the intersection of two singly linked lists begins.

    For example, the following two linked lists:

    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗
    B:     b1 → b2 → b3

    begin to intersect at node c1.
    */

    //This is the plan:
    // 1. run to the end (c3)
    // 2. create a cycle from c3 to b1.
    // 3. use the algorithm we made to find the beginning of the cycle
    // 4. Remove the cycle (c3.next = null)
    // 5. Return our saved beginning of the cycle (c1)

    public ListNode findIntersection(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode aRunner = headA;
        ListNode bRunner = headB;
        while (aRunner.next != null) aRunner = aRunner.next;
        while (bRunner.next != null) bRunner = bRunner.next;
        if (bRunner != aRunner) return null;
        bRunner.next = headB;
        ListNode retNode = LinkedListCycleII.linkedListCycleII(headA);
        bRunner.next = null;
        return retNode;
    }
}
