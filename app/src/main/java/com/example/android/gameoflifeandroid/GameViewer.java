package com.example.android.gameoflifeandroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.constraint.solver.widgets.Rectangle;
import android.util.AttributeSet;
import android.view.View;

class GameViewer extends View {
    public Paint aliveCellPaint = new Paint();
    public Paint deadCellPaint = new Paint();
    public float cellSize;
    public float topRect;
    public float bottomRect;
    public float leftRect;
    public float rightRect;
    public Board board = new Board(5, 5);
    byte[][] gameBoard = board.getBoard();



    public GameViewer(Context context, AttributeSet attrs) {
        super(context, attrs);
        startUpProcedures();
    }

    public void startUpProcedures() {
        aliveCellPaint.setColor(Color.BLACK);
        deadCellPaint.setColor(Color.WHITE);
        cellSize = Resources.getSystem().getDisplayMetrics().widthPixels / board.xaxis;
        gameBoard[2][2] = 1;
        gameBoard[2][3] = 1;
        gameBoard[3][2] = 1;
    }

    @Override
    public void onDraw(Canvas canvas) {
        gameBoard = board.getBoard();
        topRect = 0;
        bottomRect = cellSize;
        leftRect = 0;
        rightRect = cellSize;
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