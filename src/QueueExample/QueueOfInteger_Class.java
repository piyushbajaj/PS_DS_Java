package QueueExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 12/12/16.
 */
public class QueueOfInteger_Class {
    public void interLeavingQueue(Queue<Integer> queue){
        Stack<Integer> stk = new Stack<>();
        int half = queue.size()/2;
        for(int i =0; i < half; i++){
            stk.push(queue.remove());
        }

        while (!stk.empty())
            queue.add(stk.pop());
        for(int i =0; i < half; i++){
            queue.add(queue.remove());
        }

        for(int i =0; i < half; i++){
            stk.push(queue.remove());
        }



        for(int i =0; i < half; i++){
            queue.add(stk.pop());
            queue.add(queue.remove());
        }
    }

    public String displayQueue(Queue<Integer> queue){
        String s = "[";
        while (!queue.isEmpty()){
            s += queue.poll() + ",";
            //queue = queue.
        }
        s += "]";
        return s;
    }

    public static void main(String[] args) {
        QueueOfInteger_Class QC = new QueueOfInteger_Class();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(11);
        queue.add(12);
        queue.add(13);
        queue.add(14);
        queue.add(15);
        queue.add(16);
        queue.add(17);
        queue.add(18);
        queue.add(19);
        queue.add(20);

        QC.interLeavingQueue(queue);

        System.out.println(QC.displayQueue(queue));
    }
}
