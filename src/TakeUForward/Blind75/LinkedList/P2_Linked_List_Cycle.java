package TakeUForward.Blind75.LinkedList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.LinkedList
 * <p>
 * User: piyushbajaj
 * Date: 26/02/23
 * Time: 12:22 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/linked-list-cycle/">...</a>
 */
public class P2_Linked_List_Cycle extends BaseListNode {
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head.next;

        while (fastPtr != null && fastPtr.next != null) {
            if (slowPtr == fastPtr) {
                return true;
            }

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        P2_Linked_List_Cycle p2_linked_list_cycle = new P2_Linked_List_Cycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;

        System.out.println(p2_linked_list_cycle.hasCycle(head));
    }
}
