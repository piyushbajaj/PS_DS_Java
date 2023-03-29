package TechBoost_Old;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 26/03/18.
 */
public class Stack_from_Queue {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    public static void main(String[] args) {
        Stack_from_Queue sp = new Stack_from_Queue();
        sp.push(1);
        sp.push(2);
        sp.push(3);
        System.out.println(sp.pop_better());
        sp.push(4);
        sp.push(5);
        System.out.println(sp.pop_better());
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return -1;
        }


        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return queue2.remove();

    }

    public int pop_better() {
        if (queue1.isEmpty()) {
            return -1;
        }

        int n = queue1.size();

        while (n > 1) {
            queue1.add(queue1.remove());
            n--;
        }
        return queue1.remove();
    }
}
