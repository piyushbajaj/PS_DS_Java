package TechboostJune2020.Stack;

public class StackArrayIml {
    static final int MaxCapacity = 100;
    int top;
    int arr[] = new int[MaxCapacity];

    StackArrayIml() {
        top = -1;
    }

    public static void main(String[] args) {
        StackArrayIml stackArrayIml = new StackArrayIml();
        stackArrayIml.push(10);
        stackArrayIml.push(20);
        stackArrayIml.push(30);
        stackArrayIml.push(40);
        System.out.println("Peek element is: " + stackArrayIml.peek());
        stackArrayIml.push(50);

        System.out.println("Popping top element: " + stackArrayIml.pop());
        System.out.println("Popping top element: " + stackArrayIml.pop());
        System.out.println("Popping top element: " + stackArrayIml.pop());
        System.out.println("Popping top element: " + stackArrayIml.pop());
        System.out.println("Popping top element: " + stackArrayIml.pop());
        System.out.println("Popping top element: " + stackArrayIml.pop());


        stackArrayIml.push(100);
        System.out.println("Peek element is: " + stackArrayIml.peek());
        System.out.println("Popping top element: " + stackArrayIml.pop());

        System.out.println("Peek element is: " + stackArrayIml.peek());


        //System.out.println("Stack");
    }

    public boolean isEmpty() {
        if (top < 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean push(int data) {
        //Null Check or Base Condition
        if (top >= (MaxCapacity - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }
        //++top
        //top+1;
        //top = top +1
        else {
            arr[++top] = data;
            System.out.println("New Value: " + data + " pushed into Stack");
            return true;
        }
    }

    public int pop() {
        //Null check or Base Condition
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        } else {
            int data = arr[top--];
            return data;
        }
    }

//    public void printArr(){
//        for(int i = 0; )
//        System.out.println(arr)
//    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        } else {
            int data = arr[top];
            return data;
        }
    }


}
