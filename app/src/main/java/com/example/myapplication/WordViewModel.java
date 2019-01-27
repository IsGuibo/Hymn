package com.example.myapplication;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;
public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<ZMS>> mAllWords;
    private LiveData<List<ZMS>> mQueryWords;
    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
    }
    LiveData<List<ZMS>> getAllWords() {

        mAllWords = mRepository.getAllWords();
        return mAllWords;
    }
    LiveData<List<ZMS>> getWords() {
        mAllWords = mRepository.getWords();
        return mAllWords;
    }
    LiveData<List<ZMS>> getQueryWords(String queryStr) {
        mQueryWords = mRepository.getQueryWords(queryStr);
        return mQueryWords;
    }
}
