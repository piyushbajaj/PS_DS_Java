package TakeUForward.Blind75.Heap;

import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Heap
 * <p>
 * User: piyushbajaj
 * Date: 25/01/23
 * Time: 9:44 am
 * <p>
 * Link: <a href="https://leetcode.com/problems/merge-k-sorted-lists/">...</a>
 */
public class P1_Merge_K_Sorted_Lists {
    public static void main(String[] args) {
        P1_Merge_K_Sorted_Lists p1_merge_k_sorted_lists = new P1_Merge_K_Sorted_Lists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode node = p1_merge_k_sorted_lists.mergeKLists(new ListNode[] {l1, l2, l3});
        p1_merge_k_sorted_lists.printList(node);
    }

    /**
     * Approach:
     * 1. First add all the list in the minimum PQ
     * 2. Then keep popping item from the minimum heap and keep adding to the linkedList.
     * <p>
     * Consider there are N lists
     * TC: O(NlogN): Adding N list to the PQ
     * SC: O(N)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode l : lists) {
            if (l != null) {
                priorityQueue.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!priorityQueue.isEmpty()) {
            point.next = priorityQueue.poll();
            point = point.next;
            ListNode next = point.next;
            if (next != null) {
                priorityQueue.add(next);
            }
        }
        return head.next;
    }

    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    static class ListNode {
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
