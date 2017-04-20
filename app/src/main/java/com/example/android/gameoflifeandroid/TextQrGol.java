package com.example.android.gameoflifeandroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.icu.util.TimeUnit;
import android.support.constraint.solver.widgets.Rectangle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;

public class TextQrGol extends AppCompatActivity {
    public  GameViewer gv;

    public void nextGenerationClick(View view){
        gv.board.nextGeneration();
        gv.invalidate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_qr_gol);
        Log.d("CREATION", "TextQrGol was created!");

        gv = (GameViewer)findViewById(R.id.game);
    }
}
