package LinkedList.Practice_2022.SinglyLL;

public class AdjacentNodesLL extends CommonUtils {
    private Node adjacentNode() {
        if (head == null) return null;

        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;

        while (curr != null && curr.next != null) {
            Node tmp = curr.next.next;
            curr.next.next = prev.next;
            prev.next = curr.next;
            curr.next = tmp;
            prev = curr;
            curr = prev.next;
        }
        head = dummy.next;
        return head;
    }

    public static void main(String[] args) {
        AdjacentNodesLL adjacentNodesLL = new AdjacentNodesLL();
        adjacentNodesLL.insertInEnd(1);
        adjacentNodesLL.insertInEnd(2);
        adjacentNodesLL.insertInEnd(3);
        adjacentNodesLL.insertInEnd(4);
        adjacentNodesLL.insertInEnd(5);
        adjacentNodesLL.insertInEnd(6);
        adjacentNodesLL.insertInEnd(7);
        adjacentNodesLL.printLL();

        System.out.println("Exchange of adjacent elements of Linked List");
        adjacentNodesLL.printLL(adjacentNodesLL.adjacentNode());
    }
}
