package Leetcode.MustDoEasyQuestions;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 30/12/22
 * Time: 6:17 pm
 * <p>
 * Pattern: Linked List
 * lc: <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/description/">...</a>
 */
public class P8_Intersection_Of_Linked_Lists {

    /**
     * Definition for singly-linked list.
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countNodeHeadA = 0, countNodeHeadB = 0;
        ListNode listNodeA = headA;
        ListNode listNodeB = headB;

        if (headA == null) {
            return null;
        }

        if (headB == null) {
            return null;
        }

        while (listNodeA != null) {
            countNodeHeadA++;
            listNodeA = listNodeA.next;
        }

        while (listNodeB != null) {
            countNodeHeadB++;
            listNodeB = listNodeB.next;
        }

        int diff = 0;
        if (countNodeHeadA > countNodeHeadB) {
            diff = countNodeHeadA - countNodeHeadB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }

        } else {
            diff = countNodeHeadB - countNodeHeadA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
