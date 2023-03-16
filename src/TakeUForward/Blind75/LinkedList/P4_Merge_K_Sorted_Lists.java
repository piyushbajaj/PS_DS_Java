package TakeUForward.Blind75.LinkedList;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.LinkedList
 * <p>
 * User: piyushbajaj
 * Date: 26/02/23
 * Time: 1:05 pm
 */
public class P4_Merge_K_Sorted_Lists extends BaseListNode {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        minHeap.addAll(Arrays.asList(lists));

        ListNode node = new ListNode(-1);
        ListNode temp = node;

        while (!minHeap.isEmpty()) {
            temp.next = minHeap.poll();
            temp = temp.next;
            if (temp.next != null) {
                minHeap.add(temp.next);
            }
        }

        return node.next;
    }

    public static void main(String[] args) {
        P4_Merge_K_Sorted_Lists p4_merge_k_sorted_lists = new P4_Merge_K_Sorted_Lists();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        p4_merge_k_sorted_lists.printList(p4_merge_k_sorted_lists.mergeKLists(new ListNode[] {listNode1, listNode2,
            listNode3}));


    }
}
