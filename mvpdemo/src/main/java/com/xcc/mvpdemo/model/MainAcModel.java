package com.xcc.mvpdemo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public class MainAcModel implements MvpModel {
    @Override
    public void getData(OnCompleteListener onCompleteListener) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            list.add("这是第"+i+"条数据");
        }
        if(onCompleteListener!=null){
            onCompleteListener.onLoadComplete(list);
        }
    }
}
