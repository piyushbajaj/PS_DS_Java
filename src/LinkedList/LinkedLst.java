package LinkedList;

import java.lang.*;
/**
 * Created by piyush.bajaj on 16/07/16.
 */
public class LinkedLst {
    Node head; //head of the list


    /* Linked List LinkedList.Node*/
    static class Node
    {
        int data;
        Node next;

        //Constructor to create a new node
        //Next is by default initialized as null

        Node(int d){
            data = d;
            next = null;
        }
    }



    /* method to create a simple linked list with 3 nodes*/
    public static void main(String[] args) {
        LinkedLst llist = new LinkedLst();
        LinkedLst llist1 = new LinkedLst();
        LinkedLst llist2 = new LinkedLst();
        LinkedLst mergelist = new LinkedLst();
        LinkedLst llist3 = new LinkedLst();
        LinkedLst llist4 = new LinkedLst();

        LinkedLst circularList = new LinkedLst();
        //assigning values
        llist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        //Now we need to link all the nodes one by one

        llist.head.next = second;
        second.next = third;

        llist.push(0);
        llist.printList();
        System.out.print("\n");
        llist.insertAfter(llist.head, 4);
        llist.append(10);
        llist.printList();
        System.out.print("\n");
        llist.deleteNode(10);
        llist.printList();
        System.out.print("\n");
        llist.deleteNodeatPosition(7);
        llist.printList();
        System.out.print("\n");
        System.out.print("Number of nodes: " + llist.CountNodes());
        System.out.print("\n");
        llist.deletefirst();
        llist.printList();
        System.out.print("\n");
        llist.head = llist.deletefirst(llist.head);
        llist.printList();
        System.out.print("\n");
        llist.SwapNode(1, 3);
        llist.printList();
        System.out.print("\n");

        llist1.push(3);
        llist1.push(2);
        llist1.push(1);
        llist1.push(0);
        llist1.printList();

        System.out.print("\n");

        llist2.push(6);
        llist2.push(5);
        llist2.push(4);
        llist2.push(3);
        llist2.printList();

        System.out.print("\n");
        mergelist.mergeLinkedLst(llist1.head, llist2.head);

        mergelist.printList();

        System.out.print("\n");

        llist.detectAndRemoveLoop(llist.head);

        llist.printList();

        System.out.println("List 1: ");
        llist1.printList();

        System.out.println("List 2: ");
        llist2.printList();



        llist3.head = llist3.addTwoLists(llist1.head, llist2.head);

        System.out.println("After addition of both the list is: ");

        System.out.print("\n");
        llist3.printList();
        //System.out.println(llist.head.data + "->" + second.data + "->" + third.data);

        System.out.print("\n");

        llist4.push(60);
        llist4.push(50);
        llist4.push(40);
        llist4.push(30);
        llist4.push(20);
        llist4.push(10);
        llist4.printList();

        System.out.print("\n");

        llist4.head = llist4.rotate(llist4.head, 4);
        //llist4.printList();

        circularList.push(60);
        circularList.push(50);
        circularList.push(40);
        circularList.push(30);
        circularList.push(20);
        circularList.push(10);

        /*
        circularList.listCircular(circularList.head);
        circularList.printCircularList(circularList.head);

        System.out.print("\n");

        System.out.print("Orignal Linked List");
        circularList.printCircularList(circularList.head);

        System.out.print("\n");

        circularList.SplitCircularlist();

        circularList.printCircularList(head1);

        circularList.printCircularList(head2);

        */

    }



    /* Adds contents of two linked lists and return the head node of resultant list */
    public Node addTwoLists(Node first, Node second) {
        LinkedLst llist3 = new LinkedLst();
        int sum1 =0;
        int sum2 =0;
        int sum3 =0;
        //LinkedList.Node n = head;
        while(first!=null){
            sum1 = sum1 + first.data;
            first = first.next;
        }

        while(second!=null){
            sum2 = sum2 + second.data;
            second = second.next;
        }
        sum3 = sum1 + sum2;

        int length = String.valueOf(sum3).length();
        //System.out.println(length);
        int a = 0;
        while (length > 0) {
            int power = (int) Math.pow(10,(length-1));
            a = sum3 / power;
            llist3.push(a);
            sum3 = sum3 % 10;
            length = length-1;
            //n = n.next;
            //System.out.print(sum3 % 10 + "\n");
            //sum3 = sum3 / 10;


        }

        return llist3.head;
    }

    // This function rotates a linked list counter-clockwise
    // and updates the head. The function assumes that k is
    // smaller than size of linked list. It doesn't modify
    // the list if k is greater than or equal to size
    public Node rotate(Node Nd, int k){
        int count =0;


        Node temp;
        while(count!=k){
            Nd = Nd.next;
            count++;
        }

        Node n = Nd;
        Nd.next = head;
        head = n.next;


        temp = head;
        head = Nd;
        Nd.next = null;
        while(n.next!=null){
            n = n.next;
        }
        n.next = temp;

        return head;

    }


    public void mergeLinkedLst(Node first, Node second){
        LinkedLst mergelist = new LinkedLst();

        Node n1 = first;
        Node n2 = second;
        /*
        if(first.head.data <= second.head.data)
            mergelist.push(first.head.data);
        else if(second.head.data <= first.head.data)
            mergelist.push(second.head.data);
        */
        while(n1!=null){
            if(n1.data <= n2.data) {
                mergelist.push(n1.data);
                n1 = n1.next;
            }
            else {
                mergelist.push(n2.data);
                n2 = n2.next;
            }
        }
        while(n2!=null){
            if( n1 == null){
                mergelist.push(n2.data);
                n2 = n2.next;
            }
            else if(n1.data <= n2.data) {
                mergelist.push(n1.data);
                n1 = n1.next;
            }

        }
        mergelist.printList();
    }


