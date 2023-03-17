package LLD.Concept_And_Coding.L7_Snake_And_Ladder;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L7_Snake_And_Ladder
 * <p>
 * User: piyushbajaj
 * Date: 16/03/23
 * Time: 5:48 pm
 */
public class Board {
    Cell[][] cells;

    /**
     * Initialize board
     *
     * @param boardSize:       size of the board
     * @param numberOfSnakes:  dynamic number of snakes
     * @param numberOfLadders: dynamic number of ladders
     */
    Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        initializeCells(boardSize);
        addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
    }

    /**
     * Private function for just creating cells inside the board
     *
     * @param boardSize
     */
    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    /**
     * Private function for adding snakes and ladders in the board
     *
     * @param cells
     * @param numberOfSnakes
     * @param numberOfLadders
     */
    private void addSnakesLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {

        while (numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);

            if (snakeTail >= snakeHead) {
                continue;
            }

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;

            numberOfSnakes--;
        }

        while (numberOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);

            if (ladderStart >= ladderTail) {
                continue;
            }

            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderTail;

            Cell cell = getCell(ladderStart);
            cell.jump = ladderObj;

            numberOfLadders--;
        }
    }

    /**
     * Return the current board coordinates based on the position
     *
     * @param playerPosition
     * @return
     */
    public Cell getCell(int playerPosition) {
        int boardRow = playerPosition / 10;
        int boardCol = playerPosition % 10;

        return cells[boardRow][boardCol];
    }


}
