package TakeUForward.Blind75.LinkedList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.LinkedList
 * <p>
 * User: piyushbajaj
 * Date: 26/02/23
 * Time: 12:47 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/merge-two-sorted-lists/">...</a>
 */
public class P3_Merge_Two_Sorted_List extends BaseListNode {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode(-1);
        ListNode temp = list3;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        }

        if (list2 != null) {
            temp.next = list2;
        }

        return list3.next;
    }

    public static void main(String[] args) {
        P3_Merge_Two_Sorted_List p3_merge_two_sorted_list = new P3_Merge_Two_Sorted_List();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.print("List1: ");
        p3_merge_two_sorted_list.printList(list1);

        System.out.println();
        System.out.print("List2: ");
        p3_merge_two_sorted_list.printList(list2);

        System.out.println();
        System.out.print("Merged List: ");
        p3_merge_two_sorted_list.printList(p3_merge_two_sorted_list.mergeTwoLists(list1, list2));
    }
}
