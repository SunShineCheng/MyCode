package com.xcc.retrofit_rxandroid_mvp_demo.api;

import com.xcc.retrofit_rxandroid_mvp_demo.bean.Tngou;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public interface Server {

    @GET("api/cook/list")
    Observable<Tngou> getDataObs(@Query("id")int id, @Query("page")int page, @Query("rows")int rows );

}
