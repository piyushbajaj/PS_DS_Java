package javatpoint.interface_example;

/**
 * Created by piyush.bajaj on 25/02/17.
 */
//public abstract class Drawable {
//    abstract void draw();
//}
//
////Implementation: by second user
//class Rectangle extends Drawable{
//    public void draw(){System.out.println("drawing rectangle");}
//}
//class Circle extends Drawable{
//    public void draw(){System.out.println("drawing circle");}
//}
////Using interface: by third user
//class TestInterface1{
//    public static void main(String args[]){
//        Drawable d=new Circle();//In real scenario, object is provided by method e.g. getDrawable()
//        d.draw();
//    }}



//Interface declaration: by first user
interface Drawable{
    void draw();
    //static int cube(int x){return x*x*x;}
    //default void msg(){System.out.println("default method");}
}
//Implementation: by second user
class Rectangle implements Drawable{
    public void draw(){System.out.println("drawing rectangle");}
}
class Circle implements Drawable{
    public void draw(){System.out.println("drawing circle");}
}
//Using interface: by third user
class TestInterface1{
    public static void main(String args[]){
        Drawable d=new Circle();//In real scenario, object is provided by method e.g. getDrawable()
        d.draw();
    }}