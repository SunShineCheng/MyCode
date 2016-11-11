package com.xcc.retrofit_rxandroid_mvp_demo.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public class MyService {
    private static final String SERVERURL="http://www.tngou.net/";
    private static Retrofit retrofit=new Retrofit.Builder().baseUrl(SERVERURL)
                                                           .addConverterFactory(GsonConverterFactory.create())
                                                           .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                                           .build();
    public static <T> T getApi(Class<T> tClass){
        return retrofit.create(tClass);
    }



}
