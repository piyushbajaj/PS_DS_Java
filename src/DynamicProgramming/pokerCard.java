package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by piyush.bajaj on 30/07/17.
 */
public class pokerCard {
    public static void main(String[] args) {
        pokerCard pc = new pokerCard();
        String[] arr = {"S5", "H5", "H4", "H9", "SA"};

        pc.bestCards(arr);
    }

    public Integer getRank(char cardNum) {
        switch (cardNum) {
            case '2':
                return 0;
            case '3':
                return 1;
            case '4':
                return 2;
            case '5':
                return 3;
            case '6':
                return 4;
            case '7':
                return 5;
            case '8':
                return 6;
            case '9':
                return 7;
            case 'T':
                return 8;
            case 'J':
                return 9;
            case 'Q':
                return 10;
            case 'K':
                return 11;
            case 'A':
                return 12;
            default:
                return -1;
        }
    }

    //public String fourKind()

    public String bestCards(String[] input_cards_array) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        HashMap<Integer, Character> hash = new HashMap<>();
        HashMap<Character, Integer> hash_same = new HashMap<>();
//        for(int i = 0; i < 5; i++){
//            if(tree.containsKey(getRank(input_cards_array[i].charAt(1))))
//                tree.put(getRank(input_cards_array[i].charAt(1)), input_cards_array[i].charAt(0) + Integer.toString(i));
//        }
        for (int i = 0; i < 5; i++) {
            hash.put(getRank(input_cards_array[i].charAt(1)), input_cards_array[i].charAt(0));
        }

        for (int i = 0; i < 5; i++) {
            hash_same.put(input_cards_array[i].charAt(0), getRank(input_cards_array[i].charAt(1)));
        }


        for (int i = 0; i < 5; i++) {
            if (tree.containsKey(getRank(input_cards_array[i].charAt(1)))) {
                tree.put(getRank(input_cards_array[i].charAt(1)),
                    tree.get(getRank(input_cards_array[i].charAt(1))) + 1);
            } else {
                tree.put(getRank(input_cards_array[i].charAt(1)), 1);
            }
        }

        int count = 1;
        if (tree.containsValue(4)) {
            return "four-of-a-kind";
        } else if (tree.containsValue(3) && tree.containsValue(2)) {
            return "full-house";
        } else if (hash_same.size() == 1) {
            return "flush";
        } else if (tree.size() == 5) {

            for (Map.Entry entry : tree.entrySet()) {
                if (count == 1) {
                    count = ((int) entry.getKey());
                    count++;
                } else if (count == ((int) entry.getKey())) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == 5) {
                return "full-house";
            }

        }


        //First i need to sort all the card based on the ranks

        for (Map.Entry entry : hash.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (Map.Entry entry : tree.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return " ";
    }
}
