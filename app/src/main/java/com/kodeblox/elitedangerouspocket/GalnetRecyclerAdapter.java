package com.kodeblox.elitedangerouspocket;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    public static class GalnetNewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView head;
        private TextView date;
        private TextView summary;

        public GalnetNewsHolder(View itemView) {
            super(itemView);

            head = (TextView) itemView.findViewById(R.id.news_head);
            date = (TextView) itemView.findViewById(R.id.news_date);
            summary = (TextView) itemView.findViewById(R.id.news_summary);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d("RecyclerView", "CLICK!");
        }

        public void bindNews(GalnetNews news) {
            head.setText(news.getHead());
            date.setText(news.getDate());
            summary.setText(news.getSummary());
        }
    }
}
