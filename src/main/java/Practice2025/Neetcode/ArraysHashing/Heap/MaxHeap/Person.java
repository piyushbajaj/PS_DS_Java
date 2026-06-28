package Practice2025.Neetcode.ArraysHashing.Heap.MaxHeap;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing.Heap.MaxHeap
 * <p>
 * User: piyushbajaj
 * Date: 09/06/25
 * Time: 1:04 pm
 */
public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
