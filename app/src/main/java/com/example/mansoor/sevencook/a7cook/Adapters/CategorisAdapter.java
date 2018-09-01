package com.example.mansoor.sevencook.a7cook.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mansoor.sevencook.a7cook.R;
import com.example.mansoor.sevencook.a7cook.data.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategorisAdapter extends RecyclerView.Adapter<CategorisAdapter.CategoriesViewHolder> {
    private List<Category> categories;
    public CategorisAdapter(List<Category> categories){
        this.categories=categories;

    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_category,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        holder.bindCategory(categories.get(position));

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public  class CategoriesViewHolder extends RecyclerView.ViewHolder {

        private ImageView  categoryIcon;
        private TextView categoryTitle;


        public CategoriesViewHolder(View itemView) {
            super(itemView);
            categoryIcon=itemView.findViewById(R.id.iv_categoy_icon);
            categoryTitle=itemView.findViewById(R.id.tv_category_title);
        }

        public void bindCategory(Category category){
            Picasso.get().load(category.getImg()).into(categoryIcon);
            categoryTitle.setText(category.getTitle());

        }
    }
}
