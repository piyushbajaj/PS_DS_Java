package LLD.Concept_And_Coding.L4_Decorator_Pattern;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L4_Decorator_Pattern
 * <p>
 * User: piyushbajaj
 * Date: 16/01/23
 * Time: 6:13 pm
 */
public class ExtraCheese extends ToppingDecorator {

    // has-A relationship
    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}
