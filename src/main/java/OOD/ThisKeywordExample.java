package OOD;

/**
 * Project: DSAlgo
 * Package: OOD
 * <p>
 * User: piyushbajaj
 * Date: 19/05/25
 * Time: 1:59 pm
 */
public class ThisKeywordExample {
    public static void main(String[] args) {
        Person p = new Person();
        p.introduce();
    }
}

class Person {
    void greet(Person person) {
        System.out.println("Hello, " + person);
    }

    void introduce() {
        greet(this); // Passes the current object
    }

    @Override
    public String toString() {
        return "I am a Person instance.";
    }
}
