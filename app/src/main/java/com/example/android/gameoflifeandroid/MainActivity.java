package com.example.android.gameoflifeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * DescriptionOfMethod.
     *
     * @param nameOfReturn Description.
     * @return DescriptionOfReturn.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * DescriptionOfMethod.
     *
     * @param nameOfReturn Description.
     * @return DescriptionOfReturn.
     */
    public void textQRButton(View view) {
        Intent intent = new Intent(this, TextQRActivity.class);
        startActivity(intent);
    }

    /**
     * DescriptionOfMethod.
     *
     * @param nameOfReturn Description.
     * @return DescriptionOfReturn.
     */
    public void aboutButton(View view) {
        ToastLibrary.longToast(getApplicationContext(), "Current feature set: \n• Text-To-QR Game of Life\n• More coming soon\n\nProgramutvikling DATS1600");
    }
}
