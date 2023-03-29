package CrackingCoding.LinkedList.Jan_2018;

/**
 * Created by piyush.bajaj on 04/02/18.
 */
public class deleteMiddleNode_Prob {
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

    public static void deleteNode(Node Nd) {
        if (Nd == null) {
            return;
        }

        if (Nd.next != null) {
            Nd.data = Nd.next.data;
            Nd.next = Nd.next.next;
        } else {
            Nd = null;
        }

        printList(head);
    }

    public static void printList(Node Nd) {
        if (head == null) {
            return;
        }

        while (Nd != null) {
            System.out.print(Nd.data + " -> ");
            Nd = Nd.next;
        }

        System.out.print("NULL");
    }

    public static void main(String[] args) {
        //int count = getCount(head);
        int[] arr = {10, 2, 3, 4, 5, 19};
        head = createLL(arr);

        deleteNode(head.next);


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
