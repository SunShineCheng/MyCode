package com.xcc.retrofit_rxandroid_mvp_demo.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xcc.retrofit_rxandroid_mvp_demo.R;
import com.xcc.retrofit_rxandroid_mvp_demo.bean.Cook;

import java.util.List;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public class MyAdapter extends MyBaseAdapter<Cook> {

    private List<Cook> list;

    public MyAdapter(int id, List<Cook> list) {
        super(id, list);
        this.list=list;
    }

    @Override
    public void fillData(int position, MyHolder myHolder) {
        Cook cook=list.get(position);
        ( (TextView)myHolder.findView(R.id.name)).setText(cook.getName());
        ((TextView)myHolder.findView(R.id.des)).setText(cook.getDescription());
        Picasso.with(myHolder.getConvertView().getContext())
                .load("http://tnfs.tngou.net/image"+cook.getImg())
                .into((ImageView) myHolder.findView(R.id.iv))
             ;
    }
}
