package Leetcode.LinkedList.Easy;

public class Basic_LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node printList(Node start) {
        Node newNode = start;
        System.out.print("Linked List: ");
        while (newNode != null) {
            System.out.print(newNode.data + " -> ");
            newNode = newNode.next;
        }
        System.out.print("NULL");
        System.out.println();
        return start;
    }

    public int lengthOfLL(Node ptr) {
        if (ptr == null) {
            return 0;
        }
        int cnt = 0;
        while (ptr != null) {
            cnt++;
            ptr = ptr.next;
        }
        return cnt;
    }

    public int lengthOfLL_recur(Node ptr) {
        if (ptr == null) {
            return 0;
        }
        int len = lengthOfLL_recur(ptr.next);
        return len + 1;
    }

    public Node insertNodeInEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node ptr = head;

        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;
        return head;
    }

    public Node middleLinkedList(Node ptr) {
        if (ptr == null)
            return null;

        Node slow = ptr;
        Node fast = ptr.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null)
            return slow;
        else
            return slow.next;
    }

    public void removeDuplicates(Node ptr) {
        if (ptr == null)
            return;

        Node curr = ptr;

        while (curr != null) {
            Node temp = curr;

            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }

            curr.next = temp;
            curr = curr.next;
        }
    }


    public static void main(String[] args) {
        Basic_LinkedList basicLinkedList_ = new Basic_LinkedList();
        basicLinkedList_.insertNodeInEnd(1);
        basicLinkedList_.insertNodeInEnd(2);
        basicLinkedList_.insertNodeInEnd(2);
        basicLinkedList_.insertNodeInEnd(3);
        basicLinkedList_.insertNodeInEnd(3);
        basicLinkedList_.insertNodeInEnd(3);
        basicLinkedList_.insertNodeInEnd(3);
        basicLinkedList_.insertNodeInEnd(4);
        basicLinkedList_.insertNodeInEnd(4);

        basicLinkedList_.printList(basicLinkedList_.head);

        System.out.println("Length of Linked List: " +
            basicLinkedList_.lengthOfLL(basicLinkedList_.head));

        System.out.println("Length of Linked List in Recursive: " +
            basicLinkedList_.lengthOfLL_recur(basicLinkedList_.head));

        System.out.println("Middle of Linked List: " +
            basicLinkedList_.middleLinkedList(basicLinkedList_.head).data);

        basicLinkedList_.removeDuplicates(basicLinkedList_.head);

        basicLinkedList_.printList(basicLinkedList_.head);
    }
}
