package com.xcc.mvpdemo.presenter;

import com.xcc.mvpdemo.view.iview.MvpView;

import java.lang.ref.WeakReference;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public class BasePresenter<V extends MvpView> {
    private WeakReference<V> weakReference;

    public void attch(V mvpView){
        weakReference=new WeakReference(mvpView);
    }

    public void deAttch(){
        if(weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }

    public V getView(){
        return weakReference.get();
    }

}
