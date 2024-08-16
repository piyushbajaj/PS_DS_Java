package LinkedList.Practice_2022.SinglyLL;

/**
 * Created by bajajp on 13 Sep, 2022
 */
public class P9_SwappingNodes extends CommonUtils {

    public static void main(String[] args) {
        P9_SwappingNodes swappingNodes = new P9_SwappingNodes();
        swappingNodes.insert(10, 0);
        swappingNodes.insert(20, 1);
        swappingNodes.insert(30, 2);
        swappingNodes.insert(40, 3);
        swappingNodes.insert(50, 4);

        swappingNodes.printLL(swappingNodes.head);

        swappingNodes.printLL(swappingNodes.swapNodes(swappingNodes.head, 1));

        ;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param head
     * @param k
     * @return
     */
    public Node swapNodes(Node head, int k) {
        int count = countNodes(head);
        Node start = head;
        Node end = head;

        int cntStart = 1;
        while (start != null && cntStart != k) {
            start = start.next;
            cntStart++;
        }

        int cntEnd = 1;
        while (end != null && cntEnd != count - k + 1) {
            end = end.next;
            cntEnd++;
        }

        if (start != null && end != null) {
            int temp = start.data;
            start.data = end.data;
            end.data = temp;
        }

        return head;
    }
}
