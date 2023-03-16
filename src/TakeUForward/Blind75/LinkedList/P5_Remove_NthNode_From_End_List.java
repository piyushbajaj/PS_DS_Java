package TakeUForward.Blind75.LinkedList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.LinkedList
 * <p>
 * User: piyushbajaj
 * Date: 26/02/23
 * Time: 1:21 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">...</a>
 */
public class P5_Remove_NthNode_From_End_List extends BaseListNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeIndexToRemove = countNodes(head) - n + 1;
        if (nodeIndexToRemove < 0) {
            return null;
        }

        ListNode temp = head;

        int count = 1;
        while (temp != null && temp.next != null && count + 1 <= nodeIndexToRemove) {
            if (count + 1 == nodeIndexToRemove) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
            count++;
        }

        if (count + 1 < nodeIndexToRemove) {
            return null;
        }

        return head;
    }


    public ListNode removeNthFromEnd_better(ListNode head, int n) {
        ListNode prev = new ListNode(-1);
        prev.next = head;

        // base
        if (head == null) {
            return null;
        }

        int nodeIndexToRemove = countNodes(head) - n;
        int count = 1;

        if (nodeIndexToRemove > 0) {
            while (head != null && head.next != null) {
                if (count == nodeIndexToRemove) {
                    head.next = head.next.next;
                    return prev.next;
                } else {
                    head = head.next;
                    count++;
                }
            }
        } else if (nodeIndexToRemove == 0) {
            return head.next;
        }

        return head;
    }

    public int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        P5_Remove_NthNode_From_End_List p5_remove_nthNode_from_end_list = new P5_Remove_NthNode_From_End_List();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        p5_remove_nthNode_from_end_list.printList(p5_remove_nthNode_from_end_list.removeNthFromEnd_better(listNode, 2));
    }
}
