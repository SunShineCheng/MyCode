package com.xcc.retrofit_rxandroid_mvp_demo.view.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.xcc.retrofit_rxandroid_mvp_demo.R;
import com.xcc.retrofit_rxandroid_mvp_demo.adapter.MyAdapter;
import com.xcc.retrofit_rxandroid_mvp_demo.bean.Cook;
import com.xcc.retrofit_rxandroid_mvp_demo.presenter.MainAcPresenter;
import com.xcc.retrofit_rxandroid_mvp_demo.view.iview.MyView;

import java.util.List;

public class MainActivity extends BaseActivity<MyView,MainAcPresenter> implements MyView{

    private ListView listView;

    private MyAdapter mMyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listView);

      presenter.load();

    }

    @Override
    public MainAcPresenter createPresenter() {
      return new MainAcPresenter();
    }


    @Override
    public void showView(List<Cook> list) {
         mMyAdapter=new MyAdapter(R.layout.item,list);
        listView.setAdapter(mMyAdapter);

    }
}
