package com.hioa.android.gameoflifeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class TextQRActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android.com.android.gameoflifeandroid.MESSAGE";
    public Switch messageSwitch;
    public boolean isSwitched = false;

    /**
     * Overrides onCreate.
     * Initialize the activity. Defining UI with calling setContentView.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_qr);

        Log.d("CREATION", "TextQRActivity was created!");
        messageSwitch = (Switch) findViewById(R.id.messageSwitch);


        messageSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    if(isChecked){
                        isSwitched = true;
                    }else{
                        isSwitched = false;
                    }

                }
            }
        );
        AdView adView = (AdView)findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        adView.loadAd(adRequest);

        MobileAds.initialize(this, "ca-app-pub-3727909631399186~1765602358");
    }

    /**
     * Method for the about button.
     *
     * @param view
     */
    public void aboutButton(View view) {
        ToastLibrary.longToast(getApplicationContext(), "Current feature set:"
                + "\n• Text-To-QR Game of Life"
                + "\n• Frame-by-frame or running animation"

                + "\n\nComing soon:"
                + "\n• Touch-draw support"
                + "\n• GoL QR mesh to text exporter"

                + "\n\nProgramutvikling DATS1600");
    }

    /**
     * Checks the text that is entered and if passes startActivity, if not shows an warning message.
     *
     * @param view
     */
    public void convertTextToQR(View view) {
        Intent textQrIntent = new Intent(this, TextQrGol.class);
        EditText editText = (EditText) findViewById(R.id.editText);


        String message = editText.getText().toString();
        if (message.length() > 500) {
            ToastLibrary.longToast(getApplicationContext(), "Please use less than 500 characters." + "\nCurrently you are using " + message.length() + " characters.");
        } else if (message.length() == 0) {
            ToastLibrary.longToast(getApplicationContext(), "Please enter a message.");
        } else {
            Bundle extras = new Bundle();
            extras.putString(EXTRA_MESSAGE, message);
            extras.putBoolean("EXTRA_SWITCH", isSwitched);

            textQrIntent.putExtra("EXTRA_BUNDLE", extras);
            startActivity(textQrIntent);
        }
    }
}
