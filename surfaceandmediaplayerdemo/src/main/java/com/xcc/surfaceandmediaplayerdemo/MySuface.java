package com.xcc.surfaceandmediaplayerdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by 徐陈承 on 2016/11/3.
 */

public class MySuface extends SurfaceView {
    public SurfaceHolder holder;
    boolean flag=true;
    public MySuface(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MySuface(Context context) {
        super(context);
        init();
    }

    public MySuface(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        holder=getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                  new MYdrawThread().start();
                flag=true;
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                  flag=false;
            }
        });
    }


    class MYdrawThread extends Thread{
        Paint paintRect;
        Paint paintText;
        //绘制的文本信息
        int count=60;

        public  MYdrawThread(){
            paintRect=new Paint();
            paintRect.setColor(Color.YELLOW);
            paintText=new Paint();
            paintText.setColor(Color.BLUE);

            //设置绘制线的宽度
            paintText.setStrokeWidth(10f);
            paintText.setTextSize(15);
        }

        @Override
        public void run() {
            super.run();
            Canvas canvas;

            while (flag){
                canvas=holder.lockCanvas();
                //创建矩形
                Rect rect=new Rect(20,100,120,200);
                //倒计时
                if(count==0){
                    count=60;
                    canvas.drawText("倒计时开始"+count--,30,120,paintText);
                }else{
                    canvas.drawText("倒计时"+count--,30,120,paintText);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
