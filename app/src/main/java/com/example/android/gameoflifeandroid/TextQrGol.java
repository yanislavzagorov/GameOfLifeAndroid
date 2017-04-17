package com.example.android.gameoflifeandroid;

import android.content.Context;
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
    public byte rows = 50;
    public byte columns = 50;
    byte[][] board = new byte[rows][columns];
    public float topRect = 0;
    public float bottomRect = 30;
    public float leftRect = 0;
    public float rightRect = 30;


    public GameViewer(Context context, AttributeSet attrs) {
        super(context, attrs);
        aliveCellPaint.setColor(Color.BLACK);
        deadCellPaint.setColor(Color.WHITE);
        board[10][10]=1;
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(leftRect,topRect,rightRect,bottomRect,aliveCellPaint);

        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<columns; j++)
            {
                if(board[i][j] == 0){
                    canvas.drawRect(leftRect,topRect,rightRect,bottomRect,deadCellPaint);
                }else{
                    canvas.drawRect(leftRect,topRect,rightRect,bottomRect,aliveCellPaint);
                }
                leftRect += 30;
                rightRect += 30;
            }
            leftRect = 0;
            rightRect = 30;
            topRect += 30;
            bottomRect += 30;
        }
    }
}

/*
class GameOfLifeBoard {
    byte rows;
    byte columns;

    public GameOfLifeBoard(byte rows, byte columns){
        this.rows=rows;
        this.columns=columns;
        byte[][] board = new byte[rows][columns];
    }
}
*/

