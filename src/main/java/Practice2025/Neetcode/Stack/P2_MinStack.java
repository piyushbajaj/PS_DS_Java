package Practice2025.Neetcode.Stack;

import java.util.ArrayList;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.Stack
 * <p>
 * User: piyushbajaj
 * Date: 24/07/25
 * Time: 11:18 am
 * <p>
 * Algo:
 * 1. Need to maintain two arraylist, once for storing elements as its getting added
 * 2. As elements are getting added to normal arraylist, will keep adding minimum element
 * 3. While poping, we will remove last elements from both
 * <p>
 * Better Optimization:
 * 1.
 */
public class P2_MinStack {
    ArrayList<Integer> arr;
    ArrayList<Integer> minArr;

    public P2_MinStack() {
        arr = new ArrayList<>();
        minArr = new ArrayList<>();
    }


    /**
     * TC: O(1)
     * SC: O(N)
     *
     * @param val
     */
    public void push(int val) {
        if (arr.isEmpty() && minArr.isEmpty()) {
            arr.add(val);
            minArr.add(val);
        } else {
            arr.add(val);
            if (val < minArr.get(minArr.size() - 1)) {
                minArr.add(val);
            }
        }
    }

    /**
     * TC: O(1)
     * SC: O(N)
     */
    public void pop() {
        if (arr.isEmpty() && minArr.isEmpty()) {
            return;
        }
        if (arr.get(arr.size() - 1).equals(minArr.get(minArr.size() - 1))) {
            minArr.remove(minArr.size() - 1);
        }
        arr.remove(arr.size() - 1);
    }

    /**
     * TC: O(1)
     * SC: O(N)
     *
     * @return
     */
    public int top() {
        return arr.get(arr.size() - 1);
    }

    /**
     * TC: O(1)
     * SC: O(N)
     *
     * @return
     */
    public int getMin() {
        return minArr.get(minArr.size() - 1);
    }

    public static void main(String[] args) {
        P2_MinStack minStack = new P2_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
