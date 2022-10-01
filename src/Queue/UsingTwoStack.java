package Queue;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 11/12/16.
 */
public class UsingTwoStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int data){
        stack1.push(data);
    }

    public int dequeue(){
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

//    public int display_QueueList(){
//        while (!stack1.empty()) {
//            return display_QueueList;
//                    stack1.pop();
//        }
//    }

    public static void main(String[] args) {
        UsingTwoStack US = new UsingTwoStack();
        US.enqueue(5);
        US.enqueue(10);
        System.out.println("Removing one item from Queue is: " + US.dequeue());
    }
}
