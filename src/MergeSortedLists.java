import Objects.ListNode;

public class MergeSortedLists {

    //Input: 1->2->4, 5->3->4
    //Output: 1->1->2->3->4->4
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode retList = new ListNode(0);
        ListNode traverser = retList;
        while (true) {
            if (l1 == null) {
                traverser.next = l2;
                break;
            }
            if (l2 == null) {
                traverser.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                traverser.next = l1;
                l1 = l1.next;
            } else {
                traverser.next = l2;
                l2 = l2.next;
            }
            traverser = traverser.next;
        }
        return retList.next;
    }
}
