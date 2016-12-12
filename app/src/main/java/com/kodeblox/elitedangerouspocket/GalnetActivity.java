package com.kodeblox.elitedangerouspocket;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class GalnetActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Calendar dateShown;
    final private int future = 1286;
    private String url;

    private TextView noNews;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private GalnetRecyclerAdapter galnetRecyclerAdapter;

    private ArrayList<GalnetNews> galnetNewses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galnet);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        noNews = (TextView) findViewById(R.id.no_news);

        setSupportActionBar(toolbar);

        dateShown = Calendar.getInstance();
        dateShown.set(Calendar.YEAR, dateShown.get(Calendar.YEAR) + future);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        galnetNewses = new ArrayList<>();
        setRecyclerView();
        galnetNewses = fetchNews(dateShown, true);
    }

    private void setRecyclerView() {
        galnetRecyclerAdapter = new GalnetRecyclerAdapter(galnetNewses);
        recyclerView.setAdapter(galnetRecyclerAdapter);
    }

    private ArrayList<GalnetNews> fetchNews(Calendar dateShown, boolean home) {
        ArrayList<GalnetNews> newsItems = new ArrayList<>();

        if (home) {
            url = "https://community.elitedangerous.com/galnet";
        } else {
            String date = String.format(Locale.getDefault(), "%02d", dateShown.get(Calendar.DAY_OF_MONTH));
            String month = getMonth(dateShown.get(Calendar.MONTH));
            String year = String.valueOf(dateShown.get(Calendar.YEAR));
            url = "https://community.elitedangerous.com/galnet/" + date + "-" + month + "-" + year;
        }

        new AsyncTask<Void, Void, Void>() {

            ArrayList<GalnetNews> newsItems = new ArrayList<>();

            @Override
            protected Void doInBackground(Void... voids) {
                GalnetNews galnetNews;
                try {
                    Document document = Jsoup.connect(url).timeout(10000).get();
                    Elements articles = document.select("div.article");
                    for (Element article : articles) {
                        Element title = article.select("a").first();
                        String url = "https://community.elitedangerous.com" + title.attr("href");
                        String head = title.text();
                        String date = article.select("p.small").text();

                        Element body = article.select("p").last();
                        body.select("br").append("\\n");

                        String mainArticle = body.text().replace("\\n", "\n");

                        galnetNews = new GalnetNews(head, date, mainArticle, url);
                        newsItems.add(galnetNews);
                        Log.d("NewsItem", "News Item Added");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (newsItems.size() == 0) {
                    noNews.setVisibility(View.VISIBLE);
                } else {
                    noNews.setVisibility(View.GONE);
                }
                galnetNewses = newsItems;
                setRecyclerView();
            }
        }.execute();

        return newsItems;
    }

    private String getMonth(int monthIndex) {
        switch (monthIndex) {
            case 0:
                return "JAN";
            case 1:
                return "FEB";
            case 2:
                return "MAR";
            case 3:
                return "APR";
            case 4:
                return "MAY";
            case 5:
                return "JUN";
            case 6:
                return "JUL";
            case 7:
                return "AUG";
            case 8:
                return "SEP";
            case 9:
                return "OCT";
            case 10:
                return "NOV";
            case 11:
                return "DEC";
            default:
                return "";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_galnet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                resetView();
                return true;
            case R.id.action_today:
                resetDate();
                return true;
            case R.id.action_date:
                showDatePicker();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void resetView() {
        dateShown = Calendar.getInstance();
        dateShown.set(Calendar.YEAR, dateShown.get(Calendar.YEAR) + future);

        galnetNewses = fetchNews(dateShown, true);
        setRecyclerView();
    }

    private void resetDate() {
        dateShown = Calendar.getInstance();
        dateShown.set(Calendar.YEAR, dateShown.get(Calendar.YEAR) + future);

        galnetNewses = fetchNews(dateShown, false);
        setRecyclerView();
    }

    private void showDatePicker() {
        Bundle fragmentBundle = new Bundle();
        fragmentBundle.putString("callingActivity", "GalnetActivity");
        fragmentBundle.putLong("shownDate", dateShown.getTimeInMillis());

        DialogFragment datepickerFragment = new DatepickerFragment();
        datepickerFragment.setArguments(fragmentBundle);
        datepickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void dateSet(int year, int month, int day) {
//        Toast.makeText(getApplicationContext(), "Date Set for Galnet", Toast.LENGTH_SHORT).show();
        dateShown.set(year, month, day);

        galnetNewses = fetchNews(dateShown, false);
        setRecyclerView();
    }
}
