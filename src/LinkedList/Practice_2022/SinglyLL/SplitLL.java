package LinkedList.Practice_2022.SinglyLL;


/**
 * Created by bajajp on 30 May, 2022
 */
public class SplitLL extends CommonUtils {
    public Node[] splitListToParts(Node head, int k) {
        int n = countNodes(head);
        Node[] resultList = new Node[k];
        int count = 1;

        Node curr = head;

        if (k >= n) {
            int i = 0;
            while (curr != null) {
                resultList[i++] = new Node(curr.data);
                curr = curr.next;
            }
            while (i < k) {
                resultList[i++] = new Node();
            }
        } else {
            int parts = n / k;
            int maxSize = (n % k) + parts;

            for (int i = 0; i < parts; i++) {
                while (curr != null) {

                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {

    }
}
