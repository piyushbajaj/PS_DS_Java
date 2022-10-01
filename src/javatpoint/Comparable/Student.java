package javatpoint.Comparable;

/**
 * Created by piyush.bajaj on 06/04/17.
 */
public class Student implements Comparable<Student> {
    int rollno;
    String name;
    int age;
    Student(int rollno,String name,int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    public int compareTo(Student st){
        if(age==st.age)
            return (this.name).compareTo(st.name);
        else if(age>st.age)
            return 1;
        else
            return -1;
    }


}
