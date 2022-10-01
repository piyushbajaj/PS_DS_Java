package LinkedList.Practice_2022.SinglyLL;

public class FindNthNode extends CommonUtils {
    int count = 0;

    public int findNthNodeFromEnd(int index) {
        Node temp = head;
        int length = countNodes(head);

        int nodeIndex = length - index;

        int count = 0;
        while (temp != null) {
            if (count == nodeIndex) {
                return temp.data;
            }
            count++;
            temp = temp.next;
        }
        return -1;
    }

    public int findNthNodeFromEnd_recursion(Node node, int nthNode) {
        if (node != null) {
            findNthNodeFromEnd_recursion(node.next, nthNode);
            count++;
            if (count == nthNode) {
                return node.data;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindNthNode findNthNode = new FindNthNode();
        findNthNode.insertInEnd(1);
        findNthNode.insertInEnd(2);
        findNthNode.insertInEnd(3);
        findNthNode.insertInEnd(4);
        findNthNode.insertInEnd(5);
        findNthNode.insertInEnd(7);
        findNthNode.insertNodeInSortedLL(6);
        findNthNode.printLL();

        System.out.println("Find nth node from the end");
        System.out.println(findNthNode.findNthNodeFromEnd(6));

        System.out.println("Find nth node from the end using recursion");
        System.out.println(findNthNode.findNthNodeFromEnd_recursion(findNthNode.head, 2));
    }
}
