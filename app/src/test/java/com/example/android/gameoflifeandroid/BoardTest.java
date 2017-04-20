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
        assertEquals("000000000", testGrid.toString());
    }

}