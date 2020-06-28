package CrackingCoding.LinkedList;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 22/11/16.
 */
public class Duplicacy {

    Node head;
    static class Node{
        char data;
        Node next;

        Node(char d){
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

    public void removeDuplicate(Node Nd){
        if(Nd==null)
            return;

        HashMap<Character, Boolean> hash = new HashMap<>();
        hash.put(Nd.data, true);
        while (Nd.next!=null){
            if(hash.containsKey(Nd.next.data)){
                Nd.next = Nd.next.next;
            }
            else {
                hash.put(Nd.next.data, true);
                Nd = Nd.next;
            }

        }
    }

    public void removeDuplicate_WithoutBuffer(Node Nd){
        if(Nd == null)
            return;

        Node current = head;
        while (current!=null){
            Node runner = current;

            while (runner.next!=null){
                if(runner.next.data==current.data){
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

    }

    public static void main(String[] args) {
        Duplicacy llist = new Duplicacy();
        llist.head = new Node('F');
        llist.head.next = new Node('O');
        llist.head.next.next = new Node('L');
        llist.head.next.next.next = new Node('L');
        llist.head.next.next.next.next = new Node('O');
        llist.head.next.next.next.next.next = new Node('W');
        llist.head.next.next.next.next.next.next = new Node(' ');
        llist.head.next.next.next.next.next.next.next = new Node('U');
        llist.head.next.next.next.next.next.next.next.next = new Node('P');
        System.out.println("Original Linked List is: ");
        llist.printList(llist.head);
        System.out.println("\n");
        //llist.removeDuplicate(llist.head);
        //System.out.println("After removing duplicate using hashing is: ");
        //llist.printList(llist.head);
        System.out.println("After removing duplicate without any buffer is: ");
        llist.removeDuplicate_WithoutBuffer(llist.head);
        llist.printList(llist.head);
    }
}
