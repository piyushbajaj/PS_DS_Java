package TechBoost_Old;

/**
 * Created by piyush.bajaj on 18/03/18.
 */
public class Queue_LL_Prob {
    Node head;
    Node front = head, rear = head;
    static class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    /*
    This enqueue takes O(N) as Time Complexity
     */
    void enqueue(int x){
        Node p = new Node(x);
        if(head == null) {
            head = p;
            return;
        }
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = p;
    }

    void enqueue_better(int x){
        Node p = new Node(x);
        if(head == null) {
            head = p;
            front = head;
            rear = head;
            return;
        }
        rear.next = p;
        rear = rear.next;
    }

    int dequeue(){
        if(head == null)
            return Integer.MIN_VALUE;

        int temp = head.data;
        head = head.next;
        return temp;

    }

    int dequeue_better(){
        if(head == null)
            return Integer.MIN_VALUE;


        int temp = front.data;
        front = front.next;
        return temp;

    }

    public static void main(String[] args) {
        Queue_LL_Prob qq = new Queue_LL_Prob();
//        qq.enqueue(1);
//        qq.enqueue(2);
//        qq.enqueue(3);
//        qq.enqueue(4);
//        System.out.println(qq.dequeue());
//        System.out.println(qq.dequeue());

        qq.enqueue_better(1);
        qq.enqueue_better(2);
        qq.enqueue_better(3);
        qq.enqueue_better(4);
        System.out.println(qq.dequeue_better());
        System.out.println(qq.dequeue_better());
    }
}
