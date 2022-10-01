package LLD.OOPBasics.Inheritance;

/**
 * Created by bajajp on 24 Jun, 2022
 */
public class Team extends Sponsor {
    private final String teamName = "Barcelona";

    public static void main(String[] args) {
        Team myTeam = new Team();
        System.out.println(myTeam.teamName + " " + myTeam.owner);
    }
}
