package LLD.Concept_And_Coding.L1_Solid.Interface_Segmentation.Bad;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.SOLID.Interface_Segmentation.Bad
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 8:08 pm
 */
public class Waiter implements RestaurantEmployee {
    @Override
    public void washDishes() {
        // Not my job
    }

    @Override
    public void serveCustomers() {
        // yes and here is my implementation
        System.out.println("Serving the customer");
    }

    @Override
    public void cookFood() {
        // Not my job
    }
}
