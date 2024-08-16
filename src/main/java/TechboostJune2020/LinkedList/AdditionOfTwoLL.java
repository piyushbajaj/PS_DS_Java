package TechboostJune2020.LinkedList;

/*
Q2. Addition of Linked List (carry forward)
5->6->7->1->2->NULL
6->3->5->9->NULL
Output:
6->3->0->7->1->NULL

Pseudo Code:
1. Reverse both linked list
2. Then start adding with sum and carry, till we reach to the end of list.
 */


public class AdditionOfTwoLL {
    Node head;

    public static void main(String[] args) {
        AdditionOfTwoLL list1 = new AdditionOfTwoLL();
        AdditionOfTwoLL list2 = new AdditionOfTwoLL();

        AdditionOfTwoLL list_result = new AdditionOfTwoLL();

        Node head1 = new Node(5);
        list1.addToTheLast(head1);
        list1.addToTheLast(new Node(6));
        list1.addToTheLast(new Node(7));
        list1.addToTheLast(new Node(1));
        list1.addToTheLast(new Node(2));
        System.out.print("List1: ");
        list1.printList(head1);

        head1 = list1.reverse(head1);
        System.out.print("Reverse List1: ");
        list1.printList(head1);

        Node head2 = new Node(6);
        list2.addToTheLast(head2);
        list2.addToTheLast(new Node(3));
        list2.addToTheLast(new Node(5));
        list2.addToTheLast(new Node(9));
        System.out.print("List2: ");
        list2.printList(head2);

        head2 = list2.reverse(head2);
        System.out.print("Reverse List2: ");
        list2.printList(head2);

        Node output = list_result.additionOfLL(head1, head2);

        output = list_result.reverse(output);

        System.out.print("Sum of Linked List: ");
        list_result.printList(output);
    }

    //TC: O(N)
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
        }
    }

    public Node reverse(Node Nd) {
        if (Nd == null) {
            return null;
        }

        Node prev = null;
        Node curr = Nd;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Nd = prev;
        return Nd;
    }

    //T.C: O(N), if n > m, or O(M), if m > n
    //S.C: O(1)
    public Node additionOfLL(Node Nd1, Node Nd2) {
        int carry = 0, sum = 0, count = 0;

        Node new_Node = null;

        Node temp1 = null;

        if (Nd1 == null) {
            return Nd2;
        }
        if (Nd2 == null) {
            return Nd1;
        }

        while (Nd1 != null || Nd2 != null) {
            sum = carry;
            count++;
            if (Nd1 != null) {
                sum = sum + Nd1.data;
                Nd1 = Nd1.next;
            }
            if (Nd2 != null) {
                sum = sum + Nd2.data;
                Nd2 = Nd2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            if (count == 1) {
                temp1 = new Node(sum);
                new_Node = temp1;
            } else {
                Node tempSumNode = new Node(sum);
                temp1.next = tempSumNode;
                temp1 = temp1.next;
            }
        }

        if (carry != 0) {
            Node tempSumNode = new Node(carry);
            temp1.next = tempSumNode;
        }
        return new_Node;
    }


    public void printList(Node Nd) {
        while (Nd != null) {
            System.out.print(Nd.data + "->");
            Nd = Nd.next;
        }
        System.out.println("NULL");
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
