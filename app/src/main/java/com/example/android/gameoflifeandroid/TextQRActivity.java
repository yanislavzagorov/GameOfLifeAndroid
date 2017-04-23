package com.example.android.gameoflifeandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TextQRActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android.gameoflifeandroid.MESSAGE";

    /**
     * DescriptionOfMethod.
     *
     * @param nameOfReturn Description.
     * @return DescriptionOfReturn.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_qr);
        Log.d("CREATION", "TextQRActivity was created!");
    }

    /**
     * DescriptionOfMethod.
     *
     * @param nameOfReturn Description.
     * @return DescriptionOfReturn.
     */
    public void convertTextToQR(View view) {
        Intent textQrIntent = new Intent(this, TextQrGol.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        if (message.length() > 500){
            Context context = getApplicationContext();
            CharSequence text = "Please use less than 500 characters." + "\nCurrently you are using " + message.length() + " characters." ;
            int duration = Toast.LENGTH_LONG;

            Toast tooLongToast = Toast.makeText(context, text, duration);
            tooLongToast.show();
        }else if (message.length() == 0) {
            Context context = getApplicationContext();
            CharSequence text = "Please enter a message." ;
            int duration = Toast.LENGTH_LONG;

            Toast tooShortToast = Toast.makeText(context, text, duration);
            tooShortToast.show();
        }else {
            textQrIntent.putExtra(EXTRA_MESSAGE, message);
            startActivity(textQrIntent);
        }
    }
}
