package com.xcc.retrofit_rxandroid_mvp_demo.presenter;

import com.xcc.retrofit_rxandroid_mvp_demo.bean.Tngou;
import com.xcc.retrofit_rxandroid_mvp_demo.model.MainAcModel;
import com.xcc.retrofit_rxandroid_mvp_demo.model.MyModel;
import com.xcc.retrofit_rxandroid_mvp_demo.view.iview.MyView;

import rx.functions.Action1;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public class MainAcPresenter extends BasePresenter<MyView> {

    private MyModel<Tngou> myModel;

    public MainAcPresenter(){
        myModel=new MainAcModel();
    }

    public void load(){
     myModel.loadData(new Action1<Tngou>() {
         @Override
         public void call(Tngou tngou) {
             getView().showView(tngou.getTngou());
         }
     });
    }
}
