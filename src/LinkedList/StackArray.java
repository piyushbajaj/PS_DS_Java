package LinkedList;

/**
 * Created by piyush.bajaj on 12/09/16.
 */
public class StackArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackArray(int s){
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j){
        stackArray[++top] = j;
    }

    public int pop(){
        return stackArray[top--];
    }

    public int peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public boolean isFull(){
        return (top == maxSize -1);
    }

    public static void main(String[] args) {
        StackArray SA = new StackArray(10);
        SA.push(10);
        SA.push(20);
        SA.push(30);
        SA.push(40);
        SA.push(50);
        System.out.println(SA.peek());
        System.out.println(SA.isFull());
        while (!SA.isEmpty()){
            int value = SA.pop();
            System.out.println(value);
            System.out.println(" ");
        }
        System.out.println("");
    }

}
