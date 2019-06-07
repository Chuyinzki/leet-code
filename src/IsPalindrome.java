import Objects.ListNode;

public class IsPalindrome {

    //1->2->2->1 is true. Find O(n) time and O(1) space
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode headHolder = head;
        //find length
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        boolean hasMiddle = length % 2 != 0;
        int midpoint = length / 2;
        head = headHolder;
        for (int i = 1; i < midpoint; i++) {
            head = head.next;
        }

        ListNode tempHead = head;
        ListNode secondHead = hasMiddle ? head.next.next : head.next;
        secondHead = ReverseList.reverseList(secondHead);
        tempHead.next = null;
        while (headHolder != null) {
            if (headHolder.val != secondHead.val) {
                return false;
            }
            headHolder = headHolder.next;
            secondHead = secondHead.next;
        }
        return true;
    }
}
