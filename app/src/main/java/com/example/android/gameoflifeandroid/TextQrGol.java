package com.example.android.gameoflifeandroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.constraint.solver.widgets.Rectangle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;

public class TextQrGol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_qr_gol);
    }
}


class GameViewer extends View {
    Paint aliveCellPaint = new Paint();
    Paint deadCellPaint = new Paint();
    Rectangle aliveCell = new Rectangle();
    Rectangle deadCell = new Rectangle();
    public float cellSize;
    public byte rows = 50;
    public byte columns = 50;
    byte[][] board = new byte[rows][columns];
    public float topRect = 0;
    public float bottomRect = 0;
    public float leftRect = 0;
    public float rightRect = 0;
    public boolean isAnimating;



    public GameViewer(Context context, AttributeSet attrs) {
        super(context, attrs);
        startUpProcedures();
    }

    public void startUpProcedures() {
        aliveCellPaint.setColor(Color.BLACK);
        deadCellPaint.setColor(Color.WHITE);
        board[10][10]=1;
        cellSize = Resources.getSystem().getDisplayMetrics().widthPixels / columns;
        bottomRect = cellSize;
        rightRect = cellSize;
    }

    @Override
    public void onDraw(Canvas canvas) {
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<columns; j++)
            {
                if(board[i][j] == 0){
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


        if (isAnimating) {
            /**
             * Next gen call
             * put thread to sleep to cap fps
             */
            invalidate(); //request new draw call
        }

    }
}
