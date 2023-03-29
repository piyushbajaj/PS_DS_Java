package OnlineTest;

import java.util.ArrayList;
import java.util.Scanner;

public class CATSDOGS {

    static ArrayList<Integer> calculatedLegs = new ArrayList<>();
    static ArrayList<Integer> cats = new ArrayList<>();
    static ArrayList<Integer> dogs = new ArrayList<>();
    static ArrayList<Integer> legs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();

        if (tests < 1 || tests > 10000) {
            System.out.print("Invalid test input");
            return;
        }

        System.out.println("tests: " + tests);

        for (int i = 0; i < tests; i++) {
            cats.add(scan.nextInt());
            dogs.add(scan.nextInt());
            legs.add(scan.nextInt());
        }
        scan.close();

        for (int i = 0; i < cats.size(); i++) {
            verifyLegs(cats.get(i), dogs.get(i), legs.get(i));
        }
    }

    public static void verifyLegs(int cats, int dogs, int legs) {
        int no_of_cat_legs = cats * 4;
        int no_of_dog_legs = dogs * 4;

        if (cats == 0 && dogs == 0) {
            if (legs == 0) {
                System.out.println(Status.YES);
            } else {
                System.out.println(Status.NO);
            }
            return;
        } else if (cats == 0) {
            if (no_of_dog_legs == legs) {
                System.out.println(Status.YES);
            } else {
                System.out.println(Status.NO);
            }
            return;
        } else if (dogs == 0) {
            if (no_of_cat_legs == legs) {
                System.out.println(Status.YES);
            } else {
                System.out.println(Status.NO);
            }
            return;
        }

        if (legs % 4 != 0) {
            System.out.println(Status.NO);
            return;
        }

        // Check for upper limit and lower limit
        if (cats < 0 || cats > 100 || dogs < 0 || dogs > 100) {
            System.out.println("Invalid cats and dogs input");
            return;
        }

        calculatedLegs.add(no_of_dog_legs);

        // T.C: O(N) -> N: number of cats
        // S.C: O(4N) -> O(N)
        for (int j = 1; j < cats + 1; j++) {
            calculatedLegs.add(no_of_dog_legs + j * 4);
        }

        if (calculatedLegs.contains(legs)) {
            System.out.println(Status.YES);
        } else {
            System.out.println(Status.NO);
        }
    }

    enum Status {
        YES, NO
    }
}
