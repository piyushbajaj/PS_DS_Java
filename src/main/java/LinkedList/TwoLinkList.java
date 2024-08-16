package LinkedList;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 08/10/16.
 */
public class TwoLinkList {
    Node head1; //head of the list
    Node head2;
    Node head;

    public static void main(String[] args) {
        TwoLinkList tl = new TwoLinkList();
        tl.head1 = new Node(1);
        tl.head1.next = new Node(2);
        tl.head1.next.next = new Node(3);
        tl.head1.next.next.next = new Node(4);
        tl.head1.next.next.next.next = new Node(8);
        tl.head2 = new Node(2);
        tl.head2.next = new Node(4);
        tl.head2.next.next = new Node(6);
        tl.head2.next.next.next = new Node(7);
        tl.head2.next.next.next.next = new Node(8);
        tl.intersectionTwoLinkedList(tl.head1, tl.head2);
        tl.intersectionTwoLinkedList_Hash(tl.head1, tl.head2);
        System.out.println(
            "The node of intersection is " + tl.intersectionTwoLinkedList_improvedSpace(tl.head1, tl.head2));

        tl.intersectionTwoLinkedList_CommonNode(tl.head1, tl.head2);
        //tl.printList();
    }

    public void intersectionTwoLinkedList(Node Nd1, Node Nd2) {
        Node temp1 = Nd1;
        Node temp2 = Nd2;

        while (temp1 != null) {
            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    System.out.println("Both the linked list are matching at this point: " + temp1.data);
                    return;
                } else {
                    temp2 = temp2.next;
                }
            }
            temp1 = temp1.next;
            temp2 = Nd2;
        }
        System.out.println("Both the linked list are not matching at any point");
        return;
    }

    public void intersectionTwoLinkedList_Hash(Node Nd1, Node Nd2) {

        HashMap<Integer, Boolean> hash = new HashMap<>();
        while (Nd1 != null) {
            hash.put(Nd1.data, true);
            Nd1 = Nd1.next;
        }

        while (Nd2 != null) {
            if (hash.containsKey(Nd2.data)) {
                System.out.println("Both the linked list are matching at this point: " + Nd2.data);
                return;
            } else {
                Nd2 = Nd2.next;
            }
        }
    }

    public int intersectionTwoLinkedList_improvedSpace(Node Nd1, Node Nd2) {
        int count1 = getCount(Nd1);
        int count2 = getCount(Nd2);
        int diff = 0;
        if (count1 > count2) {
            diff = count1 - count2;
            return getIntersectionPoint(diff, Nd1, Nd2);
        } else {
            diff = count2 - count1;
            return getIntersectionPoint(diff, Nd2, Nd1);
        }
    }

    public int getIntersectionPoint(int d, Node temp1, Node temp2) {
        for (int i = 0; i < d; i++) {
            temp1 = temp1.next;
        }

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                return temp1.data;
            } else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        System.out.println("Linked list are not matching at any point: SORRY");
        return -1;
    }

    public int getCount(Node Nd) {
        int count = 0;
        while (Nd != null) {
            count++;
            Nd = Nd.next;
        }
        return count;
    }

    //IntersectionLinkedList: Common Nodes will be printed as Linked List

    public void push(int data) {


        Node new_node = new Node(data);

        new_node.next = head;
        head = new_node;


    }

    public void intersectionTwoLinkedList_CommonNode(Node temp1, Node temp2) {
        Node intersect_node = head;
        if (temp1 == null || temp2 == null) {
            return;
        }

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                Node new_node = new Node(temp1.data);
                if (intersect_node == null) {
                    intersect_node = new_node;
                    System.out.println(intersect_node.data);
                } else {
                    intersect_node.next = new_node;
                    System.out.println(intersect_node.next.data);
                }
                //System.out.println(intersect_node.data);
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else if (temp1.data < temp2.data) {
                temp1 = temp1.next;
            } else if (temp2.data < temp1.data) {
                temp2 = temp2.next;
            }
        }
        return;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    /* Linked List LinkedList.Node*/
    static class Node {
        int data;
        Node next;

        //Constructor to create a new node
        //Next is by default initialized as null

        Node(int d) {
            data = d;
            next = null;
        }
    }

}
