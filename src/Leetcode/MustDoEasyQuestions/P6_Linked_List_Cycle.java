package Leetcode.MustDoEasyQuestions;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 30/12/22
 * Time: 2:33 pm
 * <p>
 * Pattern: Linked List
 */
public class P6_Linked_List_Cycle {
    public static void main(String[] args) {

    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // Base Condition
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow_ptr = head;
        ListNode fast_ptr = slow_ptr.next.next;

        while (fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;

            if (slow_ptr == fast_ptr) {
                return true;
            }
        }

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
