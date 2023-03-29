package Leetcode.LinkedList.Easy;

public class Loop_LL {
    Node head;

    public static void main(String[] args) {
        Loop_LL loop_ll = new Loop_LL();
        loop_ll.head = new Node(1);
        loop_ll.head.next = new Node(2);
        loop_ll.head.next.next = new Node(3);
        loop_ll.head.next.next.next = new Node(4);
        loop_ll.head.next.next.next.next = loop_ll.head.next;

        System.out.println("Loop exists? " + loop_ll.detectLoop(loop_ll.head));

        System.out.println("Number of nodes inside loop: " + loop_ll.countNumberOfNodesInsideLoop(loop_ll.head));
    }

    public boolean detectLoop(Node ptr) {
        if (ptr == null) {
            return false;
        }

        Node slow_ptr = ptr;
        Node fast_ptr = ptr.next;

        while (fast_ptr != null && fast_ptr.next != null) {
            if (slow_ptr == fast_ptr) {
                return true;
            }
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return false;
    }

    public int countNumberOfNodesInsideLoop(Node ptr) {
        if (ptr == null) {
            return -1;
        }

        Node slow_ptr = ptr;
        Node fast_ptr = ptr.next;

        while (fast_ptr != null && fast_ptr.next != null) {
            if (slow_ptr == fast_ptr) {
                break;
            }
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        Node loop_ptr = slow_ptr;
        slow_ptr = slow_ptr.next;
        int c = 0;
        while (loop_ptr != slow_ptr) {
            slow_ptr = slow_ptr.next;
            c++;
        }
        return c + 1;
    }

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
