package TakeUForward.CompleteCourse_456.S12_Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S12_Greedy
 * <p>
 * User: piyushbajaj
 * Date: 19/10/22
 * Time: 6:32 pm
 * <p>
 */
public class P10_Job_Sequencing {

    public static void main(String[] args) {
        P10_Job_Sequencing p10_job_sequencing = new P10_Job_Sequencing();
        System.out.println(Arrays.toString(p10_job_sequencing.JobScheduling(new Job[] {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25), new Job(5, 1, 15)}, 5)));
    }

    //Function to find the maximum profit and the number of jobs done.
    public int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, new JobComparator());

        int maxDeadline = 0;
        int maxProfit = 0;
        int jobCount = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxDeadline) {
                maxDeadline = arr[i].deadline;
            }
        }

        int[] jobs = new int[maxDeadline];

        for (int i = 0; i < n; i++) {
            int deadline = arr[i].deadline;
            int profit = arr[i].profit;
            int jobId = arr[i].id;
            int j = deadline - 1;

            while (j >= 0) {
                if (jobs[j] == 0) {
                    jobs[j] = jobId;
                    maxProfit += profit;
                    jobCount++;
                    break;
                }
                j--;
            }
        }

        return new int[] {jobCount, maxProfit};
    }

    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    // Decreasing order
    static class JobComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            if (o1.profit < o2.profit) {
                return 1;
            } else if (o1.profit > o2.profit) {
                return -1;
            }
            return 0;
        }
    }
}
