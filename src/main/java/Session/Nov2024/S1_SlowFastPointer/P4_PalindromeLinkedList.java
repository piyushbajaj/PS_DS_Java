package Session.Nov2024.S1_SlowFastPointer;

import Session.Nov2024.S7_ReversalOfLL.P1_ReverseSinglyLL;
import Session.Util.ListNode;

/**
 * Project: DSAlgo
 * Package: Session.Nov2024.S1_SlowFastPointer
 * <p>
 * User: piyushbajaj
 * Date: 22/12/24
 * Time: 6:39 pm
 * <p>
 * Question: <a href="https://leetcode.com/problems/palindrome-linked-list/description/">...</a>
 */
public class P4_PalindromeLinkedList {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        P1_ReverseSinglyLL p1ReverseSinglyLL = new P1_ReverseSinglyLL();
        // slow reached middle of the linked list
        ListNode endOfFirstHalf = slow;
        ListNode secondHalf = p1ReverseSinglyLL.reverseList(slow.next);
        slow = head;
        fast = secondHalf;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
        P4_PalindromeLinkedList p4PalindromeLinkedList = new P4_PalindromeLinkedList();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(1);
        System.out.println(p4PalindromeLinkedList.isPalindrome(listNode));
    }
}
