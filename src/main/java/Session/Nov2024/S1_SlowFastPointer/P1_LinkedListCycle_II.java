package Session.Nov2024.S1_SlowFastPointer;
import Session.Util.ListNode;

/**
 * Project: DSAlgo
 * Package: Session.Nov2024.S1_SlowFastPointer
 * <p>
 * User: piyushbajaj
 * Date: 20/11/24
 * Time: 7:51 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/linked-list-cycle-ii/">...</a>
 */
public class P1_LinkedListCycle_II {

    /**
     * Definition for singly-linked list.
     */


    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        boolean loop = false;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                loop = true;
                break;
            }
        }

        if (loop) {
            slowPtr = head;
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            return slowPtr;
        }

        return null;
    }

    public static void main(String[] args) {
        P1_LinkedListCycle_II p1LinkedListCycleIi = new P1_LinkedListCycle_II();
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = listNode.next;

        ListNode output = p1LinkedListCycleIi.detectCycle(listNode);
        System.out.println(output != null ? output.val : null);
    }
}
