package com.example.videolist.client;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;

import com.example.videolist.interfaces.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {


    public static final String BASE_URL = "https://api.pexels.com/";

    private static Retrofit retrofit = null;

    private static Handler handler;


    @SuppressLint("NewApi")
    public static synchronized ApiInterface getInstance() {

        if (retrofit==null) {
            handler=new Handler();
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .serializeNulls()
                    .setPrettyPrinting()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .validateEagerly(true)
                    .addConverterFactory(GsonConverterFactory.create(gson))
//                      .callbackExecutor(Executors.newCachedThreadPool())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                    .client(getRequestHeader())
                    .build();
        }

        return retrofit.create(ApiInterface.class);
    }



    private static OkHttpClient getRequestHeader() {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Dispatcher dispatcher=new Dispatcher();
        dispatcher.setMaxRequests(2);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request=chain.request().newBuilder().addHeader("Authorization","563492ad6f91700001000001d8fbaeb826894a75bdc83bb4fa861476").build();

                        Response response = null;
                        boolean responseOK = false;
                        int tryCount = 0;
                        while(!responseOK){

                            try {

                                response = chain.proceed(request);
                                responseOK = response.isSuccessful();
                            }catch (Exception e){

                                try {
                                    Log.e("intercept", "Request is not successful - " + tryCount);
                                    Thread.sleep(100);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }finally{
                                tryCount++;
                            }

                        }
                        return response;
                    }
                })
                .dispatcher(dispatcher)
                .addInterceptor(interceptor)
                .connectTimeout(40, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .writeTimeout(20, TimeUnit.MINUTES)
                .retryOnConnectionFailure(true)
                .followRedirects(false)
                .followSslRedirects(false)
                .build();

        return httpClient;
    }



}