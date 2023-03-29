package TakeUForward.Blind75.LinkedList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.LinkedList
 * <p>
 * User: piyushbajaj
 * Date: 26/02/23
 * Time: 5:31 pm
 */
public class P6_Reorder_List extends BaseListNode {

    public static void main(String[] args) {
        P6_Reorder_List p6_reorder_list = new P6_Reorder_List();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);

        p6_reorder_list.reorderList(listNode);
        p6_reorder_list.printList(listNode);
    }

    /**
     * Approach:
     * 1. Get the middle node in the linked list
     * 2. Reverse the 2nd half of the linked list
     * 3. Merge both the list
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode listNode1 = head, preList = listNode1, temp = listNode1;
        ListNode listNode2 = getMiddleNode(head);

        while (temp.next != listNode2) {
            temp = temp.next;
        }
        temp.next = null;
        listNode2 = reverseLL(listNode2);

        // merge two list
//        while (listNode1 != null && listNode2 != null) {
//            listNode1.next = new ListNode(listNode2.val);
//            listNode1 = listNode1.next;
//            listNode2 = listNode2.next;
//        }

        while (listNode1 != null) {
            ListNode n1 = listNode1.next, n2 = listNode2.next;
            listNode1.next = listNode2;

            if (n1 == null) {
                break;
            }

            listNode2.next = n1;
            listNode1 = n1;
            listNode2 = n2;
        }
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head.next;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr.next;
    }

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
