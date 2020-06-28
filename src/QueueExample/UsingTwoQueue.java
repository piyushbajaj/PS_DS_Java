package QueueExample;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 12/12/16.
 Implementing Stack using two queues
 */
public class UsingTwoQueue {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int data){
        if(queue1.isEmpty()){
            queue2.add(data);
        }
        else
            queue1.add(data);
    }

    public int pop(){

        if(!queue1.isEmpty()){
            int size = queue1.size();
            int i =0;
            while (i < size-1){
                queue2.add(queue1.remove());
                i++;
            }
            return queue1.remove();
        }
        else {
            int i =0;
            int size = queue2.size();
            while (i < size-1){
                queue1.add(queue2.remove());
                i++;
            }
            return queue2.remove();
        }
    }

    public static void main(String[] args) {
        UsingTwoQueue UT = new UsingTwoQueue();
        UT.push(10);
        UT.push(20);
        UT.push(30);
        System.out.println("Removing the top element is: " + UT.pop());
    }
}
