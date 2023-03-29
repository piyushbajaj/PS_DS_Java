package thoughtWorks;

//import thoughtworks.recruiting.sample.NotImplementedException;

/**
 * Hello world!
 */
public class Calculator {
    public int add(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {
            throw new NotImplementedException();
        }

    }

    public int subtract(int a, int b) {
        try {
            return a - b;
        } catch (Exception e) {
            throw new NotImplementedException();
        }
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
