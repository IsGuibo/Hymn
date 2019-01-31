package com.example.myapplication;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
@Dao
public interface DAO {
    @Query("SELECT * from Hymn WHERE page<=525 ORDER BY page ASC")
    LiveData<List<Hymn>> getWords();
    @Query("SELECT * from Hymn WHERE page>=600 ORDER BY page ASC")
    LiveData<List<Hymn>> getAlphabetizedWords();
    @Query("SELECT * from Hymn WHERE Name LIKE :queryStr ORDER BY page ASC")
    LiveData<List<Hymn>> daoGetQueryWords(String queryStr);
    @Insert
    void insert(Hymn word);
    @Query("DELETE FROM Hymn")
    void deleteAll();
}
