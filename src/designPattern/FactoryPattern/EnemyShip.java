package designPattern.FactoryPattern;

/**
 * Created by piyush.bajaj on 22/02/17.
 */
public abstract class EnemyShip {
    private String name;
    private double amtDamage;

    public String getName(){
        return name;
    }

    public void setName(String newname){
        name = newname;
    }

    public double getAmtDamage(){
        return amtDamage;
    }

    public void setAmtDamage(double newAmtDamage){
        amtDamage = newAmtDamage;
    }

    public void followHeroShip(){
        System.out.println(getName() + " is following the Hero");
    }

    public void displayEnemyShip(){
        System.out.println(getName() + " is on the screen");
    }

    public void enemyShipShoots(){
        System.out.println(getName() + " attacks and does " + getAmtDamage());
    }

    //public abstract void setAmtDamage(double);

}
