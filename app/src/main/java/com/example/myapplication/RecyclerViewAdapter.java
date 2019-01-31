package com.example.myapplication;
import android.app.ActivityOptions;
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
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.HymnViewHolder> {
    private Context mContext;


    class HymnViewHolder extends RecyclerView.ViewHolder {
        private final CardView wordItemView;
        private final TextView mTextView;
        private final ImageView mImageView;

        private HymnViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.card);
            mTextView = itemView.findViewById(R.id.textView);
            mImageView = itemView.findViewById(R.id.fruit_image_view);
        }

    }

    private final LayoutInflater mInflater;
    private List<Hymn> mZMS = Collections.emptyList(); // Cached copy of words

    RecyclerViewAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public HymnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) mContext = parent.getContext();
        View itemView = mInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);
        return new HymnViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HymnViewHolder holder, int position) {
        Hymn current = mZMS.get(position);
        holder.mTextView.setText(current.Name);
        String url = current.ImageUrl;
        Glide.with(mContext).load(url).load(url)
                .thumbnail(Glide.with(mContext)
                        .load(R.drawable.loade))
                .into(holder.mImageView);
        holder.wordItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getLayoutPosition(); // 1
                Hymn hymn = mZMS.get(position);
                Intent intent = new Intent(mContext, MainActivity.class);
                intent.putExtra("page", hymn.page);
                intent.putExtra("name", hymn.Name);
                intent.putExtra("Image", hymn.ImageUrl);
                intent.putExtra("Music", hymn.MusicUrl);
                mContext.startActivity(intent);
            }
        });
    }
        void setWords(List<Hymn> words) {
        mZMS = words;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mZMS.size();
    }
}


