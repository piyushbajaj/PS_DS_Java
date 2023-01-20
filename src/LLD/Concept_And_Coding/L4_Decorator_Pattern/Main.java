package LLD.Concept_And_Coding.L4_Decorator_Pattern;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L4_Decorator_Pattern
 * <p>
 * User: piyushbajaj
 * Date: 16/01/23
 * Time: 6:25 pm
 */
public class Main {
    public static void main(String[] args) {
        // Margherita + ExtraCheese + Mushroom
        BasePizza basePizza = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println(basePizza.cost());
    }
}
