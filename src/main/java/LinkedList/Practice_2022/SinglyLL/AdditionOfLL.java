package LinkedList.Practice_2022.SinglyLL;

public class AdditionOfLL extends CommonUtils {
    public static void main(String[] args) {
        AdditionOfLL additionOfLL = new AdditionOfLL();
        AdditionOfLL firstList = new AdditionOfLL();
        firstList.insertInEnd(7);
        firstList.insertInEnd(5);
        firstList.insertInEnd(9);
        firstList.insertInEnd(4);
        firstList.insertInEnd(6);
//        firstList.insertInEnd(6);
//        firstList.insertInEnd(7);
        firstList.printLL();

        AdditionOfLL secondList = new AdditionOfLL();
        secondList.insertInEnd(8);
        secondList.insertInEnd(4);
//        secondList.insertInEnd(4);
//        secondList.insertInEnd(40);
//        secondList.insertInEnd(6);
//        secondList.insertInEnd(7);
        secondList.printLL();

        Node newNode = additionOfLL.additionOfLL(firstList.head, secondList.head);
        additionOfLL.printLL(newNode);

    }

    public Node additionOfLL(Node n1, Node n2) {
        Node newHead = null;
        Node ptr = null;
        int sum = 0, carry = 0, value = 0;
        while (n1 != null && n2 != null) {
            sum = carry + n1.data + n2.data;
            carry = sum / 10;
            value = sum % 10;
            n1 = n1.next;
            n2 = n2.next;

            if (newHead == null) {
                newHead = new Node(value);
                ptr = newHead;
            } else {
                ptr.next = new Node(value);
                ptr = ptr.next;
            }
        }

        while (n1 != null) {
            sum = carry + n1.data;
            carry = sum / 10;
            value = sum % 10;
            n1 = n1.next;

            if (newHead == null) {
                newHead = new Node(value);
                ptr = newHead;
            } else {
                ptr.next = new Node(value);
                ptr = ptr.next;
            }
        }

        while (n2 != null) {
            sum = carry + n2.data;
            carry = sum / 10;
            value = sum % 10;
            n2 = n2.next;

            if (newHead == null) {
                newHead = new Node(value);
                ptr = newHead;
            } else {
                ptr.next = new Node(value);
                ptr = ptr.next;
            }
        }

        return newHead;
    }
}
