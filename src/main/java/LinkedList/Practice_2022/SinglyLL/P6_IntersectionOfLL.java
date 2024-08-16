package LinkedList.Practice_2022.SinglyLL;

public class P6_IntersectionOfLL extends CommonUtils {
    public static void main(String[] args) {
        P6_IntersectionOfLL firstList = new P6_IntersectionOfLL();
        firstList.insertInEnd(1);
        firstList.insertInEnd(2);
        firstList.insertInEnd(3);
        firstList.insertInEnd(4);
        firstList.insertInEnd(5);
        firstList.insertInEnd(6);
        firstList.insertInEnd(7);
        firstList.printLL();

        P6_IntersectionOfLL secondList = new P6_IntersectionOfLL();
        secondList.insertInEnd(10);
        secondList.insertInEnd(20);
        secondList.insertInEnd(30);
        secondList.insertInEnd(40);
        secondList.insertInEnd(6);
        secondList.insertInEnd(7);
        secondList.printLL();

        System.out.println("Intersection of Linked List");
        System.out.println(firstList.intersectionOfLL(firstList.head, secondList.head));

        System.out.println(firstList.getIntersectionNode(firstList.head, secondList.head).data);

        System.out.println(firstList.intersectionOfLL_better(firstList.head, secondList.head).data);
    }

    public int intersectionOfLL(Node n1, Node n2) {
        int n1_count = countNodes(n1);
        int n2_count = countNodes(n2);

        if (n1_count > n2_count) {
            return getIntersectionOfLL(n1_count - n2_count, n1, n2);
        } else {
            return getIntersectionOfLL(n2_count - n1_count, n2, n1);
        }
    }

    public Node intersectionOfLL_better(Node n1, Node n2) {
        Node p1 = n1;
        Node p2 = n2;

        while (p1 != p2) {
            p1 = p1 == null ? n2 : p1.next;
            p2 = p2 == null ? n1 : p2.next;
        }

        return p1;
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        int countA = countNodes(headA);
        int countB = countNodes(headB);
        int diff = 0;
        if (countA > countB) {
            diff = countA - countB;
            while (headA != null && diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            diff = countB - countA;
            while (headB != null && diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != null && headB != null) {
            if (headA.data == headB.data) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public int getIntersectionOfLL(int d, Node n1, Node n2) {
        for (int i = 0; i < d; i++) {
            if (n1 != null) {
                n1 = n1.next;
            }
        }

        while (n1 != null && n2 != null) {
            if (n1.data == n2.data) {
                return n1.data;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return -1;
    }
}
