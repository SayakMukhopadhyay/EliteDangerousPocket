package com.kodeblox.elitedangerouspocket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void galnet(View view) {
        Intent galnetActivity = new Intent(getApplicationContext(), GalnetActivity.class);
        startActivity(galnetActivity);
    }

    public void spinner(View view) {
        Intent galnetActivity = new Intent(getApplicationContext(), SpinnerActivity.class);
        startActivity(galnetActivity);
    }
}
