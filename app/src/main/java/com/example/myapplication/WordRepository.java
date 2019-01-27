package com.example.myapplication;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import java.util.List;
class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<ZMS>> mAllWords;
    private LiveData<List<ZMS>> mQueryWords;
    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();

    }
    LiveData<List<ZMS>> getAllWords() {
        mAllWords = mWordDao.getAlphabetizedWords();
        return mAllWords;
    }
    LiveData<List<ZMS>> getWords() {
        mAllWords = mWordDao.getWords();
        return mAllWords;
    }
    LiveData<List<ZMS>> getQueryWords(String queryStr) {
        mQueryWords = mWordDao.daoGetQueryWords(queryStr);
        return mQueryWords;
    }

}
