package com.example.isupportlockdown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity {
    String fmessage;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        fmessage=message;
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

    }

    public void sendMessage(View view) {

        EditText editText = (EditText) findViewById(R.id.editNumber);
        String number= editText.getText().toString();


        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, fmessage);

//Directly send to specific mobile number...
        String smsNumber = "91" + number;//Number without with country code and without '+' prifix
        whatsappIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix

        if (whatsappIntent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(DisplayMessageActivity.this, "Whatsapp not installed.", Toast.LENGTH_SHORT).show();
            return;
        }

        startActivity(whatsappIntent);
    }
    }

