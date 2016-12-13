package com.kodeblox.elitedangerouspocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    private GalnetNews galnetNews;

    private TextView head;
    private TextView date;
    private ImageButton link;
    private TextView body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        head = (TextView) findViewById(R.id.news_head);
        date = (TextView) findViewById(R.id.news_date);
        link = (ImageButton) findViewById(R.id.link);
        body = (TextView) findViewById(R.id.news_body);

        galnetNews = getIntent().getParcelableExtra("NEWS");

        setValues();
    }

    private void setValues() {
        head.setText(galnetNews.getHead());
        date.setText(galnetNews.getDate());
        body.setText(galnetNews.getSummary());
    }
}
