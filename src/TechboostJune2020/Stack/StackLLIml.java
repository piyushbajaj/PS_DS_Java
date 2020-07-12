package TechboostJune2020.Stack;

public class StackLLIml{

    Node head;
    static class Node{
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //static int count = 0;

    //LL: there is no barrier of capacity
    public void push(int data) {
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public int pop() {
        if(head == null) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }

        int temp = head.data;
        head = head.next;

        return temp;
    }

    public int peek() {
        if(head == null) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }

        return head.data;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public static void main(String[] args) {
        StackLLIml stackLLIml = new StackLLIml();
        stackLLIml.push(10);
        stackLLIml.push(20);
        stackLLIml.push(30);
        stackLLIml.push(40);

        System.out.println("Popping the top most element " + stackLLIml.pop());
        System.out.println("Popping the top most element " + stackLLIml.pop());
        System.out.println("Popping the top most element " + stackLLIml.pop());

        System.out.println("The top most element: " + stackLLIml.peek());
        System.out.println("Popping the top most element " + stackLLIml.pop());
        System.out.println("Popping the top most element " + stackLLIml.pop());
    }


}