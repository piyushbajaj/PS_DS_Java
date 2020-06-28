package TechBoost_Old;

/**
 * Created by piyush.bajaj on 18/03/18.
 */
public class Stack_Array_Prob {
    int index = -1;
    int[] A;

    Stack_Array_Prob(int size){
        A = new int[size];
    }
    void push(int x){
        index++;
        A[index] = x;
    }

    int pop(){
        if(index == -1){
            System.out.println("Underflow");
            return -1;
        }
        int temp = A[index];
        index--;
        return temp;

    }

    public static void main(String[] args) {
        Stack_Array_Prob sp = new Stack_Array_Prob(10);
        sp.push(1);
        sp.push(2);
        sp.push(3);
        System.out.println(sp.pop());
    }
}
