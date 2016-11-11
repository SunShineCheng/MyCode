package com.xcc.retrofit_rxandroid_mvp_demo.adapter;


import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.xcc.retrofit_rxandroid_mvp_demo.bean.Cook;

import java.util.List;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private List<Cook>  list;

    private  @LayoutRes int id;

    public MyBaseAdapter( int id,List<Cook> list) {
        this.list = list;
        this.id = id;
    }

    public MyBaseAdapter(List<Cook> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        MyHolder myHolder=MyHolder.getHolder(convertView,id,viewGroup.getContext());
       fillData(position,myHolder);
        return myHolder.getConvertView();
    }
    public abstract void fillData(int position,MyHolder myHolder);
}
