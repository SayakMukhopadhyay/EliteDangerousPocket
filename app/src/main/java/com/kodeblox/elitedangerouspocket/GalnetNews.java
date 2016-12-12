package com.kodeblox.elitedangerouspocket;

/**
 * Created by mukho on 12-12-2016.
 */
public class GalnetNews {

    private String head;
    private String date;
    private String summary;
    private String link;

    public GalnetNews(String head, String date, String summary, String link) {
        this.head = head;
        this.date = date;
        this.summary = summary;
        this.link = link;
    }

    public String getHead() {
        return head;
    }

    public String getDate() {
        return date;
    }

    public String getSummary() {
        return summary;
    }

    public String getLink() {
        return link;
    }
}
