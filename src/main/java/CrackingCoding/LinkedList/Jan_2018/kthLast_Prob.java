package CrackingCoding.LinkedList.Jan_2018;

/**
 * Created by piyush.bajaj on 04/02/18.
 */
public class kthLast_Prob {
    static Node head;

    public static Node createLL(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return null;
        }

        Node Nd = head;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                Nd = new Node(arr[i]);
                head = Nd;
            } else {
                Nd.next = new Node(arr[i]);
                Nd = Nd.next;
            }
        }

        return head;
    }

    public static int getCount(Node Nd) {
        if (Nd == null) {
            return 0;
        }

        int count = 0;
        while (Nd != null) {
            count++;
            Nd = Nd.next;
        }

        return count;
    }

    //Find kth element from the last
    public static int findKthElement(int index) {
        Node Nd = head;
        int count = getCount(head);

        int diff = count - index;
        int cnt = 0;
        while (Nd != null) {
            if (cnt == diff) {
                return Nd.data;
            } else {
                Nd = Nd.next;
                cnt++;
            }
        }

        return -1;


    }

    public static void main(String[] args) {
        kthLast_Prob kth = new kthLast_Prob();
        //int count = getCount(head);
        int[] arr = {10, 2, 3, 4, 5, 19};
        head = createLL(arr);

        System.out.println(findKthElement(10));

    }

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
