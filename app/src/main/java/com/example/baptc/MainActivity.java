package com.example.baptc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.baptc.Databases.SessionManager;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        SessionManager sessionManager = new SessionManager(this, SessionManager.SESSION_USERSESSION);
        HashMap<String, String> userDetails = sessionManager.getUsersDetailsFromSession();

        String fullname = userDetails.get(SessionManager.KEY_FULLNAME);
        String phoneNo = userDetails.get(SessionManager.KEY_PHONENO);

        textView.setText(fullname + "\n" + phoneNo);
    }
}