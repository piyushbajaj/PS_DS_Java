package TechBoost_Old;

/**
 * Created by piyush.bajaj on 18/03/18.
 */
public class Stack_LL_Prob {
    Node head;

    public static void main(String[] args) {
        Stack_LL_Prob ss = new Stack_LL_Prob();
        ss.push(1);
        ss.push(2);

        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
    }

    void push(int x) {
        Node p = new Node(x);
        if (head == null) {
            head = p;
            return;
        }
        p.next = head;
        head = p;
    }

    int pop() {
        if (head == null) {
            return -1;
        }

        int temp = head.data;
        head = head.next;
        return temp;


    }

    boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
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
