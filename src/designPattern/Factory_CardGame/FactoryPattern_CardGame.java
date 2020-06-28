package designPattern.Factory_CardGame;

/**
 * Created by piyush.bajaj on 27/01/18.
 */
public class FactoryPattern_CardGame {

    public static void main(String[] args) {
        GameFactory gf = new GameFactory();

        //Get an object of Poker class and call its Play method
        Game game = gf.getGame("Poker");
        game.play();

        //Get an object of Black Jack class and call its Play method
        Game game1 = gf.getGame("BlackJack");
        game1.play();
    }



}
