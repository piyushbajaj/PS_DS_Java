package TechboostJune2020.LinkedList;

public class ReverseLL {
    Node head;

    static class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void printList(Node temp){
        Node Nd = temp;

        if(Nd == null)
            return;

        while (Nd!=null) {
            System.out.print(Nd.data + "-> ");
            Nd = Nd.next;
        }
        System.out.print("null");
        System.out.println();

    }

    public Node reverse(Node Nd){
        if(Nd == null)
            return null;

        Node prev = null;
        Node curr = Nd;
        Node next = null;

        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Nd = prev;
        return Nd;
    }



    public static void main(String[] args) {
        ReverseLL reverseLL = new ReverseLL();
        reverseLL.head = new Node(1);
        reverseLL.head.next = new Node(2);
        reverseLL.head.next.next = new Node(3);
        reverseLL.head.next.next.next = new Node(4);
        reverseLL.head.next.next.next.next = new Node(5);
        reverseLL.head.next.next.next.next.next = new Node(6);
        reverseLL.head.next.next.next.next.next.next = new Node(7);
        reverseLL.head.next.next.next.next.next.next.next = new Node(8);
        reverseLL.head.next.next.next.next.next.next.next.next = new Node(9);
        reverseLL.head.next.next.next.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked List are: ");
        reverseLL.printList(reverseLL.head);

        System.out.println("Reversing link list: ");

        //System.out.println("Linked  after reversing are: ");
        reverseLL.printList(reverseLL.reverse(reverseLL.head));
    }
}
