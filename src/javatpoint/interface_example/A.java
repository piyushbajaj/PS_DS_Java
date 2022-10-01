package javatpoint.interface_example;

/**
 * Created by piyush.bajaj on 26/02/17.
 */
public class A{
    protected void msg(){System.out.println("Hello java");}
}

class Simple extends A{
    public void msg(){System.out.println("Hello java");}//C.T.Error
    public static void main(String args[]){
        Simple obj=new Simple();
        obj.msg();
    }
}
