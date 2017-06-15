package com.hioa.android.gameoflifeandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import static com.hioa.android.gameoflifeandroid.TextQRActivity.EXTRA_MESSAGE;

public class TextQrGol extends AppCompatActivity {
    public  GameViewer gv;

    /**
     * Calls nextGeneration onClick.
     *
     * @param view Current view.
     */
    public void nextGenerationClick(View view) {
        gv.board.nextGeneration();
        gv.invalidate();
    }

    /**
     * Handles stopStart onClick.
     *
     * @param view Current view.
     */
    public void startStopClick(View view) {
        gv.isAnimating = !gv.isAnimating;
        gv.invalidate();
    }

    /**
     * Encodes a String to a BitMatrix and returns the code as a 2D byte array.
     *
     * @param stringToQr The string that will be encoded into a BitMatrix
     * @param size the width and height of the BitMatrix
     * @return 2D byte array of the QR-Code.
     */
    public static byte[][] qrCodeEncoder(String stringToQr, int size) {
        BitMatrix bitMatrix = new BitMatrix(size, size);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        byte[][] byteArray = new byte[size][size];
        try {
            bitMatrix = qrCodeWriter.encode(stringToQr, BarcodeFormat.QR_CODE, size, size);
        } catch (WriterException we) {
            Log.d("EXCEPTION", " " + we);
        }

        for (int yaxis = 0; yaxis < size; yaxis++) {
            for (int xaxis = 0; xaxis < size; xaxis++) {
                if (bitMatrix.get(xaxis, yaxis)) {
                    byteArray[yaxis][xaxis] = 1;
                } else {
                    byteArray[yaxis][xaxis] = 0;
                }
            }
        }
        return byteArray;
    }

    /**
     * onCreate method for TextQrGol class.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_qr_gol);
        gv = (GameViewer)findViewById(R.id.game);
        Bundle extras = getIntent().getBundleExtra("EXTRA_BUNDLE");
        //String qrMessageString = intent.getStringExtra(TextQRActivity.EXTRA_MESSAGE);
        String qrMessageString = extras.getString(EXTRA_MESSAGE);
        boolean isSwitched = extras.getBoolean("EXTRA_SWITCH");
        TextView textView = (TextView) findViewById(R.id.inputTextView);
        gv.board.setBoard(qrCodeEncoder(qrMessageString, 100));

        if(!isSwitched) {
            if (qrMessageString.length() < 80) {
                textView.setText(qrMessageString);
            } else {
                textView.setText(qrMessageString.substring(0, 80) + " (...)");
            }
        }else {
            textView.setText("Message hidden  \uD83D\uDC40");
        }
    }
}
