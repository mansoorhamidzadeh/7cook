package com.example.mansoor.sevencook.a7cook.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mansoor.sevencook.a7cook.data.Banner;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    private List<Banner> banners;

    public BannerAdapter(List<Banner> banners) {
        this.banners = banners;

    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imageView.setAdjustViewBounds(true);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.bindBanner(banners.get(position));

    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {

        private ImageView bannerIv;

        public BannerViewHolder(View itemView) {
            super(itemView);
            bannerIv = (ImageView) itemView;
        }

        public void bindBanner(Banner banner) {
            Picasso.get().load(banner.getImg()).into(bannerIv);

        }
    }
}
