package Session.Nov2024.S1_SlowFastPointer;

import Session.Util.ListNode;

/**
 * Project: DSAlgo
 * Package: Session.Nov2024.S1_SlowFastPointer
 * <p>
 * User: piyushbajaj
 * Date: 22/12/24
 * Time: 12:54 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/">...</a>
 */
public class P2_RemoveNthNodeFromEndList {

    /**
     * One Pass solution
     * TC: O(N)
     * SC: O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // create a gap of n nodes btw 2 pointers
        for (int i = 0; i <= n; i++) {
            second = second.next;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    public void printLL(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;

            if (node == null) {
                System.out.println("null");
            }
        }

    }

    public static void main(String[] args) {
        P2_RemoveNthNodeFromEndList p2RemoveNthNodeFromEndList = new P2_RemoveNthNodeFromEndList();

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        p2RemoveNthNodeFromEndList.printLL(node);

        p2RemoveNthNodeFromEndList.removeNthFromEnd(node, 2);

        p2RemoveNthNodeFromEndList.printLL(node);


    }
}
