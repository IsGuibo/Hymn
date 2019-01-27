package com.example.myapplication;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
@Dao
public interface WordDao {
    @Query("SELECT * from ZMS WHERE page<=525 ORDER BY page ASC")
    LiveData<List<ZMS>> getWords();
    @Query("SELECT * from ZMS WHERE page>=600 ORDER BY page ASC")
    LiveData<List<ZMS>> getAlphabetizedWords();
    @Query("SELECT * from ZMS WHERE Name LIKE :queryStr ORDER BY page ASC")
    LiveData<List<ZMS>> daoGetQueryWords(String queryStr);
    @Insert
    void insert(ZMS word);
    @Query("DELETE FROM ZMS")
    void deleteAll();
}
