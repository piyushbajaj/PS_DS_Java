package HitBullseye.S6_LinkedList.L2;

/**
 * Project: DSAlgo
 * Package: HitBullseye.S6_LinkedList.L2
 * <p>
 * User: piyushbajaj
 * Date: 18/05/25
 * Time: 8:00 pm
 * <p>
 * Link: <a href="https://takeuforward.org/data-structure/reverse-a-doubly-linked-list/">...</a>
 */
public class P4_ReverseDLL {

//    DLLNode head;
//
//    P4_ReverseDLL(DLLNode next) {
//        head = next;
//    }

    public static class DLLNode {
        int data;
        DLLNode prev, next;

        DLLNode(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    public DLLNode reverseDll(DLLNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        DLLNode prev = null;
        DLLNode curr = head;

        while (curr != null) {
            // store the previous pointer
            prev = curr.prev;
            // now make current previous point to current next
            curr.prev = curr.next;

            // make the current next point to previous
            curr.next = prev;

            // move ahead
            curr = curr.prev;
        }

        return prev.prev;
    }

    public static void main(String[] args) {
        P4_ReverseDLL reverseDLL = new P4_ReverseDLL();

    }
}
