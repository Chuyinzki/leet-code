import Objects.ListNode;

public class ConvertBinaryLinkedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(0);
        root.next.next = new ListNode(1);
        System.out.println(getDecimalValue(root)); //Should equal 5
    }

    public static int getDecimalValue(ListNode head) {
        ListNode traverse = head;
        if (traverse == null) {
            return 0;
        }
        int i = 0;
        while (traverse.next != null) {
            traverse = traverse.next;
            i++;
        }
        int ret = 0;
        traverse = head;
        while (traverse != null) {
            ret += traverse.val * Math.pow(2, i--);
            traverse = traverse.next;
        }
        return ret;
    }
}
