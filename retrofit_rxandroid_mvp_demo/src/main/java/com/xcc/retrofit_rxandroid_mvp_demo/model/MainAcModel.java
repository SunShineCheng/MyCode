package com.xcc.retrofit_rxandroid_mvp_demo.model;

import com.xcc.retrofit_rxandroid_mvp_demo.api.MyService;
import com.xcc.retrofit_rxandroid_mvp_demo.api.Server;
import com.xcc.retrofit_rxandroid_mvp_demo.bean.Tngou;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public class MainAcModel implements MyModel<Tngou> {
    @Override
    public void loadData(Action1<Tngou> action1) {
        //请求数据
           Observable<Tngou> dataObs=MyService.getApi(Server.class).getDataObs(1,1,20);

          dataObs.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribeOn(Schedulers.newThread()).subscribe(action1);


    }
}
