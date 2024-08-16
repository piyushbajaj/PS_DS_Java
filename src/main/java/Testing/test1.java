package Testing;

public class test1 {
    public static void main(String[] args) {
        String s = "{CHIPClientsCaller=CHIPAbstractClientsLambda-CHIPClientsCaller-1TVNI86ZLC1US}";

        //String s = "LinkedList.test string (67)";

        s = s.substring(s.indexOf("=") + 1);
        s = s.substring(0, s.indexOf("}"));

        System.out.println(s);
    }
}
