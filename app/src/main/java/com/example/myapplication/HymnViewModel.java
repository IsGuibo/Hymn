package com.example.myapplication;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;
public class HymnViewModel extends AndroidViewModel {
    private HymnRepository mRepository;
    private LiveData<List<Hymn>> mAllWords;
    private LiveData<List<Hymn>> mQueryWords;
    public HymnViewModel(Application application) {
        super(application);
        mRepository = new HymnRepository(application);
    }
    LiveData<List<Hymn>> getAllWords() {

        mAllWords = mRepository.getAllWords();
        return mAllWords;
    }
    LiveData<List<Hymn>> getWords() {
        mAllWords = mRepository.getWords();
        return mAllWords;
    }
    LiveData<List<Hymn>> getQueryWords(String queryStr) {
        mQueryWords = mRepository.getQueryWords(queryStr);
        return mQueryWords;
    }
}
