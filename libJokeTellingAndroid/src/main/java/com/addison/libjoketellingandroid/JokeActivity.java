package com.addison.libjoketellingandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {

    public static final String INTENT_JOKE = "INTENT_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent receivedIntent = getIntent();

        if ((receivedIntent != null)
                && receivedIntent.hasExtra(INTENT_JOKE)) {
            String joke = receivedIntent.getStringExtra(INTENT_JOKE);
            TextView jokeTextView = findViewById(R.id.tv_joke);
            jokeTextView.setText((joke == null) ? getString(R.string.no_joke) : joke);
        } else {
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
