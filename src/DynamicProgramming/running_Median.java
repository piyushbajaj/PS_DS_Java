package DynamicProgramming;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by piyush.bajaj on 26/08/17.
 */
public class running_Median  {
    PriorityQueue<Integer> biggerHeap;
    PriorityQueue<Integer> smallerHeap;

    public double[] getMedians(int[] arr) {
        running_Median rm = new running_Median();
        //By default Priority Queue will store min heap, so we have to reverse this for Max Heap
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1* o1.compareTo(o2);
            }
        });

        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();

        double[] median = new double[arr.length];



        for(int i = 0; i < arr.length; i++){
            int number = arr[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            median[i] = getMedians(lowers, highers);

        }
        return median;
    }

    public void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if(lowers.size() == 0 || number < lowers.peek())
            lowers.add(number);
        else
            highers.add(number);
    }

    public void rebalance(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
        biggerHeap = (lowers.size() > highers.size())?lowers:highers;
        smallerHeap = (lowers.size() > highers.size())?highers:lowers;

        if((biggerHeap.size() - smallerHeap.size()) >= 2)
            smallerHeap.add(biggerHeap.poll());
    }

    public double getMedians(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
        if(biggerHeap.size() == smallerHeap.size())
            return ((double)(biggerHeap.peek() + smallerHeap.peek())/2);
        else
            return biggerHeap.peek();
    }


    public static void main(String[] args) {
        running_Median rm = new running_Median();
        int[] arr = {12, 4, 5, 3, 8, 7};

        double[] median = rm.getMedians(arr);

        for(int i = 0; i < median.length; i++){
            System.out.println(median[i]);
        }
    }
}
