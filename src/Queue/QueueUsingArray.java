package Queue;

/**
 * Created by piyush.bajaj on 23/09/16.
 */
public class QueueUsingArray {

    int front = -1;
    int rear;
    int MaxSize;
    int arr[];

    public QueueUsingArray(int size){
        this.MaxSize = size;
        arr = new int[MaxSize];
    }

    public void enqueu(int k){
        if(front == -1){
            arr[++front] = k;
            rear = front;
        }
        else{
            if(rear == MaxSize -1)
                System.out.println("Queue is overflown");
            arr[++rear] = k;
        }
    }

    public void deque(){
        if(front == -1 || front == MaxSize)
            System.out.println("Queue is underflown");
        else
            System.out.println(arr[front++]);
    }

    public static void main(String[] args) {
        QueueUsingArray QA = new QueueUsingArray(10);

        QA.enqueu(5);
        QA.enqueu(10);
        QA.enqueu(15);
        QA.deque();
        QA.deque();
        QA.deque();
    }
}
