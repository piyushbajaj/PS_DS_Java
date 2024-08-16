package LinkedList.Practice_2022.SinglyLL;

public class P1_ReversalOfLL extends CommonUtils {
    public static void main(String[] args) {
        P1_ReversalOfLL reversalOfLL = new P1_ReversalOfLL();
        reversalOfLL.insertInEnd(1);
        reversalOfLL.insertInEnd(2);
        reversalOfLL.insertInEnd(3);
        reversalOfLL.insertInEnd(4);
        reversalOfLL.insertInEnd(5);
        reversalOfLL.insertInEnd(6);
        reversalOfLL.insertInEnd(7);
        reversalOfLL.printLL();

        System.out.println("Reversal of Linked List");
        reversalOfLL.reverseLinkedList();
        reversalOfLL.printLL();

        System.out.println("Reversal of Linked List with k node");
        Node newHead = reversalOfLL.reverseLinkedList(reversalOfLL.head, 2);
        reversalOfLL.printLL(newHead);
    }

    public void reverseLinkedList() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            // Reverse the current ptr to prev node
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node reverseLinkedList(Node nd, int k) {
        Node prev = null;
        Node curr = nd;
        while (k > 0) {
            Node next = curr.next;
            // Reverse the current ptr to prev node
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }
}
