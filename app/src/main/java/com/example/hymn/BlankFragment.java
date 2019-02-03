package com.example.hymn;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.List;
import java.util.Objects;

public class BlankFragment extends Fragment {
    public static Fragment newInstance(){return  new BlankFragment();}
    Context context;
    public RecyclerView mRecyclerView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(Objects.requireNonNull(view), savedInstanceState);
        mRecyclerView=view.findViewById(R.id.recyclerView10);
        context = getActivity();
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(context);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HymnViewModel mHymnViewModel = ViewModelProviders.of(this).get(HymnViewModel.class);
        mHymnViewModel.getWords().observe(this, new Observer<List<Hymn>>() {
            @Override
            public void onChanged(@Nullable final List<Hymn> words) { adapter.setWords(words); }});
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());

    }

}
