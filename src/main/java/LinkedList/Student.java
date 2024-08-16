package LinkedList;

/**
 * Created by piyush.bajaj on 03/05/17.
 */
public class Student extends Person {
    private int[] testScores;
    private int sum = 0;


    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the LinkedList.Person's first name.
     *   @param lastName - A string denoting the LinkedList.Person's last name.
     *   @param id - An integer denoting the LinkedList.Person's ID number.
     *   @param scores - An array of integers denoting the LinkedList.Person's LinkedList.test scores.
     */
    // Write your constructor here
    public Student(String firstName, String lastName, int id, int[] testScores) {
        super(firstName, lastName, id);
        this.testScores = testScores;
    }

    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    // Write your method here
    public char calculate() {
        for (int i = 0; i < testScores.length; i++) {
            sum += testScores[i];
        }
        sum = sum / testScores.length;
        char ch = ' ';
        if (sum >= 90 && sum <= 100) {
            ch = 'O';
        } else if (sum >= 80 && sum < 90) {
            ch = 'E';
        } else if (sum >= 70 && sum < 80) {
            ch = 'A';
        } else if (sum >= 55 && sum < 70) {
            ch = 'P';
        } else if (sum >= 40 && sum < 55) {
            ch = 'D';
        } else if (sum < 40) {
            ch = 'T';
        }

        return ch;
    }
}
