package com.xcc.mvpdemo.model;

import java.util.List;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public interface MvpModel {
    //获取数据
    void getData(OnCompleteListener onCompleteListener);//通过接口回调传回值


    public interface OnCompleteListener{
        void onLoadComplete(List<String> list);
    }
}
