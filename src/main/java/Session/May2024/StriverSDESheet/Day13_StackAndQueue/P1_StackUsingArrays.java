package Session.May2024.StriverSDESheet.Day13_StackAndQueue;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriverSDESheet.Day13_StackAndQueue
 * <p>
 * User: piyushbajaj
 * Date: 20/07/24
 * Time: 7:28 pm
 */
public class P1_StackUsingArrays {
    private final int[] arr;
    private int top;

    public P1_StackUsingArrays(int capacity) {
        arr = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (top >= arr.length) {
            return;
        }
        top++;
        arr[top] = x;
    }

    public int pop() {
        if (top < 0) {
            return -1;
        }

        return arr[top--];
    }

    public int peek() {
        if (top < 0) {
            return -1;
        }

        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public void stackElements() {
        System.out.println("Current stack elements: ");
        for (int i = top; i >= 0; i--) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        P1_StackUsingArrays p1StackUsingArrays = new P1_StackUsingArrays(5);
        System.out.println("Current size of the stack: " + p1StackUsingArrays.size());
        p1StackUsingArrays.push(6);
        p1StackUsingArrays.push(3);
        p1StackUsingArrays.stackElements();
        System.out.println("Popped top element from the top: " + p1StackUsingArrays.pop());
        p1StackUsingArrays.stackElements();
        System.out.println("Current size of the stack: " + p1StackUsingArrays.size());

    }
}
