package LinkedList.Practice_2022.SinglyLL;

public class P4_MergeTwoSortedLL extends CommonUtils {
    public static void main(String[] args) {
        P4_MergeTwoSortedLL firstList = new P4_MergeTwoSortedLL();
        P4_MergeTwoSortedLL finalList = new P4_MergeTwoSortedLL();
        firstList.insertInEnd(1);
        firstList.insertInEnd(2);
        firstList.insertInEnd(3);
        firstList.insertInEnd(4);
        firstList.insertInEnd(5);
        firstList.insertInEnd(6);
        firstList.insertInEnd(7);
        firstList.printLL();

        P4_MergeTwoSortedLL secondList = new P4_MergeTwoSortedLL();
        secondList.insertInEnd(10);
        secondList.insertInEnd(20);
        secondList.insertInEnd(30);
        secondList.insertInEnd(40);
        secondList.insertInEnd(50);
        secondList.insertInEnd(60);
        secondList.printLL();

        System.out.println("Merging two sorted linked list");
//        firstList.mergeTwoSortedLL(firstList.head, secondList.head);
        finalList.head = firstList.mergeSortedLL(firstList.head, secondList.head);
        finalList.printLL(finalList.head);
    }

    public Node mergeSortedLL(Node n1, Node n2) {
        Node n3PreHead = new Node(-1);

        Node prev = n3PreHead;

        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                prev.next = n1;
                n1 = n1.next;
            } else {
                prev.next = n2;
                n2 = n2.next;
            }
            prev = prev.next;
        }

        prev.next = n1 == null ? n2 : n1;

        return n3PreHead.next;
    }

    private void mergeTwoSortedLL(Node n1, Node n2) {
        if (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                head = new Node(n1.data);
                n1 = n1.next;
            } else {
                head = new Node(n2.data);
                n2 = n2.next;
            }
        }
        Node n3 = head;

        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                n3.next = new Node(n1.data);
                n1 = n1.next;
            } else {
                n3.next = new Node(n2.data);
                n2 = n2.next;
            }
            n3 = n3.next;
        }

        if (n1 != null) {
            n3.next = n1;
        }
        if (n2 != null) {
            n3.next = n2;
        }
    }
}
