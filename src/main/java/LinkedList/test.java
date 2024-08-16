package LinkedList;

/**
 * Created by piyush.bajaj on 29/06/17.
 */
public class test {
    Node head;

    public static void main(String[] args) {
        test llist = new test();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);
        llist.printList();
        llist.deleteItem(4);
        llist.printList();
//        llist.swapNodes(2, 3);
//        llist.printList();
        llist.reverseLinkedList();
        llist.printList();
    }

    public void push(int key) {
        Node new_node = new Node(key);
        Node nd = head;
        if (nd == null) {
            nd = new_node;
            head = nd;
        } else {
            while (nd.next != null) {
                nd = nd.next;
            }
            nd.next = new_node;
        }
    }

    //Inserting at a given position
    public void push_after_given_pos(int key, int pos) {
        Node new_node = new Node(key);
        Node nd = head;
        int count = 1;
        if (nd == null) {
            nd = new_node;
            head = nd;
        } else {
            while (nd.next != null) {
                if (pos == 1) {
                    new_node.next = head;
                    head = new_node;
                    System.exit(1);
                } else if (pos == count) {


                }
                count++;
                nd = nd.next;
            }
            nd.next = new_node;
        }
    }

    public void printList() {
        Node Nd = head;
        while (Nd != null) {
            System.out.print(Nd.data + " -> ");
            Nd = Nd.next;
        }
        System.out.println("NULL");

    }

    public void deleteItem(int key) {
        Node nd = head;
        while (nd.next != null) {
            if (nd.next.data == key) {
                nd.next = nd.next.next;
            } else {
                nd = nd.next;
            }
        }
    }

    public void swapNodes(int key1, int key2) {
        Node Nd = head;
        Node temp1 = null, temp2 = null;
        while (Nd.next != null) {
            if (Nd.next.data == key1) {
                temp1 = Nd.next;
                if (temp2 != null) {
                    temp2.next = Nd.next.next;
                    Nd.next = temp2;
                }
            } else if (Nd.next.data == key2) {
                temp2 = Nd.next;
                if (temp1 != null) {
                    temp1.next = Nd.next.next;
                    Nd.next = temp1;
                }
            }
            Nd = Nd.next;
        }

        Nd = head;
        while (Nd.next != null) {
            if (Nd.next.data == key1) {
                //temp1 = Nd.next;
                if (temp2 != null) {
                    temp2.next = Nd.next.next;
                    Nd.next = temp2;
                }
            }
            Nd = Nd.next;
        }

    }

    public void reverseLinkedList() {
        Node prev = null;
        Node curr = head;
        Node next = null;
        Node Nd = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            //Nd = Nd.next;
        }
        head = prev;
        return;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
