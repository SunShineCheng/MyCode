package com.xcc.retrofit_rxandroid_mvp_demo.presenter;

import com.xcc.retrofit_rxandroid_mvp_demo.view.iview.MVPView;

import java.lang.ref.WeakReference;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public class BasePresenter<V extends MVPView> {
     private WeakReference<V> weakReference;

    public void attch(V v){
        weakReference=new WeakReference<V>(v);
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
