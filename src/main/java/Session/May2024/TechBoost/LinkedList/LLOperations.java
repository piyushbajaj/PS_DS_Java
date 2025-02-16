package Session.May2024.TechBoost.LinkedList;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost.LinkedList
 * <p>
 * User: piyushbajaj
 * Date: 31/05/24
 * Time: 7:31 pm
 */
public class LLOperations {

    public void LLTraverse(LLNode head) {
        LLNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public LLNode insertBeforeNode(LLNode head, int val) {
        LLNode newNode = new LLNode(val);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public LLNode deleteBeforeNode(LLNode head) {
        if (head != null) {
            head = head.next;
        }
        return head;
    }

    public LLNode insertLast(LLNode head, int val) {
        LLNode newNode = new LLNode(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        LLNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    /**
     * Two Pointer Approach
     *
     * @param head
     * @return
     */
    public boolean isCircular(LLNode head) {
        if (head == null) {
            return false;
        }

        LLNode slow = head;
        LLNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    /**
     * Single Pointer Approach
     *
     * @param head
     * @return
     */
    public boolean isCircular1(LLNode head) {
        if (head == null) {
            return false;
        }

        LLNode newNode = head;

        while (newNode != null) {
            newNode = newNode.next;
            if (newNode == head) {
                return true;
            }
        }

        return false;
    }

    public LLNode getMiddleLL(LLNode head) {
        if (head == null) {
            return null;
        }

        LLNode slow = head;
        LLNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        LLOperations traversal = new LLOperations();
        LLNode newNode = new LLNode(1);
        newNode.next = new LLNode(2);
        System.out.println("Normal Traversal");
        traversal.LLTraverse(newNode);

        LLNode head = traversal.insertBeforeNode(newNode, 5);
        System.out.println("After inserting new node in the beginning");
        traversal.LLTraverse(head);

        LLNode head1 = traversal.insertLast(head, 10);
        System.out.println("After inserting new node in the end");
        traversal.LLTraverse(head1);


        LLNode circularLL = new LLNode(1);
        circularLL.next = new LLNode(2);
        circularLL.next.next = new LLNode(3);
        circularLL.next.next.next = circularLL;
        System.out.println("Is Linked List Circular");
        System.out.println(traversal.isCircular(circularLL));
        System.out.println(traversal.isCircular1(circularLL));

        System.out.println(traversal.getMiddleLL(head1).data);
    }
}
