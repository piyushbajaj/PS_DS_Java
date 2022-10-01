package OnlineTest;

/**
 * Created by piyush.bajaj on 01/04/18.
 */
//public class blueOptima_Prob {
    class A {
         public int GetResult(int a, int b){
            return 0;
        }
    }
    class B extends A {
        //@Override
        public int GetResult(int a, int b){
            return 1;
        }
        class C{
            public void get(){

            }
        }
    }

    public class blueOptima_Prob {
        public static void main(String[] args) {
            B b = new B();
            B.C c = b.new C();
            int y = 1, z = 1;
            //y = ++y;
            //z = z++;
            y = ++y + z++;
            System.out.println(y);
            //y = ++y + z++;
            System.out.println(y);
            System.out.println(z);
            //System.out.println(b.GetResult(0, 1));
        }
    }
//}
