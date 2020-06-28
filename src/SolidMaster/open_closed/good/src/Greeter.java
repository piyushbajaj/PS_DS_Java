package SolidMaster.open_closed.good.src;

/**
 * Created by mrk on 4/7/14.
 */
public class Greeter {
    private Personality personality;

    public Greeter(Personality personality) {
        this.personality = personality;
        }

    public String greet() {
        return this.personality.greet();
    }

    public static void main(String[] args) {
        //CasualPersonality cp = new CasualPersonality();
        Greeter greeter = new Greeter(new CasualPersonality());
        System.out.println(greeter.greet());
        greeter = new Greeter(new FormalPersonality());
        System.out.println(greeter.greet());
        greeter = new Greeter(new IntimatePersonality());
        System.out.println(greeter.greet());
    }
}
