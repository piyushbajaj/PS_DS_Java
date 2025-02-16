package Session.May2024.TechBoost.Arrays;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost.Arrays
 * <p>
 * User: piyushbajaj
 * Date: 17/06/24
 * Time: 9:11 am
 */
public class StackImplementation {
    private static int maxSize;
    private static int index;
    private static int[] arr;

    public StackImplementation(int max) {
        setMaxSize(max);
        setIndex(-1);
        arr = new int[maxSize];
    }

    public static int getMaxSize() {
        return maxSize;
    }

    public static void setMaxSize(int max) {
        maxSize = max;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int cnt) {
        index = cnt;
    }

    /**
     * TC: O(1)
     * SC: O(1)
     * @param val
     */
    public void pushElement(int val) {
        if (getIndex() == getMaxSize() - 1) {
            System.out.printf("Stack Overflow! Max Size Breached: %d", getMaxSize());
        } else {
            setIndex(getIndex() + 1);
            arr[getIndex()] = val;
            System.out.printf("Element: %d pushed into Stack %nCurrent Size: %d %nMax Size: %d %n", arr[getIndex()],
                getIndex() + 1, getMaxSize());
        }
        System.out.println();
    }

    public void printElements() {
        System.out.println("\nElements in the Array: " + Arrays.toString(arr) + "\n");
    }

    /**
     * TC: O(1)
     * SC: O(1)
     * @return
     */
    public int popElement() {
        if (getIndex() == -1) {
            System.out.println("Stack Underflow! Stack is Empty");
            return -1;
        } else {
            int val = arr[getIndex()];
            setIndex(getIndex() - 1);
            System.out.printf("Element: %d getting popped %nCurrent Size: %d%n", val, getIndex() + 1);
            System.out.println();
            return val;
        }

    }

    public static void main(String[] args) {
        StackImplementation stackImplementation = new StackImplementation(5);
        stackImplementation.pushElement(0);
        stackImplementation.pushElement(1);
        stackImplementation.pushElement(1);
        stackImplementation.pushElement(1);
        stackImplementation.pushElement(1);
        stackImplementation.pushElement(1);
        stackImplementation.printElements();

        stackImplementation.popElement();
        stackImplementation.popElement();
        stackImplementation.popElement();
    }
}
