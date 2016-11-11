package com.xcc.retrofit_rxandroid_mvp_demo.view.iview;

import com.xcc.retrofit_rxandroid_mvp_demo.bean.Cook;

import java.util.List;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public interface MyView extends MVPView{

    void showView(List<Cook> list);
}
