package DesignPattern.Factory_CardGame;

/**
 * Created by piyush.bajaj on 27/01/18.
 */
public class GameFactory {

    //creates a getGame to get object of type

    public Game getGame(String gameType) {
        if (gameType == null) {
            return null;
        } else if (gameType.equalsIgnoreCase("POKER")) {
            return new Poker();
        } else if (gameType.equalsIgnoreCase("BLACKJACK")) {
            return new BlackJack();
        }

        return null;
    }


}
