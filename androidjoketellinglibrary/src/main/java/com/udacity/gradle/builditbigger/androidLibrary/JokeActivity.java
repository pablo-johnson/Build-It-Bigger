package com.udacity.gradle.builditbigger.androidLibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView jokeTextView = (TextView) findViewById(R.id.joke);
        if ((getIntent() != null) && (getIntent().getStringExtra("joke") != null)) {
            jokeTextView.setText(getIntent().getStringExtra("joke"));
        }
    }
}
