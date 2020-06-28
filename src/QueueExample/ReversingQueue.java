package QueueExample;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 11/12/16.
 */
public class ReversingQueue {

    public void reverseQueue(QueueUsingLinkedList Que){
        Stack<Integer> stk = new Stack<>();
        while (!Que.isEmpty())
            stk.push(Que.deque());
        while (!stk.isEmpty())
            Que.enqueue(stk.pop());

    }

    //We can also reverse this using just one queue and queue operations
    public void reverse(QueueUsingLinkedList Que){
        if(!Que.isEmpty()){
            int temp = Que.deque();
            reverse(Que);
            Que.enqueue(temp);

        }
    }

    public static void main(String[] args) {
        ReversingQueue RQ = new ReversingQueue();

        QueueUsingLinkedList Qu = new QueueUsingLinkedList();
        Qu.enqueue(5);
        Qu.enqueue(7);
        Qu.enqueue(8);
        Qu.enqueue(9);
        Qu.enqueue(10);
        System.out.println(Qu.displayQueue());
        //System.out.println("After reversing the linked list using Stack: ");
        //RQ.reverseQueue(Qu);
        //System.out.println(Qu.displayQueue());
        System.out.println("After reversing the linked list using Queue operations only: ");
        RQ.reverse(Qu);
        System.out.println(Qu.displayQueue());

    }
}
