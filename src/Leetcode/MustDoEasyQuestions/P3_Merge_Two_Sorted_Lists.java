package Leetcode.MustDoEasyQuestions;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 30/12/22
 * Time: 12:13 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/merge-two-sorted-lists/">...</a>
 * Pattern: Linked List
 */
public class P3_Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        P3_Merge_Two_Sorted_Lists p3_merge_two_sorted_lists = new P3_Merge_Two_Sorted_Lists();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        p3_merge_two_sorted_lists.printList(list1);
        p3_merge_two_sorted_lists.printList(list2);

        p3_merge_two_sorted_lists.printList(p3_merge_two_sorted_lists.mergeTwoLists(list1, list2));
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3;
        ListNode head;

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        list3 = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list3.next = list1;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list2 = list2.next;
            }
            list3 = list3.next;
        }

        while (list1 != null) {
            list3.next = list1;
            list1 = list1.next;
            list3 = list3.next;
        }

        while (list2 != null) {
            list3.next = list2;
            list2 = list2.next;
            list3 = list3.next;
        }

        return head;
    }

    public void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
