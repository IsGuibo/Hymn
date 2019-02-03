package com.example.hymn;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import java.util.List;
class HymnRepository {

    private DAO mDAO;
    private LiveData<List<Hymn>> mAllWords;
    private LiveData<List<Hymn>> mQueryWords;
    HymnRepository(Application application) {
        HymnRoomDatabase db = HymnRoomDatabase.getDatabase(application);
        mDAO = db.wordDao();

    }
    LiveData<List<Hymn>> getAllWords() {
        mAllWords = mDAO.getAlphabetizedWords();
        return mAllWords;
    }
    LiveData<List<Hymn>> getWords() {
        mAllWords = mDAO.getWords();
        return mAllWords;
    }
    LiveData<List<Hymn>> getQueryWords(String queryStr) {
        mQueryWords = mDAO.daoGetQueryWords(queryStr);
        return mQueryWords;
    }

}
