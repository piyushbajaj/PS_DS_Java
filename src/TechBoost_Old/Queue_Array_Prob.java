package TechBoost_Old;

/**
 * Created by piyush.bajaj on 18/03/18.
 */
public class Queue_Array_Prob {
    int f = -1;
    int r = -1;
    int[] A;
    int size = 0;

    Queue_Array_Prob(int size){
        A = new int[size];
        this.size = size;
    }

    void enqueue(int x){
        if( r == size-1 ){
            if(f== -1){
                System.out.println("Overflow");
                return;
            }
            else if(f == size-1){
                f = -1;
                r = -1;
            }
            else
                r = -1;
        }
        A[++r] = x;
    }

    int dequeue(){

        if( f== r){
            if(f == this.size -1 && r ==this.size-1){
                f = -1;
                r = -1;
            }
            System.out.println("Array is empty");
            return -1;
        }
        if(f == size-1){
            f = -1;
        }
        int temp = A[++f];
        //f++;
        return temp;
    }

    public static void main(String[] args) {
        Queue_Array_Prob queue_prob = new Queue_Array_Prob(10);
        queue_prob.enqueue(1);
        queue_prob.enqueue(2);
        queue_prob.enqueue(3);
        queue_prob.enqueue(4);
        queue_prob.enqueue(5);

        System.out.println(queue_prob.dequeue());
        System.out.println(queue_prob.dequeue());

        queue_prob.enqueue(6);
        queue_prob.enqueue(7);

        System.out.println(queue_prob.dequeue());
        System.out.println(queue_prob.dequeue());
        System.out.println(queue_prob.dequeue());
        System.out.println(queue_prob.dequeue());
        System.out.println(queue_prob.dequeue());

        queue_prob.enqueue(8);
        queue_prob.enqueue(9);
        queue_prob.enqueue(10);
        queue_prob.enqueue(11);

        System.out.println(queue_prob.dequeue());
        System.out.println(queue_prob.dequeue());
        System.out.println(queue_prob.dequeue());
        System.out.println(queue_prob.dequeue());


    }


}
