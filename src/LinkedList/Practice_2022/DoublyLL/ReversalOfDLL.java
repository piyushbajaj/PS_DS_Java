package LinkedList.Practice_2022.DoublyLL;

/**
 * Created by bajajp on 21 May, 2022
 */
public class ReversalOfDLL extends BaseDLLNode {

    public Node insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

        return head;
    }

    public Node reverseDLL() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }

    public void printDLL() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        ReversalOfDLL reversalOfDLL = new ReversalOfDLL();
        reversalOfDLL.insert(1);
        reversalOfDLL.insert(2);
        reversalOfDLL.insert(3);
        reversalOfDLL.insert(4);
        reversalOfDLL.insert(5);

        reversalOfDLL.printDLL();

        System.out.println();

        reversalOfDLL.reverseDLL();

        reversalOfDLL.printDLL();

        System.out.println();


    }
}
