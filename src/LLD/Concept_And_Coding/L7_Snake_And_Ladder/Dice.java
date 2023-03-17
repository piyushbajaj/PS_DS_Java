package LLD.Concept_And_Coding.L7_Snake_And_Ladder;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L7_Snake_And_Ladder
 * <p>
 * User: piyushbajaj
 * Date: 16/03/23
 * Time: 1:33 pm
 */
public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    /**
     * Kept this function in such a way that in future if more than 1 dice is used, it would still work here.
     *
     * @return
     */
    public int rollDice() {
        int totalSum = 0;
        int diceUsed = 0;

        int count = 0;

        while (diceUsed < diceCount) {
            int numberInDice = ThreadLocalRandom.current().nextInt(min, max + 1);
            // Special case for 6
            if (numberInDice == max) {
                while (numberInDice == max && count < 3) {
                    System.out.println("You Lucky! You got 6, rolling dice again");
                    totalSum += numberInDice;
                    count++;
                    numberInDice = ThreadLocalRandom.current().nextInt(min, max + 1);
                }
                if (numberInDice == max) {
                    totalSum += ThreadLocalRandom.current().nextInt(min, max);
                } else {
                    totalSum += numberInDice;
                }
            } else {
                totalSum += numberInDice;
            }

            diceUsed++;
        }

        return totalSum;
    }
}
