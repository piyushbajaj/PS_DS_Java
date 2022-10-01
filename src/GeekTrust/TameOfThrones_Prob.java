package GeekTrust;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by piyush.bajaj on 27/03/18.
 */
public class TameOfThrones_Prob {
    Map<String, String> hashMap = new HashMap<String, String>();
    HashSet<String> allies = new HashSet<>();
    public void addkingdom(String Name, String Emblem){
        Name = Name.toLowerCase();
        Emblem = Emblem.toLowerCase();
        hashMap.put(Name, Emblem);
    }

    public void encrypt(String name, String text){
        text = text.toLowerCase();
        char[] charArr = new char[26];
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) - 97 >=0 && text.charAt(i) - 97 <= 25)
                charArr[text.charAt(i) - 97]++;
        }

        boolean flag = true;
        for(Map.Entry<String, String> entry: hashMap.entrySet()){
            if(entry.getKey().equalsIgnoreCase(name)){
                String str = entry.getValue();
                for(int i = 0; i < str.length(); i++){
                    char ch = str.charAt(i);
                    if(charArr[ch - 97] > 0)
                        charArr[ch - 97]--;
                    else {
                        flag = false;
                        break;
                    }
                }
                if(!flag)
                    break;
                else {
                    allies.add(entry.getKey());
                }
            }
        }
    }

    public void whoIsRuler(){
        if(allies.size() >= 3)
            System.out.println("King Shan");
        else
            System.out.println("None");

    }

    public void allies(){
        if(allies.size() >= 3)
            System.out.println(allies.toString());
        else
            System.out.println("None");
    }

    public static void main(String[] args) {
        TameOfThrones_Prob tameOfThrones_prob = new TameOfThrones_Prob();
        tameOfThrones_prob.addkingdom("LAND", "Panda");
        tameOfThrones_prob.addkingdom("WATER", "Octopus");
        tameOfThrones_prob.addkingdom("ICE", "Mammoth");
        tameOfThrones_prob.addkingdom("AIR", "Owl");
        tameOfThrones_prob.addkingdom("FIRE", "Dragon");

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        if(str.equalsIgnoreCase("Who is the ruler of Southeros?"))
            tameOfThrones_prob.whoIsRuler();

        str = s.nextLine();
        if(str.equalsIgnoreCase("Allies of Ruler?"))
            tameOfThrones_prob.allies();

        int input = s.nextInt();

        for(int i = 1; i <= input; i++){
            String name = s.next();
            String text = s.nextLine();

            tameOfThrones_prob.encrypt(name, text);
        }

        String str1 = s.nextLine();
        //str1 = s.nextLine();

        if(str1.equalsIgnoreCase("Who is the ruler of Southeros?"))
            tameOfThrones_prob.whoIsRuler();

        str1 = s.nextLine();
        if(str.equalsIgnoreCase("Allies of Ruler?"))
            tameOfThrones_prob.allies();


    }
}
