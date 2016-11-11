package com.xcc.xinxingdonghua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * 1、爱心出现在底部并且水平居中
 * 2、爱心的颜色/类型 随机
 * 3、爱心进入时候有一个缩放的动画
 * 4、缩放完毕后,开始变速向上移动,并且伴随alpha渐变效果
 * 5、爱心移动的轨迹光滑,是个曲线
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PeriscopeLayout periscopeLayout= (PeriscopeLayout) findViewById(R.id.periscope);
        periscopeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                periscopeLayout.addHeart();
            }
        });


    }
}
