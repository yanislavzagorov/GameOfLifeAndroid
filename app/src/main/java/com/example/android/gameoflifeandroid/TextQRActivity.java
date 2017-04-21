package com.example.android.gameoflifeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class TextQRActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android.gameoflifeandroid.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_qr);
        Log.d("CREATION", "TextQRActivity was created!");
    }

    public void convertTextToQR(View view) {
        Intent textQrIntent = new Intent(this, TextQrGol.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        textQrIntent.putExtra(EXTRA_MESSAGE, message);
        startActivity(textQrIntent);
    }
}
