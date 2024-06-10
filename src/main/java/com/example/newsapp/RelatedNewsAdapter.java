package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.RelatedNewsViewHolder> {

    private final List<NewsItem> relatedNewsItems;

    public RelatedNewsAdapter(List<NewsItem> relatedNewsItems) {
        this.relatedNewsItems = relatedNewsItems;
    }

    @NonNull
    @Override
    public RelatedNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_related_news, parent, false);
        return new RelatedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedNewsViewHolder holder, int position) {
        holder.bind(relatedNewsItems.get(position));
    }

    @Override
    public int getItemCount() {
        return relatedNewsItems.size();
    }

    class RelatedNewsViewHolder extends RecyclerView.ViewHolder {
        private final ImageView relatedNewsImage;
        private final TextView relatedNewsTitle;

        public RelatedNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            relatedNewsImage = itemView.findViewById(R.id.related_news_image);
            relatedNewsTitle = itemView.findViewById(R.id.related_news_title);
        }

        public void bind(NewsItem newsItem) {
            Glide.with(itemView.getContext()).load(newsItem.getImageUrl()).into(relatedNewsImage);
            relatedNewsTitle.setText(newsItem.getTitle());
        }
    }
}
