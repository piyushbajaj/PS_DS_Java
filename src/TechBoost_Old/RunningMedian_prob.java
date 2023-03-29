package TechBoost_Old;


/**
 * Created by piyush.bajaj on 08/04/18.
 */
public class RunningMedian_prob {
    //static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();


    static MinHeap minHeap = new MinHeap(100);

    static MaxHeap maxHeap = new MaxHeap(100);

    public static double calculate_median(int value, double median) {

        if (maxHeap.size > minHeap.size) {
            if (value >= median) {
                minHeap.insert(value);
            } else {
                minHeap.insert(maxHeap.extractMax());
                maxHeap.insert(value);
            }
            median = (maxHeap.getMax() + minHeap.getMin()) / 2;
        } else if (maxHeap.size < minHeap.size) {
            if (value > median) {
                //Need to push the top value of minheap to maxHeap
                maxHeap.insert(minHeap.extractMin());
                minHeap.insert(value);
            } else {
                maxHeap.insert(value);
            }
            median = ((double) maxHeap.getMax() + (double) minHeap.getMin()) / 2;
        } else {
            if (value >= median) {
                minHeap.insert(value);
                median = minHeap.getMin();
            } else {
                maxHeap.insert(value);
                median = maxHeap.getMax();
            }
        }

        return median;
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 10, 20, 3};
        double median = 0;

//        maxHeap.insert(5);
//        System.out.println(maxHeap.getMax());
//        maxHeap.insert(10);
//        System.out.println(maxHeap.getMax());

        for (int i = 0; i < arr.length; i++) {
            median = calculate_median(arr[i], median);
            System.out.println(median);
        }

    }
}
