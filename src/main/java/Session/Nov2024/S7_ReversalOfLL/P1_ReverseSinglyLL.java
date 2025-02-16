package Session.Nov2024.S7_ReversalOfLL;

import Session.Util.ListNode;

/**
 * Project: DSAlgo
 * Package: Session.Nov2024.S7_ReversalOfLL
 * <p>
 * User: piyushbajaj
 * Date: 10/01/25
 * Time: 6:37 pm
 * Link: <a href="https://leetcode.com/problems/reverse-linked-list/">...</a>
 */
public class P1_ReverseSinglyLL {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode next = currNode.next;
            // switching the pointer back to prev
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }

        return prev;
    }

    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        P1_ReverseSinglyLL p1ReverseSinglyLL = new P1_ReverseSinglyLL();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.print("Linked List: ");
        p1ReverseSinglyLL.printList(listNode);
        System.out.println();

        System.out.print("Linked List after reversal: ");
        listNode = p1ReverseSinglyLL.reverseList(listNode);
        p1ReverseSinglyLL.printList(listNode);
    }
}
