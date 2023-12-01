package com.rakibofc.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text = "This is text from main activity.";
        TextPass textPass = new TextPass(text);

        // Create and add the initial fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new OuterFragment(textPass))
                .commit();
    }
}