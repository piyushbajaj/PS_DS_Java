package Leetcode.Stack.Easy;

import java.util.Arrays;

public class StackFromArray {
    int index = -1;
    int[] arr;
    int maxCapacity = -1;

    StackFromArray(int capacity) {
        maxCapacity = capacity;
        arr = new int[capacity];
    }

    public static void main(String[] args) {
        StackFromArray stackFromArray = new StackFromArray(3);
        stackFromArray.push(1);
        stackFromArray.push(2);
        stackFromArray.push(3);
        stackFromArray.printArray();
        System.out.println("Peek element in Stack is: " + stackFromArray.peek());
        stackFromArray.push(4);
    }

    public void push(int data) {
        if (index >= maxCapacity - 1) {
            System.out.println("Stack is overflow");
            return;
        }
        arr[++index] = data;
    }

    public int pop() {
        if (index == -1) {
            System.out.println("Stack is underflow");
            return -1;
        }
        int popValue = arr[index];
        index--;
        return popValue;
    }

    public int peek() {
        return arr[index];
    }

    public void printArray() {
        System.out.println(Arrays.toString(arr));
    }
}
