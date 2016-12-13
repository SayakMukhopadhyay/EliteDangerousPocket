package com.kodeblox.elitedangerouspocket;

import android.os.Parcel;
import android.os.Parcelable;

public class GalnetNews implements Parcelable{

    private String uid;
    private String head;
    private String date;
    private String summary;
    private String link;

    public GalnetNews(String uid, String head, String date, String summary, String link) {
        this.uid = uid;
        this.head = head;
        this.date = date;
        this.summary = summary;
        this.link = link;
    }

    protected GalnetNews(Parcel in) {
        uid = in.readString();
        head = in.readString();
        date = in.readString();
        summary = in.readString();
        link = in.readString();
    }

    public static final Creator<GalnetNews> CREATOR = new Creator<GalnetNews>() {
        @Override
        public GalnetNews createFromParcel(Parcel in) {
            return new GalnetNews(in);
        }

        @Override
        public GalnetNews[] newArray(int size) {
            return new GalnetNews[size];
        }
    };

    public String getUid() {
        return uid;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(uid);
        parcel.writeString(head);
        parcel.writeString(date);
        parcel.writeString(summary);
        parcel.writeString(link);
    }
}
