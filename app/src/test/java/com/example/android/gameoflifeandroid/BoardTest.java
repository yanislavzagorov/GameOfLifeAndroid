package com.example.android.gameoflifeandroid;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BoardTest {

    @Test
    public void single_dot_dies() {
        byte[][] testBoard = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        Board testGrid = new Board(3, 3);
        testGrid.setBoard(testBoard);

        testGrid.nextGeneration();
        assertEquals("0 0 0 \n" +
                     "0 0 0 \n" +
                     "0 0 0 \n", testGrid.toString());
    }

    @Test
    public void square_remains_square() {
        byte[][] testBoard = {
                {0,0,0,0},
                {0,1,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        Board testGrid = new Board(4, 4);
        testGrid.setBoard(testBoard);

        testGrid.nextGeneration();
        assertEquals("0 0 0 0 \n" +
                     "0 1 1 0 \n" +
                     "0 1 1 0 \n" +
                     "0 0 0 0 \n", testGrid.toString());
    }
}