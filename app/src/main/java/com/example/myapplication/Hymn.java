package com.example.myapplication;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Hymn")
public class Hymn {
    @PrimaryKey
    @NonNull
    public String Name;

    @ColumnInfo(name = "page")
    public int page;

    @ColumnInfo(name = "ImageUrl")
    String ImageUrl;

    @ColumnInfo(name = "MusicUrl")
    String MusicUrl;

    public Hymn() {

    }
    @Ignore
    public Hymn(@NonNull String nName, int nPage, String nImageUrl, String nMusicUrl) {
        Name= nName;
        page = nPage;
        ImageUrl = nImageUrl;
        MusicUrl = nMusicUrl;
    }
}
