package com.xcc.retrofit_rxandroid_mvp_demo.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xcc.retrofit_rxandroid_mvp_demo.presenter.BasePresenter;
import com.xcc.retrofit_rxandroid_mvp_demo.view.iview.MVPView;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public abstract class BaseActivity<V extends MVPView,T extends BasePresenter> extends AppCompatActivity {
      public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=createPresenter();
        presenter.attch((V) this);
        

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deAttch();
    }


    public abstract T createPresenter();
}
