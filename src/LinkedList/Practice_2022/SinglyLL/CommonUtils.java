package LinkedList.Practice_2022.SinglyLL;

public class CommonUtils extends BaseNode {

    public void insert(int data, int pos) {
        Node toAdd = new Node(data);
        if (head == null) {
            if (pos == 0) {
                head = toAdd;
            }
            return;
        }

        if (pos == 0) {
            toAdd.next = head;
            head = toAdd;
            return;
        }

        Node prev = head;
        for (int i = 0; i < pos - 1; i++) {
            if (prev == null) return;
            prev = prev.next;
        }

        toAdd.next = prev.next;
        prev.next = toAdd;
    }

    public void delete(int pos) {
        if (head == null) return;

        if (pos == 0) {
            head = head.next;
        }
        Node prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }

        if (prev.next == null) return;

        prev.next = prev.next.next;
    }

    // TC: O(1)
    public void insertInStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // TC: O(N)
    public void insertInEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printLL(Node nd) {
        Node temp = nd;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int countNodes(Node node) {
        if (node == null) return 0;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    public void insertNodeInSortedLL(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        Node curr = null;
        while (temp.next != null && temp.data < newNode.data) {
            curr = temp;
            temp = temp.next;
        }
        if (curr != null) {
            curr.next = newNode;
            newNode.next = temp;
        }
    }

    public static void main(String[] args) {
        CommonUtils commonUtils = new CommonUtils();
        commonUtils.insert(10, 0);
        commonUtils.insert(20, 1);
        commonUtils.insert(30, 2);
        commonUtils.insert(40, 3);
        commonUtils.insert(50, 4);

        commonUtils.printLL();

        commonUtils.delete(0);
        commonUtils.printLL();

        commonUtils.delete(2);
        commonUtils.printLL();
    }
}
