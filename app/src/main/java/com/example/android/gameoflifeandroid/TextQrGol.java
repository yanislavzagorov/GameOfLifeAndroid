package com.example.android.gameoflifeandroid;

import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;

public class TextQrGol extends AppCompatActivity {
    public  GameViewer gv;

    public void nextGenerationClick(View view){
        gv.board.nextGeneration();
        gv.invalidate();
    }

    public void startStopClick(View view){
        gv.isAnimating = !gv.isAnimating;
        gv.invalidate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_qr_gol);
        gv = (GameViewer)findViewById(R.id.game);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String QrMessage = intent.getStringExtra(TextQRActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.inputTextView);
        textView.setText(QrMessage);
    }
}
