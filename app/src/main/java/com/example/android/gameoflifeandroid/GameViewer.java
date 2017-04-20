package com.example.android.gameoflifeandroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.constraint.solver.widgets.Rectangle;
import android.util.AttributeSet;
import android.view.View;

class GameViewer extends View {
    Paint aliveCellPaint = new Paint();
    Paint deadCellPaint = new Paint();
    Rectangle aliveCell = new Rectangle();
    Rectangle deadCell = new Rectangle();
    public float cellSize;
    public float topRect = 0;
    public float bottomRect = 0;
    public float leftRect = 0;
    public float rightRect = 0;
    Board board = new Board(20, 20);
    byte[][] gameBoard = board.getBoard();



    public GameViewer(Context context, AttributeSet attrs) {
        super(context, attrs);
        startUpProcedures();
    }

    public void startUpProcedures() {
        aliveCellPaint.setColor(Color.BLACK);
        deadCellPaint.setColor(Color.WHITE);
        cellSize = Resources.getSystem().getDisplayMetrics().widthPixels / board.xaxis;
        bottomRect = cellSize;
        rightRect = cellSize;
        gameBoard[0][0] = 1;
        gameBoard[19][19] = 1;
        gameBoard[0][19] = 1;
        gameBoard[19][0] = 1;
        gameBoard[0][1] = 1;
        gameBoard[0][2] = 1;
        gameBoard[10][10] = 1;

    }

    @Override
    public void onDraw(Canvas canvas) {
        for(int i = 0; i<board.yaxis; i++)
        {
            for(int j = 0; j<board.xaxis; j++)
            {
                if(gameBoard[i][j] == 0){
                    canvas.drawRect(leftRect,topRect,rightRect,bottomRect,deadCellPaint);
                }else{
                    canvas.drawRect(leftRect,topRect,rightRect,bottomRect,aliveCellPaint);
                }
                leftRect += cellSize;
                rightRect += cellSize;
            }
            leftRect = 0;
            rightRect = cellSize;
            topRect += cellSize;
            bottomRect += cellSize;
        }
    }
}