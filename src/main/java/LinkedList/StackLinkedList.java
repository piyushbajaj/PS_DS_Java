package LinkedList;

/**
 * Created by piyush.bajaj on 12/09/16.
 */
public class StackLinkedList {


    public static void main(String[] args) {
        LinkListStack st = new LinkListStack();

        st.push(50);
        st.push(70);
        st.push(190);
        st.peek();
        st.displayStack();
        st.pop();
        st.displayStack();


    }

    public static class Node {
        int data;
        Node next;


        public Node(int data) {
            this.data = data;
        }

        public void displayNode() {
            System.out.println(data);
            System.out.println(" ");
        }
    }

    public static class LinkedList {
        private Node head = null;

        public void insertFirst(int data) {
            Node n = new Node(data);
            n.next = head;
            head = n;
        }

        public Node deleteFirst() {
            head = head.next;
            return head;
        }


        public void displayList() {
            Node current = head;
            while (current != null) {
                current.displayNode();
                current = current.next;
            }
        }

        public boolean isEmpty() {
            return (head == null);
        }


    }

    public static class LinkListStack {

        LinkedList li = new LinkedList();

        public void push(int data) {
            li.insertFirst(data);
        }

        public void push_ch(char ch) {
            li.insertFirst(ch);
        }

        public void popAll() {
            while (!li.isEmpty()) {
                li.deleteFirst();
            }
        }

        public void pop() {
            li.deleteFirst();
        }

        public void peek() {
            System.out.println(li.head.data);
        }

        public void displayStack() {
            System.out.println("  ");
            li.displayList();
        }
    }
}

