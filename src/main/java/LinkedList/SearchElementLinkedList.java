package LinkedList;

/**
 * Created by piyush.bajaj on 05/10/16.
 */
public class SearchElementLinkedList {
    Node head;

    public static void main(String[] args) {
        SearchElementLinkedList llist = new SearchElementLinkedList();
        llist.head = new Node(1);
        llist.head.next = new Node(2);
        llist.head.next.next = new Node(4);
        llist.head.next.next.next = new Node(5);
        //llist.head.next.next.next.next = new LinkedList.Node(4);
        //llist.head.next.next.next.next = new LinkedList.Node(5);
        llist.printList();
        System.out.println("\n");
        //System.out.println(llist.search(0));
        //System.out.println(llist.search_recursive(llist.head, 1));
        //llist.returnNthNode(3);
        //llist.middleLinkedList();
        llist.middleLinkedList_shortcut();
        //llist.intOccursLinkedList(4);
        //llist.insertInSortedLL(3);
        llist.printList();
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public boolean search(int val) {
        Node n = head;
        while (n.data != val && n.next != null) {
            n = n.next;
        }
        if (n.data == val) {
            return true;
        } else {
            return false;
        }
    }

    //Using Recursive

    public boolean search_recursive(Node Nd, int val) {
        if (Nd == null) {
            return false;
        } else if (Nd.data == val) {
            return true;
        }
        return search_recursive(Nd.next, val);
    }


    //A function to get nth node in a linked list

    public void returnNthNode(int index) {
        int count = 0;
        Node n = head;
        while (n != null) {
            if (index == count) {
                System.out.println("Value at the index postion is: " + n.data);
                System.exit(1);
            } else {
                n = n.next;
                count++;
            }
        }
        System.out.println("Index is out of range");
    }

    public boolean evenOdd(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Find a middle of a linked-list
    public void middleLinkedList() {
        int count = 0;
        int mid;
        Node n = head;
        while (n != null) {
            count++;
            n = n.next;
        }
//        if(evenOdd(count)){
//            mid = count/2 + 1;
//        }
//        else
        mid = count / 2 + 1;
        n = head;
        int i = 1;
        while (n != null) {
            if (i == mid) {
                System.out.println("Middle Value of a linked list is: " + n.data);
                break;
            } else {
                i++;
                n = n.next;

            }
        }

    }

    /* Function to print middle of linked list */
    public void middleLinkedList_shortcut() {
        Node slow_pointer = head;
        Node fast_pointer = head;

        while (fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
        }

        System.out.println("Middle of a linked list is: " + slow_pointer.data);
    }

    //Function that counts number of times int occurs in the linked list
    public void intOccursLinkedList(int value) {
        int count = 0;
        Node n = head;
        while (n != null) {
            if (n.data == value) {
                count++;
                n = n.next;
            } else {
                n = n.next;
            }
        }
        System.out.println("The number of times " + value + " occurs in a linked list is: " + count);

    }

    //Function to insert a node in between a linked list which is already sorted

    public void insertInSortedLL(int value) {
        Node n = head;
        Node new_node = new Node(value);
        while (n != null) {
            if (value <= head.data) {
                new_node.next = head;
                head = new_node;
                break;
            } else if (value >= n.data && value < n.next.data) {
                new_node.next = n.next;
                n.next = new_node;
                break;
            }
            n = n.next;
        }
    }

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
