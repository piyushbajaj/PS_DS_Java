package Stack.Practice_2022;

import java.util.Arrays;

public class StackFromArray {
    int[] stackArray;
    int capacity;
    int count = 0;

    StackFromArray(int maxCapacity) {
        this.capacity = maxCapacity;
        this.stackArray = new int[maxCapacity];
    }

    public static void main(String[] args) {
        StackFromArray stackFromArray = new StackFromArray(5);
        stackFromArray.push(1);
        stackFromArray.push(2);
        stackFromArray.push(3);
        stackFromArray.push(4);
        stackFromArray.push(5);
        stackFromArray.push(6);

        System.out.println("Peek Element: " + stackFromArray.peek());

        System.out.println(stackFromArray);

        System.out.println(stackFromArray.pop());
        System.out.println(stackFromArray.pop());
        System.out.println(stackFromArray.pop());

        System.out.println("Peek Element: " + stackFromArray.peek());
        System.out.println(stackFromArray.pop());
        System.out.println("Peek Element: " + stackFromArray.peek());
        System.out.println(stackFromArray.pop());
        System.out.println("Peek Element: " + stackFromArray.peek());
        System.out.println(stackFromArray.pop());

        System.out.println("Peek Element: " + stackFromArray.peek());
    }

    // TC: O(1)
    public void push(int x) {
        if (count >= capacity) {
            System.out.println("Stack Overflow");
            return;
        }

        this.stackArray[count++] = x;
    }

    // TC: O(1)
    public Integer pop() {
        if (count <= 0) {
            System.out.println("Stack Underflow");
            return null;
        }
        int popElement = this.stackArray[--count];
        this.stackArray[count] = 0;
        return popElement;
    }

    // TC: O(1)
    public Integer peek() {
        if (count <= 0) {
            System.out.println("Stack Underflow");
            return null;
        }

        return this.stackArray[count - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(this.stackArray);
    }
}
