package LinkedList;

/**
 * Created by piyush.bajaj on 27/11/16.
 */
public class PartitionLinkedList {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public void printList(Node Nd){
        while (Nd!=null){
            System.out.print(Nd.data + "->");
            Nd = Nd.next;
        }
        System.out.print("NULL");
    }

    public Node partition_LinkedList(int value){
        Node Nd = head;
        Node temp1 = null, temp2 = null;

        if(Nd==null)
            return null;

        while (Nd!=null){
            Node temp = Nd.next;
            if(Nd.data < value){
                Nd.next = temp1;
                temp1 = Nd;
            }
            else {
                Nd.next = temp2;
                temp2 = Nd;
            }
            Nd = temp;
        }

        head = temp1;
        while (temp1.next!=null){
            temp1 = temp1.next;
        }
        temp1.next = temp2;
        return head;

    }

    public static void main(String[] args) {
        PartitionLinkedList llist = new PartitionLinkedList();
        llist.head = new Node(10);
        llist.head.next = new Node(5);
        llist.head.next.next = new Node(1);
        llist.head.next.next.next = new Node(9);
        llist.head.next.next.next.next = new Node(2);
        llist.head.next.next.next.next.next = new Node(3);
        llist.head.next.next.next.next.next.next = new Node(5);
        llist.head.next.next.next.next.next.next.next = new Node(7);
        llist.head.next.next.next.next.next.next.next.next = new Node(13);
        llist.printList(llist.head);
        llist.printList(llist.partition_LinkedList(6));
    }


}
