package com.example.jiangqiangwei.videoviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by jiangqiangwei on 16/10/9.
 * 继承videoview重写onMeasure方法(控制显示全屏)
 */

public class MyFullVideoView extends VideoView {
    public MyFullVideoView(Context context) {
        super(context);
    }

    public MyFullVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //重新计算宽高
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        //进行设置
        setMeasuredDimension(width, height);
    }
}
