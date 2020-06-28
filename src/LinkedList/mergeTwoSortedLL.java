package LinkedList;

/**
 * Created by piyush.bajaj on 17/03/17.
 */
public class mergeTwoSortedLL {
    Node head;

    static class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void mergeTwoLL(Node Nd1, Node Nd2){
        //LinkedList.Node start;
        //LinkedList.Node merge_ptr = null;
        if(Nd1.data <= Nd2.data){
            head = Nd1;
            Nd1 = Nd1.next;
        }
        else {
            head = Nd2;
            Nd2 = Nd2.next;
        }
        Node merge_ptr = head;

        while (Nd1!=null && Nd2!=null){
            if(Nd1.data <= Nd2.data){
//                LinkedList.Node new_node = new LinkedList.Node(Nd1.data);
//                merge_ptr = new_node;
                merge_ptr.next = Nd1;
                Nd1 = Nd1.next;
            }
            else {
                //LinkedList.Node new_node = new LinkedList.Node(Nd2.data);
                merge_ptr.next = Nd2;
                Nd2 = Nd2.next;
            }
            merge_ptr = merge_ptr.next;
        }


    }

    public void printlist(){
        Node temp = head;

        while (temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        mergeTwoSortedLL mg = new mergeTwoSortedLL();
        mergeTwoSortedLL lg = new mergeTwoSortedLL();

        mg.head = new Node(2);
        mg.head.next = new Node(4);
        mg.head.next.next = new Node(5);
        mg.head.next.next.next = new Node(6);
        mg.head.next.next.next.next = new Node(8);
        mg.head.next.next.next.next.next = new Node(9);

        lg.head = new Node(1);
        lg.head.next = new Node(3);
        lg.head.next.next = new Node(7);

        mg.mergeTwoLL(mg.head, lg.head);

        mg.printlist();
    }
}
