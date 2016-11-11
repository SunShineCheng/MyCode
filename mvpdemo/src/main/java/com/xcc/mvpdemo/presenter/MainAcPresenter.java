package com.xcc.mvpdemo.presenter;

import com.xcc.mvpdemo.model.MainAcModel;
import com.xcc.mvpdemo.model.MainModel2;
import com.xcc.mvpdemo.model.MvpModel;
import com.xcc.mvpdemo.view.iview.MvpView;

import java.util.List;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public class MainAcPresenter extends BasePresenter<MvpView> {
//    private MvpView mvpView;
    private MvpModel mvpModel;

//   public MainAcPresenter(MvpView mvpView){
//        this.mvpView=mvpView;
//       mvpModel=new MainAcModel();
//   }


    public MainAcPresenter() {
        mvpModel=new MainAcModel();
    }

    public MainAcPresenter setModel(int model){
        switch (model){
            case 0:
                mvpModel=new MainAcModel();
                break;

            case 1:
                 mvpModel=new MainModel2();
                break;
        }
        return this;
    }

    public void load(){
        mvpModel.getData(new MvpModel.OnCompleteListener() {
            @Override
            public void onLoadComplete(List<String> list) {
                getView().showView(list);

            }
        });
    }
}
