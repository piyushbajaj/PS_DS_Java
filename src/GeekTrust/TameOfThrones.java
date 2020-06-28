package GeekTrust;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by piyush.bajaj on 11/04/18.
 */
public class TameOfThrones {

    public static void main(String[] args) {
        Kingdoms kingdoms = new Kingdoms();
        DecidingThrones decidingThrones = new DecidingThrones();
        TameOfThrones tot = new TameOfThrones();

        //If you want to add any more Kingdoms in run-time, then you can use this below method by uncommenting
        //it.

        //kingdoms.addKingdom("Name", "Emblem");

        Map<String, String> hashMap = kingdoms.allKingdoms();

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        if(str.equalsIgnoreCase("Who is the ruler of Southeros?"))
            decidingThrones.whoIsRuler();

        str = s.nextLine();
        if(str.equalsIgnoreCase("Allies of Ruler?"))
            decidingThrones.allies();

        int input = s.nextInt();

        for(int i = 1; i <= input; i++){
            String name = s.next();
            String text = s.nextLine();

            decidingThrones.encrypt(name, text, hashMap);
        }

         str = s.nextLine();

        if(str.equalsIgnoreCase("Who is the ruler of Southeros?"))
            decidingThrones.whoIsRuler();

        str = s.nextLine();
        if(str.equalsIgnoreCase("Allies of Ruler?"))
            decidingThrones.allies();

    }
}
