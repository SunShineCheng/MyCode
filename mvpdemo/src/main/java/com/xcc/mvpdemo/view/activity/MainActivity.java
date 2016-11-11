package com.xcc.mvpdemo.view.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xcc.mvpdemo.R;
import com.xcc.mvpdemo.presenter.MainAcPresenter;
import com.xcc.mvpdemo.view.iview.MvpView;

import java.util.List;

public class MainActivity extends BaseActivity<MvpView,MainAcPresenter> implements MvpView {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
//        new MainAcPresenter(this).setModel(1).load();
        basePresenter.setModel(0).load();
    }

    @Override
    public MainAcPresenter getBasePresenter() {
        return new MainAcPresenter();
    }


    @Override
    public void showView(List<String> list) {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
        listView.setAdapter(adapter);
    }
}
