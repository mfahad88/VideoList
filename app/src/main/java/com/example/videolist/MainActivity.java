package com.example.videolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.videolist.adapter.PopularVideoAdapter;
import com.example.videolist.client.ApiClient;
import com.example.videolist.models.videopopular.Popular;
import com.example.videolist.viewmodel.VideoPopularViewModel;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private int pageCount=1;
    private static final int PAGE_MAX=10;
    private VideoPopularViewModel videoPopularViewModel;
    private RecyclerView recyclerView;
    private PopularVideoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        videoPopularViewModel= ViewModelProviders.of(this).get(VideoPopularViewModel.class);


        videoPopularViewModel.getPopularVideos(pageCount).observe(this, new Observer<Popular>() {
            @Override
            public void onChanged(Popular popular) {
                if(pageCount<PAGE_MAX){

//                    Toast.makeText(MainActivity.this, ""+popular.toString(), Toast.LENGTH_SHORT).show();
                    adapter=new PopularVideoAdapter(MainActivity.this,popular.getVideos().get(0).getVideoPictures(),popular.getVideos().get(0).getVideoFiles());
                    recyclerView.setAdapter(adapter);
                    pageCount++;
                }
            }
        });


    }
}