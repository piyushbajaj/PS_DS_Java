package LinkedList.Practice_2022.SinglyLL;

public class P7_FindLoop extends CommonUtils {
    public static void main(String[] args) {
        P7_FindLoop findLoop = new P7_FindLoop();
        findLoop.insertInEnd(1);
        findLoop.insertInEnd(2);
        findLoop.insertInEnd(3);
        findLoop.insertInEnd(4);
        findLoop.insertInEnd(5);
        findLoop.insertInEnd(7);
        findLoop.insertNodeInSortedLL(6);
        findLoop.printLL();
        System.out.println("Find loop in the linked list");
        findLoop.settingLoop(10);
        System.out.println(findLoop.findLoop());

        System.out.println(findLoop.findLoopNode());

        System.out.println(findLoop.findLoopNode());

        System.out.println(findLoop.countNodesInALoop());
    }

    public void settingLoop(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Linked List is Null terminated or ends in a cycle
    public boolean findLoop() {
        Node slowPtr = head;
        Node fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }

    // Find the starting loop node in the circular linked list
    public int findLoopNode() {
        Node slowPtr = head;
        Node fastPtr = head;
        boolean loop = false;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                loop = true;
                break;
            }
        }

        if (loop) {
            slowPtr = head;
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            return slowPtr.data;
        }

        return -1;
    }

    // If there is a cycle find the number of nodes in the loop
    public int countNodesInALoop() {
        Node slowPtr = head;
        Node fastPtr = head;
        boolean flag = false;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr.equals(fastPtr)) {
                flag = true;
                break;
            }
        }

        int count = 0;
        if (flag) {
            while (fastPtr.next != slowPtr) {
                fastPtr = fastPtr.next;
                count++;
            }
        }
        return count;
    }
}
