package Stack;

/**
 * Created by piyush.bajaj on 09/12/16.
 */
public class ArrayImplementing_Stack {
    public static final int CAP = 10;
    protected int capacity;
    protected int[] stackRep;

    protected int top = -1;

    public ArrayImplementing_Stack() {
        capacity = this.CAP;
    }

    public ArrayImplementing_Stack(int cp) {
        capacity = cp;
        stackRep = new int[capacity];
    }

    public static void main(String[] args) throws Exception {
        ArrayImplementing_Stack AS = new ArrayImplementing_Stack(4);

        AS.push(10);
        AS.push(8);
        AS.push(6);
        AS.push(12);
        AS.pop();
        System.out.println(AS.toString());

    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public void push(int data) throws Exception {
        if (size() == capacity) {
            throw new Exception("Stack is full");
        }
        stackRep[++top] = data;
    }

    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return stackRep[top];
    }

    public int pop() throws Exception {
        int data;
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE;
        return data;
    }

    public String toString() {
        String s;
        s = "[";

        if (size() > 0) {
            s += stackRep[0];
        }
        if (size() > 1) {
            for (int i = 1; i < size(); i++) {
                s += "," + stackRep[i];
            }

        }
        return s + "]";
    }

}
