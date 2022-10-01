package designPattern.FactoryPattern;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 26/02/17.
 *
 * This still can be modified, and we don't want so many if else statement.
 * So let see how to overcome all these using Factory Pattern
 */
public class EnemyShipTesting {
    public static void main(String[] args) {
        EnemyShip ES = new UFOEnemyShip();

        EnemyShipFactory ShipFactory = new EnemyShipFactory();

       // doStuffEnemy(ES); //This is static

        //Now lets make it dynamic

        EnemyShip EnemyCall = null;

        Scanner userInput = new Scanner(System.in);

        String enemyShipOption = "";

        System.out.println("What type of ship? (U/R/B)");

        if(userInput.hasNextLine()){
            enemyShipOption = userInput.nextLine();
            EnemyCall = ShipFactory.makeEnemyShip(enemyShipOption);

        }

        //As we have created EnemyShipFactory to store Factory Details
//        if(enemyShipOption.equalsIgnoreCase("U"))
//            EnemyCall = new UFOEnemyShip();
//        else if(enemyShipOption.equalsIgnoreCase("R"))
//            EnemyCall = new RocketEnemyShip();

        if(EnemyCall!=null)
            doStuffEnemy(EnemyCall);
        else
            System.out.println("Enter U, R, or B next time");
    }

    public static void doStuffEnemy(EnemyShip anEnemyShip){
        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}
