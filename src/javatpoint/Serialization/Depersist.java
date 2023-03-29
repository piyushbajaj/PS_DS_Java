package javatpoint.Serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by piyush.bajaj on 06/04/17.
 */
public class Depersist {
    public static void main(String args[]) throws Exception {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
        Student s = (Student) in.readObject();
        System.out.println(s.id + " " + s.name);

        in.close();

        ArrayList<Integer> a = new ArrayList<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        //Collections.sort
    }
}
