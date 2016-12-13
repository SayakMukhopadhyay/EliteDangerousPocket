package com.kodeblox.elitedangerouspocket;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class GalnetRecyclerAdapter extends RecyclerView.Adapter<GalnetRecyclerAdapter.GalnetNewsHolder> {

    private ArrayList<GalnetNews> galnetNewses;

    public GalnetRecyclerAdapter(ArrayList<GalnetNews> galnetNewses) {
        this.galnetNewses = galnetNewses;
    }

    @Override
    public GalnetRecyclerAdapter.GalnetNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_row_galnet, parent, false);

        inflatedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = view.getTag().toString();
                for (GalnetNews galnetNews : galnetNewses) {
                    if (galnetNews.getUid() == tag) {
                        Intent newsActivity = new Intent(view.getContext(), NewsActivity.class);
                        newsActivity.putExtra("NEWS", galnetNews);
                        view.getContext().startActivity(newsActivity);
                    }
                }
            }
        });

        return new GalnetNewsHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(GalnetRecyclerAdapter.GalnetNewsHolder holder, int position) {
        GalnetNews news = galnetNewses.get(position);
        holder.bindNews(news);
    }

    @Override
    public int getItemCount() {
        return galnetNewses.size();
    }

    public static class GalnetNewsHolder extends RecyclerView.ViewHolder {

        private LinearLayout newsLayout;
        private TextView head;
        private TextView date;
        private TextView summary;

        public GalnetNewsHolder(View itemView) {
            super(itemView);

            newsLayout = (LinearLayout) itemView;
            head = (TextView) itemView.findViewById(R.id.news_head);
            date = (TextView) itemView.findViewById(R.id.news_date);
            summary = (TextView) itemView.findViewById(R.id.news_summary);
        }

        /*@Override
        public void onClick(View view) {
//            String head;
//            String date;
//            String body;
//
//            head = ((TextView) view.findViewById(R.id.news_head)).getText().toString();
//            date = ((TextView) view.findViewById(R.id.news_date)).getText().toString();
//            body = ((TextView) view.findViewById(R.id.news_summary)).getText().toString();
//
//            Intent newsActivity = new Intent(view.getContext(), NewsActivity.class);
//            newsActivity.putExtra("HEAD", head);
//            newsActivity.putExtra("DATE", date);
//            newsActivity.putExtra("BODY", body);
//            view.getContext().startActivity(newsActivity);

            Log.d("RecyclerView", "CLICK!");
        }*/

        public void bindNews(GalnetNews news) {
            head.setText(news.getHead());
            date.setText(news.getDate());
            summary.setText(news.getSummary());

            newsLayout.setTag(news.getUid());
        }
    }
}
