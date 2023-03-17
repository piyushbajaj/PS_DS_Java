package LLD.Concept_And_Coding.L7_Snake_And_Ladder;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L7_Snake_And_Ladder
 * <p>
 * User: piyushbajaj
 * Date: 16/03/23
 * Time: 5:54 pm
 */
public class Game {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner;

    public Game() {
        initializeGame();
    }

    public void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        players.add(new Player("Piyush", 0));
        players.add(new Player("Kavya", 0));
    }

    /**
     * Game begins from here!
     */
    public void startGame() {
        System.out.println("Snake and Ladder, Game begins for: " + players.size() + " players");
        System.out.println("\n***************************************************************");

        while (winner == null) {
            System.out.println();
            // Check whose player turn right now
            Player playerTurn = findPlayerTurn();
            System.out.println(
                "Player turn: " + playerTurn.id + ". Current position: " + playerTurn.currentPosition);

            // roll the dice
            int diceNum = dice.rollDice();
            System.out.println("Rolling the dice: " + diceNum);
            int playerNewPosition;
            if (playerTurn.currentPosition + diceNum > board.cells.length * board.cells.length) {
                playerNewPosition = playerTurn.currentPosition;
            } else {
                playerNewPosition = playerTurn.currentPosition + diceNum;
            }
            playerNewPosition = jumpCheck(playerNewPosition, playerTurn.id);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("New position is: " + playerNewPosition);

            if (playerNewPosition == board.cells.length * board.cells.length) {
                winner = playerTurn;
            }
        }
        System.out.println();
        System.out.println("Winner of the game is: " + winner.id);
    }

    /**
     * Update the player position if bitten by snake or jumped up by ladder
     *
     * @param playerPosition
     * @param playerId
     * @return
     */
    private int jumpCheck(int playerPosition, String playerId) {
        if (playerPosition > board.cells.length * board.cells.length - 1) {
            return playerPosition;
        }

        Cell cellObj = board.getCell(playerPosition);

        if (cellObj.jump != null && cellObj.jump.start == playerPosition) {
            String jumpBy = cellObj.jump.start > cellObj.jump.end ? playerId + " bitten by SNAKE!!!" :
                playerId + " took the LADDER!!";
            System.out.println(jumpBy);

            return cellObj.jump.end;
        }

        return playerPosition;
    }

    /**
     * Return the current player, and append this player in the end, so the order is maintained
     *
     * @return
     */
    private Player findPlayerTurn() {
        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }
}
