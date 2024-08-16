package CrackingCoding.LinkedList.Jan_2018;

/**
 * Created by piyush.bajaj on 25/02/18.
 */
public class sumOfLinkedList_Prob {
    static Node head1, head2, head3;

    public static Node createLL1(String s) {
        int n = s.length();
        if (n == 0) {
            return null;
        }

        Node Nd = head1;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (Nd == null) {
                Nd = new Node(temp);
                head1 = Nd;
            } else {
                Nd.next = new Node(temp);
                Nd = Nd.next;
            }
        }

        return head1;
    }

    public static Node createLL2(String s) {
        int n = s.length();
        if (n == 0) {
            return null;
        }

        Node Nd = head2;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (Nd == null) {
                Nd = new Node(temp);
                head2 = Nd;
            } else {
                Nd.next = new Node(temp);
                Nd = Nd.next;
            }
        }

        return head2;
    }

    public static void printList(Node Nd) {
        if (Nd == null) {
            return;
        }

        while (Nd != null) {
            System.out.print(Nd.data + " -> ");
            Nd = Nd.next;
        }

        System.out.print("NULL");
        System.out.println();
    }

    public static int getCount(Node Nd) {
        if (Nd == null) {
            return 0;
        }
        int count = 0;
        while (Nd != null) {
            Nd = Nd.next;
            count++;
        }

        return count;
    }

    public static Node additionTwoLinkedList(Node Nd1, Node Nd2) {
        if (head1 == null) {
            return Nd2;
        }

        if (head2 == null) {
            return Nd1;
        }

        Node p = head3;

        int sum = 0, carry = 0;

        while (Nd1 != null && Nd2 != null) {
            sum = Nd1.data + Nd2.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (head3 == null) {
                p = new Node(sum);
                head3 = p;
            } else {
                p.next = new Node(sum);
                p = p.next;
            }
            Nd1 = Nd1.next;
            Nd2 = Nd2.next;
        }

        while (Nd1 != null && Nd2 == null) {
            sum = Nd1.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (p == null) {
                p = new Node(sum);
            } else {
                p.next = new Node(sum);
                p = p.next;
            }
            Nd1 = Nd1.next;
        }

        while (Nd1 == null && Nd2 != null) {
            sum = Nd2.data + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (p == null) {
                p = new Node(sum);
            } else {
                p.next = new Node(sum);
                p = p.next;
            }
            Nd2 = Nd2.next;
        }

        return head3;
    }

    public static void main(String[] args) {
        String s1 = "10000";
        String s2 = "1";
        Node Nd1 = createLL1(s1);
        Node Nd2 = createLL2(s2);

        printList(Nd1);
        printList(Nd2);


        printList(additionTwoLinkedList(Nd1, Nd2));


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