    /* This function prints contents of linked list starting from head */
    public void printList(){
        Node n = head;
        while(n!=null){
            System.out.print(n.data + " ");
            n=n.next;
        }
        System.out.println();

    }

    //Add a node at the front: (A 4 steps process)

    public void push(int new_data){
        //Declare a new node & assign a value
        Node new_node = new Node(new_data);
        //Now point next of new_node to Head
        new_node.next = head;
        //Now store the address of new node on Head, since the new_node is Head now
        head = new_node;
    }

    /* Note: One important thing you have to note here is that the TIME COMPLEXITY is O(1) as it does constant amount of work. */

    /*
    Add a node after a given node: (5 steps process)
    We are given pointer to a node, and the new node is inserted after the given node.
    */

    /* This function is in LinkedList.LinkedList class.
   Inserts a new node after the given prev_node. This method is
   defined inside LinkedList.LinkedList class shown above */

    public void insertAfter(Node prev_node, int new_data)
    {
        /* 1. Check if the given LinkedList.Node is null */
        if(prev_node == null){
        System.out.println("The Given previous LinkedList.Node is NULL, so not going further");
        return;
        }

        /* 2. Allocate the LinkedList.Node &
           3. Put in the data*/

        Node new_node = new Node(new_data);

        //4. Make next of new LinkedList.Node as next of prev_node (Now point the next of new_node to next node)
        new_node.next = prev_node.next;

        //5. make next of prev_node as new_node
        prev_node.next = new_node;

        /*
        Time complexity of insertAfter() is O(1) as it does constant amount of work.
         */

    }

    //Add a node at the end: (6 steps process)

    /* Appends a new node at the end.  This method is
   defined inside LinkedList.LinkedList class shown above */

    public void append(int new_data) {
    /* 1. Allocate the LinkedList.Node &
       2. Put in the data
       3. Set next as null */

        Node new_node = new Node(new_data);

        /* 4. If the Linked List is empty, then make the
           new node as head */
        if(head == null) {
            head.next = new_node;
            //new_node.next = null; well by default any new node next will be NULL only
            return;
        }
        /*
        If the linked list is not empty, we have to traverse till the end
         */
        Node last = head;
        while(last.next!=null){
            last= last.next;
        }
        last.next = new_node;
        return;

        /*Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head to end, the function does O(n) work.
                This method can also be optimized to work in O(1) by keeping an extra pointer to tail of linked list/

        Following is a complete program that uses all of the above methods to create a linked list.*/

    }

    /*
    To delete a node from linked list, we need to do following steps.
    1) Find previous node of the node to be deleted.
    2) Changed next of previous node.
    3) Free memory for the node to be deleted.
     */

    /* Given a key, deletes the first occurrence of key in linked list */
    public void deleteNode(int key){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = head, prev = null;

        //If the Head is the key to be deleted

        if(temp!=null && temp.data ==key){
            head = temp.next;
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next

        while(temp!=null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }

        if(temp==null) {
            System.out.println("Key is not found");
            return;
        }

        prev.next = temp.next;
        //LinkedList.Node delete_node = new LinkedList.Node(key); - Every node has a different address, so this was incorrect

        //Now we have to traverse the linked list

        /*
        LinkedList.Node n = head;
        while(n.next!=delete_node){
            n=n.next;
        }
        n.next = delete_node.next;
        delete_node.next = null;
        */
    }


    /* Given a reference (pointer to pointer) to the head of a list
       and a position, deletes the node at the given position */
    void deleteNodeatPosition(int position)
    {
        Node temp = head;

        //if the linked list is empty
        if (head==null)
            return;

        //if its the position in the list to be deleted
        if(position==0){
            head = temp.next;
            return;
        }

        // Find previous node of the node to be deleted
        for(int i=0; temp!=null && i < position - 1; i++){
            temp = temp.next;
        }

        //if the position is more than the number of nodes does
        if(temp==null || temp.next == null)
            return;

        // LinkedList.Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        //Unlink the pointer
        temp.next = next;
    }

    /*
    Count the number of nodes present in the given linkedlist
     */

    public int CountNodes(){
        int count = 0;
        Node n = head;
        while(n!=null){
            count++;
            n=n.next;
        }
        return count;
    }

    /*
    Deleting the first node encountered in the linked list
     */
    public void deletefirst(){
        if(head == null)
            return;
        head = head.next;
    }

    /*
    Deleting using node value
     */

    public Node deletefirst(Node head){
        if(head == null)
            return head;
        head = head.next;
        return head;
    }

    public void SwapNode(int first, int second){
        if (first == second)
            return;

        Node curr1 = head, prev1 = null;

        while(curr1!=null && curr1.data != first){
            prev1 = curr1;
            curr1 = curr1.next;
        }

        Node curr2 = head, prev2 = null;
        while(curr2!=null && curr2.data != second){
            prev2 = curr2;
            curr2 = curr2.next;
        }

        //if swapping nodes are head nodes or not, we need to modify the prev pointers
        if(prev1!=null)//this means its not a head node
            prev1.next = curr2;
        else
            head = curr2;

        if(prev2!=null)
            prev2.next = curr1;
        else
            head = curr1;

        ///now swap the next pointers
        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;
    }


    // Function that detects loop in the list
    public Node detectAndRemoveLoop(Node node) {
        Node n1 = head;
        Node n = head;
        while(n1!=null){
            while(n!=null){
                if(n1!=n.next)
                    n=n.next;
                else{
                    n.next = null;
                    return n;
                }

            }
            n1=n1.next;
            n= n1;
        }
        return n;
    }



}
