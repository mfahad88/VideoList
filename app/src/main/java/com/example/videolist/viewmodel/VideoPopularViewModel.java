package com.example.videolist.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.videolist.client.ApiClient;
import com.example.videolist.models.videopopular.Popular;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoPopularViewModel extends ViewModel {
    private MutableLiveData<Popular> mutableLiveData;

    public LiveData<Popular> getPopularVideos(int pageCount){
        if(mutableLiveData==null){
            mutableLiveData=new MutableLiveData<>();
        }
        ApiClient.getInstance().videoPopular(pageCount).enqueue(new Callback<Popular>() {
            @Override
            public void onResponse(Call<Popular> call, Response<Popular> response) {
                if(response.isSuccessful()){
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Popular> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return mutableLiveData;
    }
}
