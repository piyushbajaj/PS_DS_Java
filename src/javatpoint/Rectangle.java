package javatpoint;

/**
 * Created by piyush.bajaj on 14/03/16.
 */
public class Rectangle {
    int length;
    int width;

    void insert(int l, int w){
        length=l;
        width=w;
    }

    void display(){
        System.out.println("Area = " + length*width);
    }

    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        rec.insert(10, 5);
        rec.display();
    }
}
