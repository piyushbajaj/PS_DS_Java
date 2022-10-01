package LinkedList.Practice_2022.SinglyLL;

public class P2_MiddleOfLL extends CommonUtils{
    private int getMiddleLL() {
        if (head == null) {
            return -1;
        }

        Node slowPtr = head;
        Node fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr.data;
    }

    public static void main(String[] args) {
        P2_MiddleOfLL middleOfLL = new P2_MiddleOfLL();
        middleOfLL.insertInEnd(1);
        middleOfLL.insertInEnd(2);
        middleOfLL.insertInEnd(3);
        middleOfLL.insertInEnd(4);
        middleOfLL.insertInEnd(5);
        middleOfLL.insertInEnd(6);
        middleOfLL.insertInEnd(7);
        middleOfLL.printLL();

        System.out.println("Middle of Linked List");
        System.out.println(middleOfLL.getMiddleLL());
    }
}
