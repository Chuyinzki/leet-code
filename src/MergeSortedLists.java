import Objects.ListNode;

import java.util.Arrays;
import java.util.List;

public class MergeSortedLists {

    //Input: 1->2->4, 5->3->4
    //Output: 1->1->2->3->4->4
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode ret = l1.val > l2.val ? l2 : l1;
        while (true) {
            if (l2.val >= l1.val) {
                if(l1.next != null && l1.next.val < l2.val) {
                    l1 = l1.next;
                    continue;
                }
                l2 = weave(l1,l2);
            } else {
                if(l2.next != null && l2.next.val < l1.val) {
                    l2 = l2.next;
                    continue;
                }
                l1 = weave(l2,l1);
            }
            if (l1 == null || l2 == null) break;
        }
        return ret;
    }

    public ListNode weave(ListNode l1, ListNode l2) {
        ListNode tempNextL1 = l1.next;
        if(tempNextL1 == null) {
            l1.next = l2;
            return null;
        }
        ListNode tempNextL2 = l2.next;
        l1.next = l2;
        l1.next.next = tempNextL1;

        l2 = tempNextL2;
        return l2;
    }
}
