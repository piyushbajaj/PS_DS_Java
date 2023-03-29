package LinkedList;

/**
 * Created by piyush.bajaj on 17/10/16.
 */
public class MergeSortLinkledList {

    Node head;

    public static void main(String[] args) {
        MergeSortLinkledList ms = new MergeSortLinkledList();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.printList(ms.head);

        System.out.println("\n");

        System.out.println("Check whether the linked list has even number: ");

        System.out.println(ms.isEven(ms.head));

        System.out.println("After merge sort: ");

        Node sortedList = ms.mergeSort(ms.head);

        ms.printList(sortedList);


    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    void push(int value) {
        Node new_node = new Node(value);

        new_node.next = head;
        head = new_node;
    }

    public Node middleNode(Node Nd) {
        Node slow_ptr = Nd;
        Node fast_ptr = Nd;

        while (fast_ptr.next != null && fast_ptr.next.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }

        return slow_ptr;
    }

    public Node mergeSort(Node Nd) {
        if (Nd == null || Nd.next == null) {
            return Nd;
        }

        Node mid = middleNode(Nd);
        //LinkedList.Node a = Nd;
        Node nextOfMiddle = mid.next;
        mid.next = null;

        Node left = mergeSort(Nd);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = sortedMerge(left, right);
        return sortedList;
    }

    public Node sortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        if (a.data < b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

    //Checking if the linked list is having Even no. of nodes or Odd.
    public boolean isEven(Node Nd) {
        while (Nd != null && Nd.next != null) {
            Nd = Nd.next.next;
        }
        if (Nd == null) {
            return true;
        } else {
            return false;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
