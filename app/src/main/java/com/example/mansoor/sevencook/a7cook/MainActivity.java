package com.example.mansoor.sevencook.a7cook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.android.volley.Response;
import com.example.mansoor.sevencook.a7cook.Adapters.BannerAdapter;
import com.example.mansoor.sevencook.a7cook.Adapters.CategorisAdapter;
import com.example.mansoor.sevencook.a7cook.Adapters.RecipeAdapter;
import com.example.mansoor.sevencook.a7cook.data.Banner;
import com.example.mansoor.sevencook.a7cook.data.Category;
import com.example.mansoor.sevencook.a7cook.data.Recipe;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         apiService=new ApiService(this);



        setupViews();
    }
    private void setupViews(){
        Toolbar toolbar=findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getBanners();
        getCaregories();
        getRecipes();

    }
    private void getRecipes(){

        apiService.getRecipec(new Response.Listener<List<Recipe>>() {
            @Override
            public void onResponse(List<Recipe> recipes) {
                RecyclerView recipeRv=findViewById(R.id.rv_main_recip);
                recipeRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                recipeRv.setAdapter(new RecipeAdapter(recipes
                ));
            }
        });

    }
    private void getCaregories(){
        apiService.getCategories(new Response.Listener<List<Category>>() {
            @Override
            public void onResponse(List<Category> categories) {
                RecyclerView categortyRv=findViewById(R.id.rv_main_caregory);
                categortyRv.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                categortyRv.setAdapter(new CategorisAdapter(categories));

            }
        });

    }
    private void getBanners(){
        apiService.getBanners(new Response.Listener<List<Banner>>() {
            @Override
            public void onResponse(List<Banner> banners) {
                RecyclerView bannerRc=findViewById(R.id.rv_main_slider);
                bannerRc.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                bannerRc.setAdapter(new BannerAdapter(banners));
                SnapHelper snapHelper=new PagerSnapHelper();
                snapHelper.attachToRecyclerView(bannerRc);
            }
        });


    }

}
