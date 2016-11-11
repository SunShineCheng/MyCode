package com.xcc.retrofit_rxandroid_mvp_demo.bean;

import java.util.List;

/**
 * Created by 徐陈承 on 2016/11/10.
 */

public class Tngou {
    private boolean status;
    private int total;
    private List<Cook> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Cook> getTngou() {

        return tngou;
    }

    public void setTngou(List<Cook> tngou) {
        this.tngou = tngou;
    }
}
