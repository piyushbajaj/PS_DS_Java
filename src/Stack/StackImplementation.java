package Stack;

/**
 * Created by piyush.bajaj on 29/11/16.
 */
public class StackImplementation {
    Node top;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }


    int pop(){
        if(top!=null){
            int item = top.data;
            top = top.next;
            return item;
        }
        return -1;
    }

    void push(int item){
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    int peek(){
        return top.data;
    }

    void displayStack(){
        Node Nd = top;
        while (Nd!=null){
            System.out.print(Nd.data + " -> ");
            Nd = Nd.next;
        }
        System.out.println(" ");
    }


    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation();
        stack.push(50);
        stack.push(70);
        stack.push(190);
        System.out.println(stack.peek());
        stack.displayStack();
        System.out.println(stack.pop());
        stack.displayStack();
    }
}
