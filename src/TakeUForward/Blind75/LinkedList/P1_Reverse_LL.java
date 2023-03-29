package TakeUForward.Blind75.LinkedList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.LinkedList
 * <p>
 * User: piyushbajaj
 * Date: 26/02/23
 * Time: 8:37 am
 */
public class P1_Reverse_LL extends BaseListNode {

    public static void main(String[] args) {
        P1_Reverse_LL p1_reverse_ll = new P1_Reverse_LL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        p1_reverse_ll.printList(p1_reverse_ll.reverseList(head));

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
