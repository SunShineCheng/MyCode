package com.xcc.retrofit_rxandroid_mvp_demo.model;

import rx.functions.Action1;

/**
 * Created by 徐陈承 on 2016/11/10.
 */




//用来获取数据的model
public interface MyModel<T> extends MVPModel{
    void loadData(Action1<T> action1);
}
