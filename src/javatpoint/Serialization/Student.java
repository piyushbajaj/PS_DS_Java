package javatpoint.Serialization;

import java.io.Serializable;

/**
 * Created by piyush.bajaj on 06/04/17.
 */
public class Student implements Serializable {
    transient int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
