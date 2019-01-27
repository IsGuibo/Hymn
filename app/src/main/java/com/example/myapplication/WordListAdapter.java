package com.example.myapplication;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private Context mContext;

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final CardView wordItemView;
        private final TextView mTextView;
        private final ImageView mImageView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.card);
            mTextView = itemView.findViewById(R.id.textView);
            mImageView = itemView.findViewById(R.id.fruit_image_view);
        }
    }

    private final LayoutInflater mInflater;
    private List<ZMS> mZMS = Collections.emptyList(); // Cached copy of words

    WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) mContext = parent.getContext();
        View itemView = mInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);
        final WordViewHolder holder = new WordViewHolder (itemView);
        holder.wordItemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position;
                        position = holder.getAdapterPosition();
                        ZMS zms = mZMS.get(position);
                        Intent intent = new Intent(mContext, MainActivity.class);
                        intent.putExtra("page",zms.page);
                        intent.putExtra("name",zms.Name);
                        intent.putExtra("Image",zms.ImageUrl);
                        intent.putExtra("Music",zms.MusicUrl);
                        mContext.startActivity(intent);
                    }
                }
        );
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        ZMS current = mZMS.get(position);
        holder.mTextView.setText(current.Name);
        String url = current.ImageUrl;
        Glide.with(mContext).load(url).load(url)
                .thumbnail(Glide.with(mContext)
                        .load(R.drawable.loade))
                .into(holder.mImageView);
    }

    void setWords(List<ZMS> words) {
        mZMS = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mZMS.size();
    }
}


