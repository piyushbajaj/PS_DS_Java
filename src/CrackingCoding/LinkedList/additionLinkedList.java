package CrackingCoding.LinkedList;

/**
 * Created by piyush.bajaj on 28/11/16.
 */
public class additionLinkedList {
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
        System.out.println("NULL");
    }

    public void additionTwoLL(Node N1, Node N2){
        if(N1==null || N2 == null){
            System.out.println("Linked List is itself empty");
            return;
        }
        int d=0;
        //Node result = new Node(5, null, null);

        Node Nd = null, p1=null;



        int temp, k;
        while(N1!= null && N2!=null){
            temp = N1.data + N2.data + d;
            k = temp%10;



            if(temp >=10) {
                d = temp/10;
                Node new_Node = new Node(k);
                Nd = new_Node;
                //new_Node.data = k;
                //new_Node = new Node(temp%10);
                //new_Node.next.data = temp%10;
                //Nd.next = new_Node;
                if(p1==null)
                    p1 = Nd;
                else
                    p1.next = Nd;
                //new_Node = new_Node.next.next;
                Nd = Nd.next;
            }
            else {
                d = 0;
                Node new_Node = new Node(temp);
                if(Nd==null)
                    Nd = new_Node;
                else
                    Nd.next = new_Node;

                if(p1==null)
                    p1 = Nd;
                else
                    p1.next = Nd;
                //new_Node.data = temp;
                //new_Node = new_Node.next;
                Nd = Nd.next;
            }
            N1 = N1.next;
            N2 = N2.next;
            p1 = p1.next;
            //head = new_Node;
        }
        head = p1;


    }

    public Node additionTwoLL_recur(Node N1, Node N2, int carry){
        if(N1==null && N2==null && carry==0) {
            System.out.println("Linked List is itself empty");
            return null;
        }

        Node result = new Node(carry);

        int val = carry;
        if(N1!=null)
            val += N1.data;
        if(N2!=null)
            val += N2.data;

        //Node new_node = new Node(val%10);

        result.data = val%10;



        if(N1!=null || N2!=null || val >= 10){
            Node more = additionTwoLL_recur(N1==null? null : N1.next, N2==null? null : N2.next, val >= 10 ? 1 : 0);
            result.next = more;
            result = result.next;
        }
        return result;

    }


    public static void main(String[] args) {
        additionLinkedList llist1 = new additionLinkedList();
        additionLinkedList llist2 = new additionLinkedList();
        llist1.head = new Node(1);
        llist1.head.next = new Node(5);
        llist1.head.next.next = new Node(1);
        llist2.head = new Node(9);
        llist2.head.next = new Node(2);
        llist2.head.next.next = new Node(3);
        System.out.println("First Linked List is: ");
        llist1.printList(llist1.head);
        System.out.println("Second Linked List is: ");
        llist2.printList(llist2.head);
        llist1.additionTwoLL(llist1.head, llist2.head);

        //llist1.additionTwoLL_recur(llist1.head, llist2.head, 0);
    }
}
