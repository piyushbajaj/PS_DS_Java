package OnlineTest;

/**
 * Created by piyush.bajaj on 14/07/17.
 */
public class Tuple {
    int index;
    int weight;
    int cost;

    public Tuple(int index, int weight, int cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight >= 0 && weight <= 10000) {
            this.weight = weight;
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost >= 0 && cost <= 100) {
            this.cost = cost;
        }
    }
}
