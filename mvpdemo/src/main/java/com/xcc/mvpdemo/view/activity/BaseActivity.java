package com.xcc.mvpdemo.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xcc.mvpdemo.presenter.BasePresenter;
import com.xcc.mvpdemo.view.iview.MvpView;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public abstract class BaseActivity<V extends MvpView,T extends BasePresenter<V>> extends AppCompatActivity{

    public T basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter=getBasePresenter();
        basePresenter.attch((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        basePresenter.deAttch();
    }

    public abstract T getBasePresenter();
}
