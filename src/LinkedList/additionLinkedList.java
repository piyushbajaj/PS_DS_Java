package LinkedList;

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
        //LinkedList.Node result = new LinkedList.Node(5, null, null);

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
                //new_Node = new LinkedList.Node(temp%10);
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

        //LinkedList.Node result = new LinkedList.Node(carry);

        int val = carry;
        if(N1!=null)
            val += N1.data;
        if(N2!=null)
            val += N2.data;

        Node result = new Node(val%10);

        //result.data = val%10;



        if(N1!=null || N2!=null || val >= 10){
            Node more = additionTwoLL_recur(N1==null? null : N1.next, N2==null? null : N2.next, val >= 10 ? 1 : 0);
            more.next = result;
            result = more;
        }
        return result;

    }



    //practice

    public void additionTwoLL_recur_Prac(Node N1, Node N2){

        Node temp = null;
        while (N1.next!=null){
            N1 = N1.next;
        }

        while (N2.next!=null){
            N2 = N2.next;
        }

        temp.data = N1.data + N2.data;

        //LinkedList.Node N3 = new LinkedList.Node()

    }

    public static int carry = 0;
    Node N3 = null;
    public Node additionTwoLL_recur_Prac_Util(Node N1, Node N2){
        if (N1.next!=null || N2.next!=null) {
            if (N1.next != null) {
                N1 = N1.next;
            }
            if (N2.next != null) {
                N2 = N2.next;
            }
            N3 = additionTwoLL_recur_Prac_Util(N1, N2);
        }

            int temp = N1.data + N2.data + carry;
            carry = temp/10;
            temp = temp%10;
        Node result = new Node(temp);
        if(N3 == null)
            N3 = result;
        else
            N3.next = result;

        return N3;
        //}
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
        llist1.printList(llist1.head);

        //llist1.additionTwoLL_recur_Prac_Util(llist1.head, llist2.head);

        //llist1.additionTwoLL_recur(llist1.head, llist2.head, 0);
    }
}
