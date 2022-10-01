package Stack;

/**
 * Created by piyush.bajaj on 17/09/16.
 */
public class StackTwoTest {

    int size;
    int top1=0, top2=0;
    int arr[];

    StackTwoTest(int a){
        arr = new int[a];
        size = a;
        top1 = -1;
        top2 = size;
    }

    // Method to push an element x to stack1
    void push1(int x)
    {
        if(top1 < top2 - 1){
            arr[++top1] = x;
        }
        else{
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    void push2(int x){
        if(top1 < top2 - 1){
            arr[--top2] = x;
        }
        else{
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    int pop1(){
        if(top1!= -1) {
            int x = arr[top1--];
            return x;
        }
        else
            return -1;
    }

    int pop2(){
        if(top2!= size) {
            int x = arr[top2++];
            return x;
        }
        else
            return -1;
    }

    public static void main(String[] args) {
        StackTwoTest ST = new StackTwoTest(10);
        ST.push1(1);

        ST.push1(2);
        ST.push2(5);
        ST.push2(10);
        System.out.println(ST.pop1());
        System.out.println(ST.pop2());
        //ST.pop2();
    }


}
