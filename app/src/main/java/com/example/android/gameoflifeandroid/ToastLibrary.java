package com.example.android.gameoflifeandroid;

import android.content.Context;
import android.widget.Toast;

public class ToastLibrary {

    public ToastLibrary() {
    }

    /**
     * DescriptionOfMethod.
     *
     * @param nameOfReturn Description.
     * @return DescriptionOfReturn.
     */
    public static void longToast(Context context, String string) {
        CharSequence text = string;
        int duration = Toast.LENGTH_LONG;

        Toast tooLongToast = Toast.makeText(context, text, duration);
        tooLongToast.show();
    }
}